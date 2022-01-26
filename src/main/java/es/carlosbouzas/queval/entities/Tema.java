package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "tema")
public class Tema {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(length = 8)
    private String codigo;

    @Column(nullable = false)
    private String nombre;


    @OneToMany(mappedBy = "tema", orphanRemoval = true)
    private Set<Pregunta> preguntas = new LinkedHashSet<>();


}