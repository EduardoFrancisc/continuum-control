-- ============================================================================
-- Agents (agentes)
-- ============================================================================
INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('John Carl', 'ANALISE_HISTORICA', 'INATIVO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Titor Jr.', 'CONTENCAO_FISICA', 'SUSPENSO', true);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Guilherme Santos', 'INVESTIGACAO', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('João Lopes', 'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Augusto Adoeça', 'ANALISE_HISTORICA', 'INATIVO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Ronaldo Subido', 'CONTENCAO_FISICA', 'EM_MISSÃO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Renan Demons', 'INVESTIGACAO', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Luís Inocêncio', 'ENGENHARIA_TEMPORAL', 'SUSPENSO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Marcos Silva', 'ANALISE_HISTORICA', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Ana Martins', 'CONTENCAO_FISICA', 'EM_MISSÃO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Carlos Oliveira', 'INVESTIGACAO', 'INATIVO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Beatriz Souza', 'ENGENHARIA_TEMPORAL', 'SUSPENSO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Rafael Costa', 'ANALISE_HISTORICA', 'EM_MISSÃO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Fernanda Alves', 'CONTENCAO_FISICA', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Lucas Pereira', 'INVESTIGACAO', 'SUSPENSO', true);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Camila Rocha', 'ENGENHARIA_TEMPORAL', 'INATIVO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Diego Ferreira', 'ANALISE_HISTORICA', 'SUSPENSO', true);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Juliana Mendes', 'CONTENCAO_FISICA', 'INATIVO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Thiago Ramos', 'INVESTIGACAO', 'EM_MISSÃO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Larissa Barbosa', 'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Eduardo Nunes', 'INVESTIGACAO', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Patrícia Andrade', 'ANALISE_HISTORICA', 'DISPONÍVEL', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Ricardo Teixeira', 'ENGENHARIA_TEMPORAL', 'EM_MISSÃO', false);

INSERT INTO agentes (nome, especialidade, situacao, is_deleted)
VALUES ('Sofia Cavalcante', 'CONTENCAO_FISICA', 'DISPONÍVEL', false);

-- ============================================================================
-- Eventos históricos (eventos_historicos)
-- ============================================================================
INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Descobrimento do Brasil',
        'Chegada da frota portuguesa ao território brasileiro.',
        '1500-04-22',
        '1500-04-22',
        'CRÍTICA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Independência do Brasil',
        'Proclamação da independência do Brasil em relação a Portugal.',
        '1822-09-07',
        '1822-09-07',
        'CRÍTICA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Proclamação da República',
        'Mudança do regime político brasileiro de monarquia para república.',
        '1889-11-15',
        '1889-11-15',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Abolição da Escravatura',
        'Assinatura da Lei Áurea, que aboliu oficialmente a escravidão no Brasil.',
        '1888-05-13',
        '1888-05-13',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Revolução de 1930',
        'Movimento político que levou Getúlio Vargas ao poder e encerrou a República Velha.',
        '1930-10-03',
        '1930-10-24',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Era Vargas',
        'Período da história brasileira marcado pelos governos de Getúlio Vargas.',
        '1930-11-03',
        '1945-10-29',
        'MODERADA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Constituição de 1988',
        'Promulgação da Constituição Federal que marcou a redemocratização do Brasil.',
        '1988-10-05',
        '1988-10-05',
        'MODERADA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Inauguração de Brasília',
        'Inauguração da nova capital federal do Brasil.',
        '1960-04-21',
        '1960-04-21',
        'MODERADA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Diretas Já',
        'Movimento popular que reivindicava eleições diretas para presidente do Brasil.',
        '1983-05-01',
        '1984-04-25',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Guerra de Canudos',
        'Conflito entre forças do governo brasileiro e a comunidade de Canudos.',
        '1896-11-01',
        '1897-10-05',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Inconfidência Mineira',
        'Movimento de caráter separatista ocorrido na capitania de Minas Gerais.',
        '1789-01-01',
        '1789-05-23',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Chegada da Família Real ao Brasil',
        'Transferência da corte portuguesa para o Brasil durante as Guerras Napoleônicas.',
        '1808-01-22',
        '1808-01-22',
        'BAIXA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Golpe Militar de 1964',
        'Movimento que depôs o presidente João Goulart e iniciou o regime militar brasileiro.',
        '1964-03-31',
        '1964-04-01',
        'ALTA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Impeachment de Fernando Collor',
        'Processo de impeachment que resultou no afastamento do presidente Fernando Collor de Mello.',
        '1992-09-29',
        '1992-12-29',
        'BAIXA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Plano Real',
        'Implementação do plano econômico que criou o Real e estabilizou a economia brasileira.',
        '1994-07-01',
        '1994-07-01',
        'BAIXA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Confederação da Tordesilhas',
        'Tratado firmado entre Portugal e Espanha que dividiu as terras discoveries entre as duas coroas.',
        '1494-06-07',
        '1494-06-07',
        'CRÍTICA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Revolta da Armada',
        'Movimento de oficiais da Marinha contra o governo de Floriano Peixoto.',
        '1893-09-23',
        '1894-03-11',
        'MODERADA',
        false);

INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted)
VALUES ('Proclamação da Independência Argentina',
        'Proclamação da República de Tucumán, na Argentina, que rompia com a monarquia espanhola.',
        '1816-07-09',
        '1816-07-09',
        'BAIXA',
        false);

-- ============================================================================
-- Anomalias (anomalias)
-- ============================================================================
INSERT INTO anomalias (
    evento_id,
    nome,
    divergencia,
    data_deteccao,
    risco,
    estado,
    origem,
    observacoes,
    is_active,
    is_deleted
) VALUES
      (
          1,
          'Inconsistência temporal',
          'A data do evento diverge dos registros históricos conhecidos.',
          '2025-01-15',
          'ALTO',
          'DETECTADA',
          'Arquivo histórico',
          'Necessário revisar os documentos originais para confirmar a data correta.',
          TRUE,
          FALSE
      ),
      (
          2,
          'Alteração de identidade',
          'O nome registrado diverge dos documentos históricos associados ao indivíduo.',
          '2025-02-03',
          'CRÍTICO',
          'EM_ANÁLISE',
          'Registro civil',
          'Existem registros com nomes diferentes associados ao mesmo indivíduo.',
          TRUE,
          FALSE
      ),
      (
          3,
          'Documento duplicado',
          'Dois documentos apresentam conteúdo semelhante, mas identificadores diferentes.',
          '2025-02-18',
          'MODERADO',
          'DETECTADA',
          'Arquivo digital',
          'Verificar se a duplicidade foi causada por erro de digitalização.',
          TRUE,
          FALSE
      ),
      (
          4,
          'Localização divergente',
          'O local informado no evento difere do local mencionado em outras fontes.',
          '2025-03-10',
          'ALTO',
          'EM_ANÁLISE',
          'Relato testemunhal',
          'Comparar os relatos disponíveis e verificar possíveis alterações nos limites territoriais.',
          TRUE,
          FALSE
      ),
      (
          5,
          'Cronologia inconsistente',
          'A sequência dos acontecimentos não corresponde à cronologia documentada.',
          '2025-03-22',
          'CRÍTICO',
          'CONFIRMADA',
          'Pesquisa documental',
          'A inconsistência foi confirmada após a comparação de múltiplas fontes históricas.',
          TRUE,
          FALSE
      ),
      (
          6,
          'Ausência de documentação',
          'Não foram encontrados documentos que comprovem uma informação registrada no evento.',
          '2025-04-05',
          'BAIXO',
          'ESTABILIZADA',
          'Acervo institucional',
          'A documentação complementar foi localizada e anexada ao registro histórico.',
          TRUE,
          FALSE
      ),
      (
          7,
          'Informação contraditória',
          'Duas fontes apresentam versões incompatíveis sobre o mesmo acontecimento.',
          '2025-04-17',
          'ALTO',
          'EM_CORREÇÃO',
          'Jornal da época',
          'Os registros estão sendo revisados para determinar qual versão apresenta maior consistência.',
          TRUE,
          FALSE
      ),
      (
          8,
          'Registro de autoria incorreta',
          'A autoria atribuída ao documento diverge da identificação encontrada no arquivo original.',
          '2025-05-02',
          'MODERADO',
          'DETECTADA',
          'Catálogo documental',
          'Aguardando validação da autoria por especialista em documentos históricos.',
          TRUE,
          FALSE
      ),
      (
          9,
          'Data de nascimento incompatível',
          'A data de nascimento registrada não corresponde à idade informada em outro documento.',
          '2025-05-19',
          'BAIXO',
          'ESTABILIZADA',
          NULL,
          'A data foi corrigida após consulta ao registro civil original.',
          TRUE,
          FALSE
      ),
      (
          10,
          'Possível falsificação documental',
          'Foram identificadas diferenças na assinatura e na formatação do documento analisado.',
          '2025-06-11',
          'CRÍTICO',
          'IRREVERSÍVEL',
          'Análise pericial',
          'As características identificadas indicam possível adulteração documental que não pode ser revertida no registro original.',
          TRUE,
          FALSE
      ),
      (
          11,
          'Margem temporal incorreta',
          'O período de duração do evento está menor do que o previsto nas fontes consultadas.',
          '2025-07-02',
          'MODERADO',
          'DETECTADA',
          'Crônica setecentista',
          'Reconstruir o cronograma completo do conflito a partir dos relatos disponíveis.',
          TRUE,
          FALSE
      ),
      (
          12,
          'Divergência geopolítica',
          'As fronteiras citadas no evento não correspondem à cartografia histórica do período.',
          '2025-07-28',
          'ALTO',
          'EM_ANÁLISE',
          'Mapa de época',
          'A cartografia do século XVIII apresenta limites diferentes dos registrados na base de dados.',
          TRUE,
          FALSE
      ),
      (
          13,
          'Lacuna na cadeia de custódia',
          'Não há registro de rastreabilidade entre a digitalização e o documento físico.',
          '2025-08-09',
          'MODERADO',
          'CONFIRMADA',
          'Arquivo morto',
          'A cadeia de custódia foi rompida durante a restauração do acervo.',
          TRUE,
          FALSE
      ),
      (
          14,
          'Registro inexistente no acervo',
          'O documento citado como fonte do evento não consta no acervo digital atual.',
          '2025-09-01',
          'BAIXO',
          'EM_CORREÇÃO',
          'Acervo digital',
          'Solicitado o reinstatement temporário da ficha física para conferência.',
          TRUE,
          FALSE
      ),
      (
          15,
          'Metadados corrompidos',
          'Os metadados de digitalização apresentam valores fora do padrão esperado para a época.',
          '2025-09-23',
          'ALTO',
          'DETECTADA',
          'Servidor de arquivamento',
          'Recuperar os metadados originais a partir do backup do servidor de armazenamento.',
          TRUE,
          FALSE
      ),
      (
          16,
          'Classificação de risco alterada',
          'A importância atribuída ao evento diverge da classificação oficial vigente no período.',
          '2025-10-07',
          'CRÍTICO',
          'EM_ANÁLISE',
          'Norma historiográfica',
          'Aguardando parecer do conselho histórico antes de qualquer correção definitiva.',
          TRUE,
          FALSE
      );

-- ============================================================================
-- Missões (missoes)
-- ============================================================================
-- Insert na tabela principal de missões
INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (1, 'Investigar anacronismo', 'Roma Antiga, 476 d.C.', 'ALTA', 'PLANEJADA', '2026-10-15', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (2, 'Confirmar identidade do(signatário', 'Salvador, Bahia, 1822', 'EMERGÊNCIA', 'EM_EXECUÇÃO', '2026-09-01', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (3, 'Deduplicar documento digital', 'Acervo digital, data atual', 'NORMAL', 'AUTORIZADA', '2026-08-20', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (4, 'Reconhecer local do acontecimento', 'Interior de Minas, 1789', 'ALTA', 'PLANEJADA', '2026-11-05', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (5, 'Reconstruir cronologia oficial', 'Rio de Janeiro, 1930', 'EMERGÊNCIA', 'EM_EXECUÇÃO', '2026-07-12', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (6, 'Localizar documentação complementar', 'Arquivo Nacional, data atual', 'BAIXA', 'CONCLUÍDA', '2026-05-02', '2026-06-18', false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (7, 'Arbitrar versões contraditórias', 'São Paulo, 1964', 'ALTA', 'EM_EXECUÇÃO', '2026-08-01', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (8, 'Validar autoria do documento', 'Biblioteca Nacional, data atual', 'NORMAL', 'AUTORIZADA', '2026-09-15', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (9, 'Corrigir data de nascimento', 'Cartório civil, data atual', 'BAIXA', 'CONCLUÍDA', '2026-04-10', '2026-05-22', false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (10, 'Periciar possível falsificação', 'Arquivo histórico, data atual', 'EMERGÊNCIA', 'EM_EXECUÇÃO', '2026-06-30', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (11, 'Estender janela temporal do evento', 'Canudos, Bahia, 1897', 'NORMAL', 'PLANEJADA', '2026-12-01', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (12, 'Comparar cartografias históricas', 'Niterói, Rio de Janeiro, 1889', 'ALTA', 'AUTORIZADA', '2026-10-08', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (13, 'Recuperar cadeia de custódia', 'Arquivo morto, data atual', 'ALTA', 'EM_EXECUÇÃO', '2026-09-28', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (14, 'Reinserir ficha no acervo digital', 'Acervo institucional, data atual', 'BAIXA', 'CANCELADA', '2026-07-06', NULL, true);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (15, 'Reprocessar metadados corrompidos', 'Servidor de arquivamento, data atual', 'NORMAL', 'FALHOU', '2026-03-03', NULL, false);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted)
VALUES (16, 'Revisar classificação de importância', 'Conselho histórico, data atual', 'EMERGÊNCIA', 'PLANEJADA', '2026-11-20', NULL, false);

-- ============================================================================
-- Tabela associativa missoes_agentes (gerada pelo JPA)
-- ============================================================================
INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (1, 1),
       (1, 2);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (2, 3),
       (2, 4),
       (2, 9);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (3, 7),
       (3, 12);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (4, 4),
       (4, 10);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (5, 6),
       (5, 15),
       (5, 19);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (6, 1),
       (6, 14);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (7, 13),
       (7, 18);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (8, 7),
       (8, 22);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (9, 5),
       (9, 16);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (10, 6),
       (10, 10),
       (10, 20);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (11, 3),
       (11, 11);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (12, 4),
       (12, 13),
       (12, 23);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (13, 8),
       (13, 17);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (14, 3),
       (14, 9);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (15, 15),
       (15, 24);

INSERT INTO missoes_agentes (missao_id, agentes_id)
VALUES (16, 2),
       (16, 19),
       (16, 21);