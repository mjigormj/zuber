package com.igor.zuber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data

@Entity
@Table(name = "passageiros")
public class Passageiro {

    @Id
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "DT_NASCIMENTO", length = 50, nullable = false)
    private String dtNascimento;

    @Column(name = "CPF", length = 50, nullable = false, unique = true)
    private String cpf;
}
