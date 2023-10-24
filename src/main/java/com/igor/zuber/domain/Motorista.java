package com.igor.zuber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "motoristas")
public class Motorista implements Serializable {

    @Id
    @Column(name = "CNH", length = 50)
    private Long cnh;

    @Column(name = "NOME", length = 50, nullable = false, unique = false)
    private String nome;

    @Column(name = "VEICULO", length = 9, nullable = false, unique = false)
    private String veiculo;
}
