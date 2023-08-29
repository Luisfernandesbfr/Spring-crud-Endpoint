package com.java.aula03.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum MensagemEnum {

    EXCLUSAO("Registro excluido com sucesso"),

    ALTERACAO("Registro alterado com sucesso"),

    INCLUSAO ("Registro cadastrado com sucesso");

    @Getter
    private String value;
}
