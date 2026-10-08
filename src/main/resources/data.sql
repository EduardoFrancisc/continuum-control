--Agentes
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

--Eventos
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

--Anomalias
INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (1,
     'Alteração de data',
     'A data registrada no sistema diverge da data encontrada no documento original.',
     '2026-01-15',
     'ALTO',
     'DETECTADA',
     'Sistema',
     'A divergência foi identificada durante uma validação automática.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (2,
     'Valor inconsistente',
     'O valor registrado para o evento não corresponde ao valor encontrado na documentação.',
     '2026-02-03',
     'CRÍTICO',
     'EM_ANÁLISE',
     'Auditoria',
     'A inconsistência está sendo analisada pela equipe responsável.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (3,
     'Documento ausente',
     'Documento obrigatório relacionado ao evento não foi localizado.',
     '2026-02-20',
     'MODERADO',
     'DETECTADA',
     'Importação',
     'O documento deverá ser localizado ou anexado ao registro.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (1,
     'Responsável divergente',
     'O responsável registrado no evento é diferente do responsável indicado na documentação.',
     '2026-03-01',
     'BAIXO',
     'CONFIRMADA',
     'Análise manual',
     'A divergência foi confirmada após análise dos documentos disponíveis.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (4,
     'Evento duplicado',
     'Foram identificados registros possivelmente referentes ao mesmo evento histórico.',
     '2026-03-12',
     'ALTO',
     'EM_CORREÇÃO',
     'Sistema',
     'Os registros duplicados estão sendo analisados para correção.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (5,
     'Informação incompleta',
     'O registro do evento possui informações importantes ausentes.',
     '2026-04-05',
     'MODERADO',
     'ESTABILIZADA',
     'Importação',
     'A inconsistência foi tratada e o registro encontra-se estável.',
     false);

INSERT INTO anomalias
(evento_id, nome, divergencia, data_deteccao, risco, estado, origem, observacoes, is_deleted)
VALUES
    (6,
     'Origem desconhecida',
     'Não foi possível determinar a origem do registro histórico.',
     '2026-04-18',
     'BAIXO',
     'IRREVERSÍVEL',
     NULL,
     'A origem da informação não pôde ser determinada e não há dados suficientes para correção.',
     false);