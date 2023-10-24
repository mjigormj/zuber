package com.igor.zuber.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
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
