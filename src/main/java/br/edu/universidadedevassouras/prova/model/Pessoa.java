package br.edu.universidadedevassouras.prova.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
@Getter
@Data
@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = true)
    private Date Nascimento;

    @Column(nullable = true)
    private char sexo;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false)
    private String tipoSanguineo;

    @Column(nullable = false)
    private String pai;

    @Column(nullable = false)
    private String mae;

    @ManyToOne
    @JoinColumn(name = "telefone.id")
    private Telefone telefone;

    @ManyToOne
    @JoinColumn(name = "endereco.id")
    private Endereco endereco;
}