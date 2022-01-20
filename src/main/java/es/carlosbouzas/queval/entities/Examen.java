package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "examen")
public class Examen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(length = 8)
    private String codigo;

    @Column(nullable = false)
    private Integer dificultad;

    @Column(name = "eval_tipo", nullable = false)
    private Integer evalTipo;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "fecha_final", nullable = false)
    private Date fechaFinal;

    @Column(name = "es_aleatorio", nullable = false)
    private Boolean esAleatorio = false;

    @Column(name = "num_preguntas", nullable = false)
    private Integer numPreguntas;

    @Column(nullable = false)
    private Integer duracion;

    @ManyToOne(optional = false)
    @JoinColumn(name = "area_id", nullable = false)
    private Area area;

}