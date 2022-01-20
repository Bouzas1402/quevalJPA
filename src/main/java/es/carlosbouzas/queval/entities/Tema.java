package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Table(name = "tema")
@Entity
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 8)
    private String codigo;

    @Column(nullable = false)
    private String nombre;


    @OneToMany(mappedBy = "tema", orphanRemoval = true)
    private Set<Pregunta> preguntas = new LinkedHashSet<>();


}