package br.edu.infnet.continuum.domain.model;

import br.edu.infnet.continuum.domain.enums.TipoOcorrencia;

import java.time.LocalDateTime;

public class Ocorrencia {

    private String id;

    private TipoOcorrencia ocorrencia;

    private LocalDateTime data;

}
