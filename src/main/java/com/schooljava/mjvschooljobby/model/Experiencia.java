package com.schooljava.mjvschooljobby.model;

import com.schooljava.mjvschooljobby.enums.RegimeContratacao;
import lombok.Data;
import javax.persistence.*;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idExperiencia;

    private double salario;

    @Column(nullable = false)
    private boolean empregoAtual;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate dataContratacao;

    @Column(columnDefinition = "DATE")
    private LocalDate dataDesligamento;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Empresa empresa;

    @Enumerated(EnumType.STRING)
    @Column(name = "regime_contratacao_id")
    private RegimeContratacao regimeContratacao;

    @ManyToOne
    @JoinColumn(name = "candidato_id")
    private Candidato candidato;
}