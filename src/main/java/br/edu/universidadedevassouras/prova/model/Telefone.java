package br.edu.universidadedevassouras.prova.model;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Entity
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String celular;

    @Column(nullable = false, unique = true)
    private String fixo;
}
