-- ============================================================================
-- Agentes (agentes)
-- ============================================================================
INSERT INTO agentes (nome, especialidade, situacao, is_deleted) VALUES
('John Carl',          'ANALISE_HISTORICA',   'INATIVO',    false),
('Titor Jr.',          'CONTENCAO_FISICA',    'SUSPENSO',   true),
('Guilherme Santos',   'INVESTIGACAO',        'DISPONÍVEL', false),
('João Lopes',         'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Augusto Adoeça',     'ANALISE_HISTORICA',   'INATIVO',    false),
('Ronaldo Subido',     'CONTENCAO_FISICA',    'EM_MISSÃO',  false),
('Renan Demons',       'INVESTIGACAO',        'DISPONÍVEL', false),
('Luís Inocêncio',    'ENGENHARIA_TEMPORAL', 'SUSPENSO',   false),
('Marcos Silva',       'ANALISE_HISTORICA',   'DISPONÍVEL', false),
('Ana Martins',        'CONTENCAO_FISICA',    'EM_MISSÃO',  false),
('Carlos Oliveira',    'INVESTIGACAO',        'INATIVO',    false),
('Beatriz Souza',      'ENGENHARIA_TEMPORAL', 'SUSPENSO',   false),
('Rafael Costa',       'ANALISE_HISTORICA',   'EM_MISSÃO',  false),
('Fernanda Alves',     'CONTENCAO_FISICA',    'DISPONÍVEL', false),
('Lucas Pereira',      'INVESTIGACAO',        'SUSPENSO',   true),
('Camila Rocha',       'ENGENHARIA_TEMPORAL', 'INATIVO',    false),
('Diego Ferreira',     'ANALISE_HISTORICA',   'SUSPENSO',   true),
('Juliana Mendes',     'CONTENCAO_FISICA',    'INATIVO',    false),
('Thiago Ramos',       'INVESTIGACAO',        'EM_MISSÃO',  false),
('Larissa Barbosa',    'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Eduardo Nunes',      'INVESTIGACAO',        'DISPONÍVEL', false),
('Patrícia Andrade',  'ANALISE_HISTORICA',   'DISPONÍVEL', false),
('Ricardo Teixeira',   'ENGENHARIA_TEMPORAL', 'EM_MISSÃO',  false),
('Sofia Cavalcante',   'CONTENCAO_FISICA',    'DISPONÍVEL', false),
('Vanessa Lima',       'INVESTIGACAO',        'DISPONÍVEL', false),
('Bruno Figueiredo',   'ANALISE_HISTORICA',   'DISPONÍVEL', false),
('Isabela Correia',    'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Mateus Pinheiro',    'CONTENCAO_FISICA',    'DISPONÍVEL', false),
('Natália Freitas',   'INVESTIGACAO',        'EM_MISSÃO',  false),
('Alexandre Duarte',   'ANALISE_HISTORICA',   'DISPONÍVEL', false),
('Priscila Monteiro',  'CONTENCAO_FISICA',    'SUSPENSO',   false),
('Leandro Cardoso',    'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Aline Rezende',      'INVESTIGACAO',        'DISPONÍVEL', false),
('Rodrigo Vilela',     'ANALISE_HISTORICA',   'INATIVO',    false),
('Gabriela Vasconcelos','CONTENCAO_FISICA',   'DISPONÍVEL', false),
('Felipe Esteves',     'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false);

-- ============================================================================
-- Eventos históricos
-- ============================================================================
INSERT INTO eventos_historicos (nome, descricao, data_inicio, data_fim, importancia, is_deleted) VALUES
('Descobrimento do Brasil',
 'Chegada da frota portuguesa ao território brasileiro.',
 '1500-04-22', '1500-04-22', 'CRÍTICA', false),

('Independência do Brasil',
 'Proclamação da independência do Brasil em relação a Portugal.',
 '1822-09-07', '1822-09-07', 'CRÍTICA', false),

('Proclamação da República',
 'Mudança do regime político brasileiro de monarquia para república.',
 '1889-11-15', '1889-11-15', 'ALTA', false),

('Abolição da Escravatura',
 'Assinatura da Lei Áurea, que aboliu oficialmente a escravidão no Brasil.',
 '1888-05-13', '1888-05-13', 'ALTA', false),

('Revolução de 1930',
 'Movimento político que levou Getúlio Vargas ao poder e encerrou a República Velha.',
 '1930-10-03', '1930-10-24', 'ALTA', false),

('Era Vargas',
 'Período da história brasileira marcado pelos governos de Getúlio Vargas.',
 '1930-11-03', '1945-10-29', 'MODERADA', false),

('Constituição de 1988',
 'Promulgação da Constituição Federal que marcou a redemocratização do Brasil.',
 '1988-10-05', '1988-10-05', 'MODERADA', false),

('Inauguração de Brasília',
 'Inauguração da nova capital federal do Brasil.',
 '1960-04-21', '1960-04-21', 'MODERADA', false),

('Diretas Já',
 'Movimento popular que reivindicava eleições diretas para presidente do Brasil.',
 '1983-05-01', '1984-04-25', 'ALTA', false),

('Guerra de Canudos',
 'Conflito entre forças do governo brasileiro e a comunidade de Canudos.',
 '1896-11-01', '1897-10-05', 'ALTA', false),

('Inconfidência Mineira',
 'Movimento de caráter separatista ocorrido na capitania de Minas Gerais.',
 '1789-01-01', '1789-05-23', 'ALTA', false),

('Chegada da Família Real ao Brasil',
 'Transferência da corte portuguesa para o Brasil durante as Guerras Napoleônicas.',
 '1808-01-22', '1808-01-22', 'BAIXA', false),

('Golpe Militar de 1964',
 'Movimento que depôs o presidente João Goulart e iniciou o regime militar brasileiro.',
 '1964-03-31', '1964-04-01', 'ALTA', false),

('Impeachment de Fernando Collor',
 'Processo de impeachment que resultou no afastamento do presidente Fernando Collor de Mello.',
 '1992-09-29', '1992-12-29', 'BAIXA', false),

('Plano Real',
 'Implementação do plano econômico que criou o Real e estabilizou a economia brasileira.',
 '1994-07-01', '1994-07-01', 'BAIXA', false),

('Tratado de Tordesilhas',
 'Tratado firmado entre Portugal e Espanha que dividiu as terras descobertas entre as duas coroas.',
 '1494-06-07', '1494-06-07', 'CRÍTICA', false),

('Revolta da Armada',
 'Movimento de oficiais da Marinha contra o governo de Floriano Peixoto.',
 '1893-09-23', '1894-03-11', 'MODERADA', false),

('Proclamação da Independência Argentina',
 'Declaração de independência do Rio da Prata, na Argentina, que rompia com a monarquia espanhola.',
 '1816-07-09', '1816-07-09', 'BAIXA', false),

('Queda do Muro de Berlim',
 'Derrubada do muro que separava as duas Alemanhas, marco do fim da Guerra Fria.',
 '1989-11-09', '1989-11-09', 'CRÍTICA', false),

('Revolução Francesa',
 'Período de transformações políticas e sociais radicais na França.',
 '1789-07-14', '1799-11-09', 'CRÍTICA', false),

('Primeira Guerra Mundial',
 'Conflito global que envolveu as principais potências mundiais.',
 '1914-07-28', '1918-11-11', 'CRÍTICA', false),

('Segunda Guerra Mundial',
 'Conflito global de maior escala da história humana.',
 '1939-09-01', '1945-09-02', 'CRÍTICA', false),

('Chegada do Homem à Lua',
 'Primeira missão tripulada a pousar e retornar com sucesso da Lua.',
 '1969-07-20', '1969-07-24', 'ALTA', false),

('Colapso da União Soviética',
 'Dissolução formal da URSS e fim da Guerra Fria.',
 '1991-12-25', '1991-12-25', 'CRÍTICA', false);

-- ============================================================================
-- Anomalias (anomalias)
-- ============================================================================
INSERT INTO anomalias (evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_active, is_deleted) VALUES
(1,  'Inconsistência temporal da frota',
     'A data de chegada da frota portuguesa diverge em 3 dias dos registros históricos conhecidos.',
     '2025-01-15', 'CRÍTICO', 'DETECTADA', 'Arquivo histórico',
     'Necessário revisar os documentos originais para confirmar a data correta.', TRUE, FALSE),

(2,  'Alteração de identidade do signatário',
     'O nome do signatário da carta registrado diverge dos documentos históricos associados ao indivíduo.',
     '2025-02-03', 'CRÍTICO', 'EM_ANÁLISE', 'Registro civil',
     'Existem registros com nomes diferentes associados ao mesmo indivíduo.', TRUE, FALSE),

(3,  'Documento de proclamação duplicado',
     'Dois documentos apresentam conteúdo semelhante, mas identificadores de autoria diferentes.',
     '2025-02-18', 'MODERADO', 'DETECTADA', 'Arquivo digital',
     'Verificar se a duplicidade foi causada por erro de digitalização.', TRUE, FALSE),

(4,  'Localização da assinatura divergente',
     'O local informado no evento difere do local mencionado em outras fontes históricas primárias.',
     '2025-03-10', 'ALTO', 'EM_ANÁLISE', 'Relato testemunhal',
     'Comparar os relatos disponíveis e verificar possíveis alterações nos limites territoriais.', TRUE, FALSE),

(5,  'Cronologia da Revolução inconsistente',
     'A sequência dos acontecimentos de outubro de 1930 não corresponde à cronologia documentada.',
     '2025-03-22', 'CRÍTICO', 'CONFIRMADA', 'Pesquisa documental',
     'A inconsistência foi confirmada após a comparação de múltiplas fontes históricas.', TRUE, FALSE),

(6,  'Ausência de decreto original',
     'Não foram encontrados documentos que comprovem a publicação do decreto no diário oficial da época.',
     '2025-04-05', 'BAIXO', 'ESTABILIZADA', 'Acervo institucional',
     'A documentação complementar foi localizada e anexada ao registro histórico.', TRUE, FALSE),

(7,  'Versões contraditórias da Constituição',
     'Duas fontes apresentam versões incompatíveis sobre a data de promulgação do texto final.',
     '2025-04-17', 'ALTO', 'EM_CORREÇÃO', 'Jornal da época',
     'Os registros estão sendo revisados para determinar qual versão apresenta maior consistência.', TRUE, FALSE),

(8,  'Registro de autoria do plano urbanístico incorreto',
     'A autoria atribuída ao plano urbanístico diverge da identificação encontrada no arquivo original.',
     '2025-05-02', 'MODERADO', 'DETECTADA', 'Catálogo documental',
     'Aguardando validação da autoria por especialista em documentos históricos.', TRUE, FALSE),

(9,  'Data de votação incompatível',
     'A data de votação registrada não corresponde às atas parlamentares encontradas no acervo.',
     '2025-05-19', 'BAIXO', 'ESTABILIZADA', NULL,
     'A data foi corrigida após consulta ao registro civil original.', TRUE, FALSE),

(10, 'Possível falsificação de decreto abolicionista',
     'Foram identificadas diferenças na caligrafia e na formatação do documento analisado.',
     '2025-06-11', 'CRÍTICO', 'IRREVERSÍVEL', 'Análise pericial',
     'As características identificadas indicam possível adulteração documental que não pode ser revertida.', TRUE, FALSE),

(11, 'Margem temporal do conflito incorreta',
     'O período de duração da guerra de Canudos está menor do que o previsto nas fontes consultadas.',
     '2025-07-02', 'MODERADO', 'DETECTADA', 'Crônica setecentista',
     'Reconstruir o cronograma completo do conflito a partir dos relatos disponíveis.', TRUE, FALSE),

(12, 'Divergência nas fronteiras da capitania',
     'As fronteiras citadas no evento não correspondem à cartografia histórica do período colonial.',
     '2025-07-28', 'ALTO', 'EM_ANÁLISE', 'Mapa de época',
     'A cartografia do século XVIII apresenta limites diferentes dos registrados na base de dados.', TRUE, FALSE),

(13, 'Lacuna na cadeia de custódia do decreto militar',
     'Não há registro de rastreabilidade entre a digitalização e o documento físico do decreto.',
     '2025-08-09', 'MODERADO', 'CONFIRMADA', 'Arquivo morto',
     'A cadeia de custódia foi rompida durante a restauração do acervo em 1992.', TRUE, FALSE),

(14, 'Documento do impeachment inexistente no acervo',
     'O documento citado como fonte do evento não consta no acervo digital atual do Senado.',
     '2025-09-01', 'BAIXO', 'EM_CORREÇÃO', 'Acervo digital',
     'Solicitado o reinstatement temporário da ficha física para conferência.', TRUE, FALSE),

(15, 'Metadados do Plano Real corrompidos',
     'Os metadados de digitalização apresentam valores de data fora do padrão esperado para a época.',
     '2025-09-23', 'ALTO', 'DETECTADA', 'Servidor de arquivamento',
     'Recuperar os metadados originais a partir do backup do servidor de armazenamento.', TRUE, FALSE),

(16, 'Classificação do Tratado de Tordesilhas alterada',
     'A importância atribuída ao tratado diverge da classificação oficial vigente no período histórico.',
     '2025-10-07', 'CRÍTICO', 'EM_ANÁLISE', 'Norma historiográfica',
     'Aguardando parecer do conselho histórico antes de qualquer correção definitiva.', TRUE, FALSE),

(17, 'Número de navios da Revolta da Armada divergente',
     'O número de embarcações citado nos documentos oficiais não coincide com os registros militares.',
     '2025-10-15', 'MODERADO', 'DETECTADA', 'Arquivo da Marinha',
     'Cruzamento de fontes militares necessário para confirmar o número exato.', TRUE, FALSE),

(18, 'Data da declaração argentina imprecisa',
     'O documento apresenta rasura sobre o dia exato da declaração de independência argentina.',
     '2025-10-28', 'BAIXO', 'ESTABILIZADA', 'Acervo argentino',
     'Comparação com fontes espanholas indicou que a data correta é 9 de julho.', TRUE, FALSE),

(19, 'Registros contraditórios sobre a queda do Muro',
     'Transmissões televisivas da época apresentam horários inconsistentes com os registros oficiais.',
     '2025-11-04', 'ALTO', 'CONFIRMADA', 'Arquivo de mídia',
     'As gravações originais estão sendo restauradas para análise forense de metadados.', TRUE, FALSE),

(20, 'Lacuna documental na Revolução Francesa',
     'Ausência de registro sobre as deliberações dos primeiros três dias após a tomada da Bastilha.',
     '2025-11-18', 'CRÍTICO', 'EM_ANÁLISE', 'Arquivos nacionais franceses',
     'Hipótese de supressão deliberada dos registros por facção política da época.', TRUE, FALSE),

(21, 'Datas de batalhas da 1ª Guerra inconsistentes',
     'O diário de campo de um oficial apresenta datas que contradizem os relatórios do Estado-Maior.',
     '2025-11-30', 'ALTO', 'EM_CORREÇÃO', 'Imperial War Museum',
     'Digitalização das páginas em andamento para comparação grafológica.', TRUE, FALSE),

(22, 'Mapa de operações da 2ª Guerra adulterado',
     'Um mapa estratégico classificado apresenta coordenadas que diferem das posições relatadas.',
     '2025-12-10', 'CRÍTICO', 'CONFIRMADA', 'National Archives (EUA)',
     'Análise de tinta e papel indica que o documento foi alterado após 1950.', TRUE, FALSE),

(23, 'Transmissão lunar com lacuna de 2 minutos',
     'A transmissão ao vivo da Apollo 11 apresenta um corte de 2 minutos não documentado.',
     '2025-12-20', 'MODERADO', 'DETECTADA', 'NASA Archive',
     'A fita original está em processo de restauração para verificar se houve falha técnica.', TRUE, FALSE),

(24, 'Data oficial da dissolução soviética diverge',
     'O documento de dissolução formal da URSS apresenta data diferente da registrada pelo protocolo da ONU.',
     '2026-01-08', 'ALTO', 'EM_ANÁLISE', 'Arquivo histórico russo',
     'Verificação do fuso horário e da versão em cada idioma do documento está em andamento.', TRUE, FALSE);

-- ============================================================================
-- Missões (missoes)
-- ============================================================================
INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted) VALUES
(1,  'Investigar anacronismo da data de chegada',           'Lisboa, Portugal / Brasil, 1500',      'ALTA',      'PLANEJADA',   '2026-10-15', NULL,         false),
(2,  'Confirmar identidade do signatário da carta',         'Salvador, Bahia, 1822',                'EMERGÊNCIA','EM_EXECUÇÃO', '2026-09-01', NULL,         false),
(3,  'Deduplicar documento de proclamação digital',         'Acervo digital, 2026',                 'NORMAL',    'AUTORIZADA',  '2026-08-20', NULL,         false),
(4,  'Reconhecer local original da assinatura',             'Interior de Minas Gerais, 1789',       'ALTA',      'PLANEJADA',   '2026-11-05', NULL,         false),
(5,  'Reconstruir cronologia oficial de outubro de 1930',   'Rio de Janeiro, 1930',                 'EMERGÊNCIA','EM_EXECUÇÃO', '2026-07-12', NULL,         false),
(6,  'Localizar documentação complementar do decreto',      'Arquivo Nacional, 2026',               'BAIXA',     'CONCLUÍDA',   '2026-05-02', '2026-06-18', false),
(7,  'Arbitrar versões contraditórias do texto final',      'Brasília, 1988',                       'ALTA',      'EM_EXECUÇÃO', '2026-08-01', NULL,         false),
(8,  'Validar autoria do plano urbanístico de Brasília',    'Biblioteca Nacional, 2026',            'NORMAL',    'AUTORIZADA',  '2026-09-15', NULL,         false),
(9,  'Corrigir data da votação parlamentar',                'Cartório civil, 2026',                 'BAIXA',     'CONCLUÍDA',   '2026-04-10', '2026-05-22', false),
(10, 'Periciar possível falsificação do decreto',           'Arquivo histórico, 2026',              'EMERGÊNCIA','EM_EXECUÇÃO', '2026-06-30', NULL,         false),
(11, 'Estender janela temporal registrada de Canudos',      'Canudos, Bahia, 1897',                 'NORMAL',    'PLANEJADA',   '2026-12-01', NULL,         false),
(12, 'Comparar cartografias históricas da capitania',       'Niterói, Rio de Janeiro, 1789',        'ALTA',      'AUTORIZADA',  '2026-10-08', NULL,         false),
(13, 'Recuperar cadeia de custódia do decreto',             'Arquivo morto, 2026',                  'ALTA',      'EM_EXECUÇÃO', '2026-09-28', NULL,         false),
(14, 'Reinserir ficha do impeachment no acervo digital',    'Senado Federal, 2026',                 'BAIXA',     'CANCELADA',   '2026-07-06', NULL,         true),
(15, 'Reprocessar metadados do Plano Real',                 'Servidor de arquivamento, 2026',       'NORMAL',    'FALHOU',      '2026-03-03', NULL,         false),
(16, 'Revisar classificação do Tratado de Tordesilhas',     'Conselho histórico, 2026',             'EMERGÊNCIA','PLANEJADA',   '2026-11-20', NULL,         false),
(17, 'Cruzar fontes militares da Revolta da Armada',        'Arquivo da Marinha, Rio de Janeiro',   'NORMAL',    'PLANEJADA',   '2026-12-10', NULL,         false),
(18, 'Verificar rasura na declaração argentina',            'Buenos Aires, 1816',                   'BAIXA',     'CONCLUÍDA',   '2026-02-14', '2026-03-30', false),
(19, 'Analisar lacunas na transmissão da queda do Muro',    'Berlim, 1989',                         'ALTA',      'EM_EXECUÇÃO', '2026-10-01', NULL,         false),
(20, 'Recuperar registros dos primeiros dias pós-Bastilha', 'Paris, França, 1789',                  'EMERGÊNCIA','AUTORIZADA',  '2026-10-20', NULL,         false),
(21, 'Confrontar diário de oficial com relatório do Estado-Maior', 'Londres / Frentes de batalha, 1916', 'ALTA', 'PLANEJADA',  '2026-11-15', NULL,         false),
(22, 'Autenticar mapa de operações classificado',           'Washington D.C., 1944',                'EMERGÊNCIA','EM_EXECUÇÃO', '2026-09-05', NULL,         false),
(23, 'Restaurar fita original da transmissão lunar',        'NASA, Houston, 1969',                  'NORMAL',    'PLANEJADA',   '2026-12-20', NULL,         false),
(24, 'Harmonizar data de dissolução nos registros da ONU',  'Genebra / Moscou, 1991',               'ALTA',      'AUTORIZADA',  '2026-10-28', NULL,         false);

-- ============================================================================
-- Tabela associativa missoes_agentes
-- ============================================================================
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (1, 1),  (1, 2);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (2, 3),  (2, 4),  (2, 29);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (3, 7),  (3, 12);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (4, 4),  (4, 26);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (5, 6),  (5, 19), (5, 29);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (6, 1),  (6, 14);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (7, 13), (7, 25);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (8, 9),  (8, 22);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (9, 5),  (9, 16);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (10, 6), (10, 10), (10, 23);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (11, 3), (11, 11);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (12, 4), (12, 13), (12, 27);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (13, 8), (13, 20);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (14, 3), (14, 9);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (15, 15),(15, 24);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (16, 2), (16, 19), (16, 32);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (17, 21),(17, 33);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (18, 26),(18, 30);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (19, 7), (19, 28), (19, 35);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (20, 27),(20, 36);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (21, 30),(21, 34);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (22, 6), (22, 29), (22, 13);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (23, 32),(23, 20);
INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES (24, 36),(24, 27);

-- ============================================================================
-- Usuários (mantidos como estavam)
-- ============================================================================
INSERT INTO usuarios(id, login, role, senha)
VALUES (1, 'agente00', 'ADMINISTRADOR', '$2a$10$jx7xKkcqC8ZuOHbhL1FOo.jC4DbMSBgUbobmdmJucWC.DQ5T31.3i');

INSERT INTO usuarios(id, login, role, senha)
VALUES (2, 'agente01', 'SUPERVISOR', '$2a$10$2bwlu7Ca9WvYaZL1GSwODeOl0G9d5itP9v/IeaYAp9PoPWl3zHIp2');

INSERT INTO usuarios(id, login, role, senha)
VALUES (3, 'agente02', 'OPERADOR', '$2a$10$qqkOoYNSDhWWkhiPO0/.1u7w3SS4pjtkDCoYEEttjyTQzhWk8XERW');

INSERT INTO usuarios(id, login, role, senha)
VALUES (4, 'agente03', 'AGENTE', '$2a$10$S2GrtNEe4.Cx0sAGP6qKPumS83KvC8H9CzglT39NmXvPyNHWNAARa');

-- ============================================================================
-- Autorizações de operação
-- ============================================================================
INSERT INTO autorizacoes_operacao (missao_id, responsavel_id, instante, observacao) VALUES
(2,  2, '2026-08-30 09:00:00', 'Autorização concedida pelo supervisor para início imediato. Anomalia de alto risco.'),
(5,  2, '2026-07-10 14:30:00', 'Missão de emergência aprovada. Reconstituição histórica urgente.'),
(10, 1, '2026-06-28 11:00:00', 'Autorização do administrador. Suspeita de fraude documental crítica.'),
(20, 2, '2026-10-18 16:45:00', 'Aprovada pelo supervisor após análise dos registros parisienses.'),
(22, 1, '2026-09-03 08:20:00', 'Autorização concedida pelo administrador. Documento com grau máximo de sigilo.');

-- ============================================================================
-- Intervenções
-- ============================================================================
INSERT INTO intervencoes (missao_id, agente_id, data, acao_executada, justificativa, resultado_observado, impacto_estimado) VALUES
(2,  3,  '2026-09-05 10:15:00',
 'Coleta de amostras documentais em Salvador',
 'Necessário obter os documentos primários do cartório da época para comparação.',
 'Encontradas 3 versões diferentes do mesmo decreto com assinaturas distintas.',
 'SIGNIFICATIVO'),

(2,  4,  '2026-09-12 14:00:00',
 'Reconstrução do mapa de deslocamentos do signatário',
 'A rota de viagem pode confirmar qual documento foi assinado primeiro.',
 'Identificado um trajeto não registrado oficialmente entre cidades.',
 'CONTROLADO'),

(5,  6,  '2026-07-15 08:30:00',
 'Entrevista com descendentes de testemunhas do golpe de 30',
 'Relatos orais podem preencher lacunas nos registros documentais.',
 'Coletados 7 depoimentos que contradizem a versão oficial da cronologia.',
 'SIGNIFICATIVO'),

(5,  19, '2026-07-20 11:45:00',
 'Análise de telegramas militares de outubro de 1930',
 'Os telegramas indicam movimentações que precedem a data oficial do movimento.',
 'Encontrada evidência de articulação iniciada 10 dias antes do registro oficial.',
 'SEVERO'),

(7,  13, '2026-08-10 09:00:00',
 'Comparação das versões digitalizadas com os originais físicos',
 'Necessário confirmar qual manuscrito é o definitivo promulgado.',
 'Localizada rasura em parágrafo chave que altera o sentido do artigo 5º.',
 'SEVERO'),

(10, 6,  '2026-07-05 13:00:00',
 'Exame pericial da caligrafia do decreto',
 'Suspeita de adulteração exige análise grafológica comparativa.',
 'Laudo preliminar confirma duas caligrafias distintas no mesmo documento.',
 'SEVERO'),

(10, 23, '2026-07-18 16:20:00',
 'Análise química do papel e da tinta',
 'Datação do papel pode confirmar ou refutar a autenticidade do documento.',
 'O papel data de período posterior à suposta data de elaboração do decreto.',
 'SEVERO'),

(13, 8,  '2026-10-02 10:00:00',
 'Reconstituição da custódia documental do decreto militar',
 'A lacuna na cadeia indica possível extravio ou substituição deliberada.',
 'Encontrado registro paralelo em cartório de São Paulo que não constava no acervo central.',
 'CONTROLADO'),

(13, 20, '2026-10-10 15:30:00',
 'Digitalização de emergência do arquivo físico encontrado',
 'O documento físico está em estado frágil e precisa ser preservado imediatamente.',
 'Digitalização concluída. Metadados compatíveis com o período do decreto.',
 'MÍNIMO'),

(19, 7,  '2026-10-05 09:45:00',
 'Restauração forense das fitas de transmissão da Alemanha Oriental',
 'Necessário recuperar os 2 minutos ausentes da transmissão original.',
 'Localizada fita de backup em arquivo de mídia em Leipzig com os 2 minutos ausentes.',
 'SIGNIFICATIVO'),

(19, 35, '2026-10-12 11:00:00',
 'Análise dos metadados de transmissão das emissoras da época',
 'Os metadados podem indicar se o corte foi técnico ou deliberado.',
 'Verificado que o corte coincide com comunicação de rádio criptografada não identificada.',
 'CONTROLADO'),

(22, 6,  '2026-09-08 08:00:00',
 'Autenticação do mapa de operações por análise de tinta',
 'Suspeita de que o mapa foi alterado no pós-guerra para esconder operações.',
 'Confirmado uso de duas tintas distintas com diferença de ao menos 5 anos.',
 'SEVERO'),

(22, 29, '2026-09-15 14:00:00',
 'Cruzamento do mapa com registros de comunicações militares',
 'As coordenadas divergentes podem revelar uma operação não documentada oficialmente.',
 'Localizado código de operação em registros criptografados que corresponde à região divergente.',
 'SIGNIFICATIVO');

-- ============================================================================
-- Encerramentos de Missões (encerramento_missoes)
-- ============================================================================
INSERT INTO encerramento_missoes (missao_id, resultado, resumo, impacto, situacao_anomalia, observacoes_relevantes) VALUES
(6,  'SUCESSO',
 'A documentação complementar do decreto foi localizada no arquivo regional do Maranhão.',
 'MÍNIMO',
 'ESTABILIZADA',
 'Os documentos encontrados foram digitalizados e integrados ao acervo digital. A anomalia foi encerrada com sucesso.'),

(9,  'SUCESSO',
 'A data de votação foi corrigida para 25 de setembro conforme a ata parlamentar original.',
 'MÍNIMO',
 'ESTABILIZADA',
 'O erro era proveniente de uma transcrição incorreta realizada em 1948. Acervo atualizado.'),

(15, 'FALHA',
 'O servidor de arquivamento entrou em colapso durante a recuperação dos metadados.',
 'SEVERO',
 'IRREVERSÍVEL',
 'A falha no sistema causou a perda permanente dos backups secundários. Os metadados não puderam ser recuperados.'),

(18, 'SUCESSO_PARCIAL',
 'A rasura foi identificada como obra de um escrivão que corrigiu erro de punho do redator original.',
 'CONTROLADO',
 'ESTABILIZADA',
 'A data 9 de julho foi confirmada como correta por três fontes independentes. A rasura é inofensiva ao registro histórico.');
-- ============================================================================
-- Registros adicionais para volume de testes
-- ============================================================================

INSERT INTO agentes (nome, especialidade, situacao, is_deleted) VALUES
('Agente Extra 01', 'INVESTIGACAO', 'DISPONÍVEL', false),
('Agente Extra 02', 'ANALISE_HISTORICA', 'DISPONÍVEL', false),
('Agente Extra 03', 'CONTENCAO_FISICA', 'EM_MISSÃO', false),
('Agente Extra 04', 'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Agente Extra 05', 'INVESTIGACAO', 'INATIVO', false),
('Agente Extra 06', 'ANALISE_HISTORICA', 'SUSPENSO', false),
('Agente Extra 07', 'CONTENCAO_FISICA', 'DISPONÍVEL', false),
('Agente Extra 08', 'ENGENHARIA_TEMPORAL', 'DISPONÍVEL', false),
('Agente Extra 09', 'INVESTIGACAO', 'DISPONÍVEL', false),
('Agente Extra 10', 'ANALISE_HISTORICA', 'EM_MISSÃO', false);

INSERT INTO anomalias (evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_active, is_deleted) VALUES
(1, 'Anomalia extra 01', 'Divergência adicional no registro 1', '2026-02-01', 'MODERADO', 'DETECTADA', 'Arquivo histórico', 'Registro adicional para testes.', TRUE, FALSE),
(2, 'Anomalia extra 02', 'Divergência adicional no registro 2', '2026-02-02', 'ALTO', 'EM_ANÁLISE', 'Registro civil', 'Registro adicional para testes.', TRUE, FALSE),
(3, 'Anomalia extra 03', 'Divergência adicional no registro 3', '2026-02-03', 'BAIXO', 'ESTABILIZADA', 'Arquivo digital', 'Registro adicional para testes.', TRUE, FALSE),
(4, 'Anomalia extra 04', 'Divergência adicional no registro 4', '2026-02-04', 'CRÍTICO', 'CONFIRMADA', 'Relato testemunhal', 'Registro adicional para testes.', TRUE, FALSE),
(5, 'Anomalia extra 05', 'Divergência adicional no registro 5', '2026-02-05', 'MODERADO', 'EM_CORREÇÃO', 'Pesquisa documental', 'Registro adicional para testes.', TRUE, FALSE),
(6, 'Anomalia extra 06', 'Divergência adicional no registro 6', '2026-02-06', 'BAIXO', 'DETECTADA', 'Acervo institucional', 'Registro adicional para testes.', TRUE, FALSE),
(7, 'Anomalia extra 07', 'Divergência adicional no registro 7', '2026-02-07', 'ALTO', 'EM_ANÁLISE', 'Jornal da época', 'Registro adicional para testes.', TRUE, FALSE),
(8, 'Anomalia extra 08', 'Divergência adicional no registro 8', '2026-02-08', 'MODERADO', 'CONFIRMADA', 'Catálogo documental', 'Registro adicional para testes.', TRUE, FALSE);

INSERT INTO missoes (anomalia_id, objetivo, destino_temporal, prioridade, estado, data_inicio, data_fim, is_deleted) VALUES
(1, 'Missão extra 01', 'Local histórico 1', 'NORMAL', 'PLANEJADA', '2026-10-01', NULL, false),
(2, 'Missão extra 02', 'Local histórico 2', 'ALTA', 'EM_EXECUÇÃO', '2026-10-02', NULL, false),
(3, 'Missão extra 03', 'Local histórico 3', 'BAIXA', 'CONCLUÍDA', '2026-10-03', '2026-10-20', false),
(4, 'Missão extra 04', 'Local histórico 4', 'EMERGÊNCIA', 'AUTORIZADA', '2026-10-04', NULL, false),
(5, 'Missão extra 05', 'Local histórico 5', 'NORMAL', 'FALHOU', '2026-10-05', NULL, false),
(6, 'Missão extra 06', 'Local histórico 6', 'ALTA', 'CANCELADA', '2026-10-06', NULL, true),
(7, 'Missão extra 07', 'Local histórico 7', 'NORMAL', 'PLANEJADA', '2026-10-07', NULL, false),
(8, 'Missão extra 08', 'Local histórico 8', 'BAIXA', 'EM_EXECUÇÃO', '2026-10-08', NULL, false);

INSERT INTO missoes_agentes (missao_id, agentes_id) VALUES
(1, 37), (1, 38),
(2, 39), (2, 40),
(3, 41), (3, 42),
(4, 43), (4, 44),
(5, 45), (5, 46),
(6, 41), (6, 42),
(7, 43), (7, 44),
(8, 37), (8, 38);

INSERT INTO intervencoes (missao_id, agente_id, data, acao_executada, justificativa, resultado_observado, impacto_estimado) VALUES
(1, 37, '2026-10-10 09:00:00', 'Coleta de dados adicionais', 'Validação de registros complementares.', 'Dados coletados com sucesso.', 'CONTROLADO'),
(2, 39, '2026-10-11 10:00:00', 'Análise de inconsistência', 'Verificação de divergência temporal.', 'Inconsistência confirmada.', 'SIGNIFICATIVO'),
(3, 41, '2026-10-12 11:00:00', 'Restauração de documento', 'Preservação de acervo físico.', 'Documento restaurado.', 'MÍNIMO'),
(4, 43, '2026-10-13 12:00:00', 'Perícia adicional', 'Suspeita de adulteração.', 'Laudo preliminar concluído.', 'SEVERO'),
(5, 45, '2026-10-14 13:00:00', 'Entrevista com testemunhas', 'Preenchimento de lacunas documentais.', 'Novos depoimentos coletados.', 'SIGNIFICATIVO'),
(6, 41, '2026-10-15 14:00:00', 'Digitalização de emergência', 'Preservação imediata do documento.', 'Digitalização concluída.', 'CONTROLADO');

INSERT INTO encerramento_missoes (missao_id, resultado, resumo, impacto, situacao_anomalia, observacoes_relevantes) VALUES
(1, 'SUCESSO', 'Missão extra 01 concluída com sucesso.', 'MÍNIMO', 'ESTABILIZADA', 'Registro adicional de encerramento.'),
(2, 'SUCESSO_PARCIAL', 'Missão extra 02 concluída parcialmente.', 'CONTROLADO', 'CONFIRMADA', 'Registro adicional de encerramento.'),
(4, 'SUCESSO', 'Missão extra 04 concluída com sucesso.', 'MÍNIMO', 'ESTABILIZADA', 'Registro adicional de encerramento.');
