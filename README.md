# Continuum Control

**Sistema de Gestão e Controle da Integridade Temporal**  
*Desenvolvimento de Serviços com Spring Boot*  
*Continuum Authority*

---

## 1. Visão Geral do Projeto

O **Continuum Control** é uma plataforma centralizada de monitoramento, controle e intervenção sobre a integridade da linha temporal, desenvolvida para apoiar as operações da **Continuum Authority**.

A agência monitora eventos históricos críticos e identifica divergências em relação aos acontecimentos esperados — classificadas como **anomalias temporais**. O sistema gerencia agentes de campo, investigações, missões de correção, intervenções na linha temporal, ocorrências operacionais e o encerramento de missões, fornecendo em tempo real a visão do **Estado Operacional** e o cálculo dinâmico do **Índice de Estabilidade Temporal (0 a 100)**.

---

## 2. Tecnologias Utilizadas

- **Linguagem:** Java 21
- **Framework Principal:** Spring Boot 4.x
- **Persistência Relacional:** Spring Data JPA / Hibernate
- **Banco de Dados Relacional:** PostgreSQL 16
- **Persistência NoSQL (Documentos):** Spring Data MongoDB
- **Banco de Dados NoSQL:** MongoDB 8
- **Mecanismo de Cache:** Spring Cache Abstraction (`@EnableCaching`, `@Cacheable`, `@CacheEvict`)
- **Segurança:** Spring Security, BCrypt, Auth0 Java JWT (Tokens Bearer)
- **Validação:** Jakarta Bean Validation (Hibernate Validator)
- **Testes Automatizados:** JUnit 5, Spring Boot Test (`@SpringBootTest`, `@Transactional`)
- **Conteinerização & Orquestração:** Docker e Docker Compose
- **Build Tool:** Apache Maven (com Maven Wrapper `mvnw`)

---

## 3. Fundamentação Técnica das Estratégias de Persistência

Conforme exigido na modelagem do domínio, a solução adota persistência poliglota com responsabilidades arquiteturais bem delimitadas:

```
┌────────────────────────────────────────────────────────────────────────┐
│                          CONTINUUM CONTROL                             │
└──────────┬─────────────────────────┬───────────────────────┬───────────┘
           │                         │                       │
          SQL                      NoSQL          Leitura / Baixa Latência
           ▼                         ▼                       ▼
  ┌─────────────────┐       ┌─────────────────┐     ┌─────────────────┐
  │   PostgreSQL    │       │     MongoDB     │     │  Spring Cache   │
  │  (Relacional)   │       │  (Documentos)   │     │ (Chave-Valor)   │
  └─────────────────┘       └─────────────────┘     └─────────────────┘
  • Agentes                 • Ocorrências           • Estado Operacional
  • Eventos Históricos        (6 subtipos com         (Dashboard analítico)
  • Anomalias                 estruturas            • Estabilidade Temporal
  • Missões Temporais         heterogêneas)           (Cálculo ponderado)
  • Autorizações (AO)
  • Encerramentos (EM)
  • Intervenções
  • Usuários (RBAC)
```

### 3.1. Modelo Relacional — PostgreSQL (JPA / Hibernate)
- **Problema que resolve:** Garantia de integridade referencial estrita, controle transacional atômico (ACID) e restrições de integridade entre entidades com fortes dependências relacionais.
- **Informações armazenadas:** Agentes, Eventos Históricos, Anomalias, Missões, Intervenções, Autorizações de Operação, Encerramentos e Usuários.
- **Por que é adequado:** Operações críticas de domínio — como iniciar uma missão (que altera o estado da missão para `EM_EXECUÇÃO`, altera a situação de múltiplos agentes para `EM_MISSÃO` e valida o estado da anomalia) — exigem transações atômicas com `@Transactional`. Se qualquer etapa falhar, o rollback impede inconsistências parciais no sistema.
- **Por que não manter tudo nele:** Ocorrências temporais possuem esquemas de dados altamente variáveis e imprevisíveis. Forçar esses dados em tabelas relacionais geraria tabelas com excesso de colunas nulas (*sparse columns*) ou complexos mapeamentos de herança com joins pesados.

### 3.2. Modelo NoSQL Documental — MongoDB
- **Problema que resolve:** Armazenamento flexível de dados polimórficos e heterogêneos sem esquema rígido (*schema-less*).
- **Informações armazenadas:** Coleção de `ocorrencias` registradas durante as missões.
- **Por que é adequado:** Durante uma missão, os agentes registram diferentes tipos de ocorrências que não compartilham os mesmos atributos:
  - *Distorção Temporal:* possui intensidade, raio de impacto, data de início e fim.
  - *Evidência Temporal:* possui objeto, tipo de evidência, período estimado e grau de confiabilidade.
  - *Alteração Detectada:* possui elemento afetado, estado anterior, estado atual e grau de anomalia.
  - *Encontro Inesperado, Incidente Operacional e Observação Histórica:* cada qual com campos específicos.
  O MongoDB armazena esses documentos em formato BSON nativo, preservando a identidade polimórfica (via metadado `_class`) sem perda de flexibilidade estrutural.
- **Por que não manter tudo nele:** O MongoDB não é otimizado para o rigor relacional de chave estrangeira e restrições de unicidade que o controle operacional de agentes e missões exige.

### 3.3. Mecanismo Chave-Valor — Spring Cache
- **Problema que resolve:** Sobrecarga computacional no banco relacional decorrente de consultas analíticas e repetitivas de agregação.
- **Informações armazenadas:** Resultados consolidados das rotas `GET /estabilidade` e `GET /estabilidade/estado`.
- **Por que é adequado:** O painel de controle operacional calcula agregações complexas (`COUNT`, filtros de risco, status de missões e intervenções severas) cruzando 4 tabelas diferentes. Como essa é a tela principal de monitoramento da agência (sujeita a polling frequente de múltiplos operadores), o cache em memória entrega respostas em sub-milissegundos e desacopla as consultas analíticas do banco relacional.
- **Estratégia de Invalidação:** Adota `@CacheEvict(value = {"estabilidadeTemporal", "estadoOperacional"}, allEntries = true)` nas mutações de domínio que afetam o cálculo (anomalias, missões, intervenções e agentes), garantindo consistência imediata dos dados expostos. Como o cache é global e sem TTL, a invalidação ocorre nas operações de criação, alteração, atribuição, encerramento e exclusão lógica.

---

## 4. Segurança e Controle de Acesso (RBAC)

O controle de acesso é implementado com **Spring Security** e tokens **JWT (Bearer)**, estruturado em 4 papéis hierárquicos:

| Perfil | Permissões Operacionais |
| :--- | :--- |
| **`ADMINISTRADOR`** | Acesso irrestrito a todas as rotas: gestão de usuários, cadastro e exclusão de agentes, emissão de autorizações de missão e encerramentos. |
| **`SUPERVISOR`** | Gestão operacional: classificação de anomalias, autorização de operações temporais, alteração de estados de missões e encerramentos. |
| **`OPERADOR`** | Monitoramento e consulta: cadastro de anomalias, acompanhamento do estado operacional, consulta detalhada de agentes, eventos e histórico. |
| **`AGENTE`** | Operações de campo: registro de intervenções temporais e ocorrências nas missões em que está escalado. |

### 4.1. Autorização Granular em Nível de Recurso
Além do papel `AGENTE`, o sistema aplica autorização granular:
- Um agente só tem permissão para registrar uma intervenção temporal (`POST /intervencao`) se ele fizer parte da lista de agentes participantes daquela missão específica (`m.getAgentes()`). Caso contrário, a requisição é rejeitada com erro de negócio.

### 4.2. Usuários Pré-carregados para Avaliação
O sistema inicializa automaticamente com 4 usuários (senha padrão: `123456`):

| Login | Perfil | Finalidade de Teste |
| :--- | :--- | :--- |
| `agente00` | `ROLE_ADMINISTRADOR` | Gestão administrativa completa e autorizações |
| `agente01` | `ROLE_SUPERVISOR` | Aprovação de missões e classificação |
| `agente02` | `ROLE_OPERADOR` | Monitoramento e consultas de painel |
| `agente03` | `ROLE_AGENTE` | Registro de intervenções e ocorrências de campo |

---

## 5. Pré-requisitos para Execução

- **Docker** (versão 24.0 ou superior) e **Docker Compose**
- *(Opcional para execução sem contêiner)*: **Java JDK 21+** e **Maven 3.9+**

---

## 6. Guia Passo a Passo de Execução

### 6.1. Inicialização Completa com Docker Compose

O projeto é 100% orquestrado via contêineres, inicializando o PostgreSQL, o MongoDB (com carga inicial) e a aplicação Spring Boot:

1. Clone o repositório público:
   ```bash
   git clone https://github.com/<seu-usuario>/continuum-control.git
   cd continuum-control
   ```

2. Gere o pacote executável da aplicação:
   ```bash
   # Linux / macOS
   ./mvnw clean package -DskipTests

   # Windows (PowerShell / CMD)
   .\mvnw.cmd clean package -DskipTests
   ```

3. Copie o arquivo gerado para o diretório de build do Docker:
   ```bash
   # Windows PowerShell
   Copy-Item target\continuum-control-0.0.1-SNAPSHOT.jar docker\app.jar

   # Linux / macOS
   cp target/app.jar docker/app.jar
   ```

4. Suba todo o ambiente de contêineres:
   ```bash
   cd docker
   docker compose up --build -d
   ```

5. Verifique se todos os serviços subiram:
   ```bash
   docker compose ps
   ```

---

### 6.2. Execução em Ambiente Local de Desenvolvimento (IDE / Terminal)

Caso queira executar a aplicação diretamente pela sua IDE ou via terminal conectando aos bancos no Docker:

1. Suba apenas os bancos de dados:
   ```bash
   cd docker
   docker compose up -d postgres mongodb
   ```

2. Volte para a raiz e execute a aplicação com o Maven Wrapper:
   ```bash
   cd ..
   ./mvnw spring-boot:run
   ```
   *Observação: o `application.properties` está configurado para usar os nomes dos serviços Docker (`postgres` e `mongodb`). Para execução local direta, ajuste essas URLs para `localhost` ou mantenha os bancos rodando via Docker Compose.*

---

### 6.3. Execução dos Testes Automatizados

A suíte de testes valida regras de negócio críticas (como bloqueio de missões em anomalias irreversíveis, exigência de autorização prévia e disponibilidade de agentes), executando com `@Transactional` para garantir rollback automático:

```bash
# Execução direta via Maven
./mvnw test

# Windows PowerShell
.\mvnw.cmd test
```

---

### 6.4. Verificação de Saúde da Aplicação (Healthcheck)

Com a aplicação em execução, valide sua operacionalidade:

```bash
# Verificação básica do endpoint público de estabilidade
curl http://localhost:8080/estabilidade

# Verificação do estado operacional (requer token JWT de Operador/Supervisor/Admin)
curl http://localhost:8080/estabilidade/estado -H "Authorization: Bearer <TOKEN>"
```

---

## 7. Carga Inicial de Dados (Data Seeding)

Ao iniciar, a aplicação carrega automaticamente um conjunto consistente de dados para avaliação imediata:
- **PostgreSQL (`src/main/resources/data.sql`):**
  - **46 Agentes** com diferentes situações (`DISPONÍVEL`, `EM_MISSÃO`, `SUSPENSO`, `INATIVO`) e especialidades.
  - **24 Eventos Históricos** cobrindo marcos nacionais e mundiais.
  - **32 Anomalias Temporais** em múltiplos estados e níveis de risco.
  - **32 Missões Temporais** nos estados `PLANEJADA`, `AUTORIZADA`, `EM_EXECUÇÃO`, `CONCLUÍDA`, `CANCELADA` e `FALHOU`.
  - **5 Autorizações de Operação** vinculadas a missões críticas.
  - **19 Intervenções Temporais** em missões ativas.
  - **7 Encerramentos de Missão** documentados.
  - **4 Usuários do Sistema** com senhas criptografadas em BCrypt.
- **MongoDB (`docker/mongo-init.js`):**
  - População da collection `ocorrencias` com **60 documentos**, sendo **10 exemplos de cada um dos 6 subtipos polimórficos** (`DistorcaoTemporal`, `AlteracaoDetectada`, `EvidenciaTemporal`, `EncontroInesperado`, `IncidenteOperacional` e `ObservacaoHistorica`), vinculados a missões, autores e agentes existentes.

---

## 8. Principais Endpoints da API RESTful

### 8.1. Autenticação (`/auth`)
- `POST /auth/login` — Autentica o usuário e retorna o token JWT.
- `POST /auth/register` — Cadastra novo usuário no sistema.

### 8.2. Monitoramento e Estabilidade (`/estabilidade`)
- `GET /estabilidade` — Retorna o Índice de Estabilidade Temporal (0 a 100) e classificação qualitativa (Público).
- `GET /estabilidade/estado` — Retorna a visão do Estado Operacional da Continuum Authority (Autenticado).

### 8.3. Agentes Temporais (`/agente`)
- `GET /agente` — Lista todos os agentes ativos.
- `GET /agente/{id}` — Detalha um agente específico.
- `GET /agente/disponiveis` — Filtra agentes aptos para novas missões (`DISPONÍVEL`).
- `GET /agente/situacao/{situacao}` — Filtra agentes por estado operacional.
- `GET /agente/especialidade/{especialidade}` — Filtra agentes por especialidade.
- `POST /agente` — Cadastra novo agente (`ADMINISTRADOR`).
- `DELETE /agente/{id}` — Exclusão lógica (*soft delete*, preservando histórico).

### 8.4. Anomalias Temporais (`/anomalia`)
- `GET /anomalia` — Lista anomalias cadastradas.
- `GET /anomalia/ativas` — Lista anomalias operacionais.
- `GET /anomalia/criticas` — Filtra anomalias com nível de risco `CRÍTICO`.
- `GET /anomalia/historico/{id}` — Reconstrói a linha do tempo da anomalia (agrega dados do Postgres e MongoDB).
- `POST /anomalia/classificar/risco` — Reclassifica o nível de risco de uma anomalia.

### 8.5. Missões Temporais (`/missao`)
- `GET /missao` — Lista missões.
- `GET /missao/acontecendo` — Lista missões em andamento (`EM_EXECUÇÃO`).
- `POST /missao` — Cria nova missão planejada (bloqueia se anomalia for `IRREVERSÍVEL`).
- `PUT /missao/atribuir` — Designa agentes disponíveis para a missão.
- `PUT /missao/estado/alterar` — Realiza transição controlada de ciclo de vida:
  - Exige autorização prévia para prioridade `EMERGÊNCIA` ou anomalia `CRÍTICO`.
  - Ao concluir/falhar, libera os agentes de volta para `DISPONÍVEL`.

### 8.6. Autorizações de Operação (`/autorizar-operacoes`)
- `POST /autorizar-operacoes` — Emite formalmente autorização para missões críticas (`SUPERVISOR` ou `ADMINISTRADOR`).

### 8.7. Intervenções Temporais (`/intervencao`)
- `POST /intervencao` — Registra ação de campo executada por agente participante em missão ativa.

### 8.8. Encerramento de Missões (`/encerramento`)
- `POST /encerramento` — Formaliza a conclusão ou falha de uma missão, atualiza o status final da anomalia e libera os agentes envolvidos.

### 8.9. Ocorrências NoSQL (`/ocorrencia`)
- `POST /ocorrencia` — Registra ocorrência polimórfica no MongoDB.
- `GET /ocorrencia/missao/{id}` — Lista ocorrências registradas em uma missão específica.
- `GET /ocorrencia/autor/{id}` — Lista ocorrências registradas por determinado agente.

---

## 9. Tratamento de Erros e Respostas

A API adota respostas padronizadas em JSON através do `GlobalExceptionHandler`:
- `400 Bad Request` — Parâmetros inválidos, quebra de regras de negócio ou argumentos incompatíveis.
- `401 Unauthorized` — Token ausente, expirado ou inválido.
- `403 Forbidden` — Perfil do usuário não possui permissão para o recurso solicitado.
- `404 Not Found` — Identificador não localizado nas bases de dados.
- `409 Conflict` — Conflito de estado do ciclo de vida da missão ou anomalia.
