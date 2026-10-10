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
      );