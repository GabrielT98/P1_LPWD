package br.edu.universidadedevassouras.prova.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Data
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = true)
    private String tipoLogradouro;

    @Column(nullable = false)
    private String logradouro;

    @Column(nullable = false)
    private Long numero;

    @Column(nullable = false)
    private String bairro;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;

    @Column(nullable = false)
    private String pais;

}
