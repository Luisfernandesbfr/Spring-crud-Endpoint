package com.java.aula03.entities;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Militar {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private Long id;
    @Column(name = "data_insercao")
    private Instant dataInsercao;
    @Column(name = "data_alteracao")
    private Instant dataAlteracao;
    @Column(name = "nome_completo",nullable = false, length = 100)
    private  String nomeCompleto;
    @Column(name = "nome_guerra",nullable = false, length = 100)
    private String nomeGuerra;
}
