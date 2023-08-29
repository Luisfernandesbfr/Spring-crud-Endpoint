package com.java.aula03.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class MilitarDTO {

    private Long Id;
    private String nomeCompleto;
    private String nomeGuerra;
    private Instant dataInsercao;
    private Instant dataAlteracao;
}
