package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "examen")
public class Examen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true, length = 8)
    private String codigo;

    private Integer dificultad;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "fecha_final")
    private LocalDate fechaFinal;

    @Column(name = "es_aleatorio", nullable = false)
    private Boolean esAleatorio = false;

    @Column(name = "num_preguntas", nullable = false)
    private Integer numPreguntas;

    @Column(name = "duracion", nullable = false)
    private Integer duracion;

}
