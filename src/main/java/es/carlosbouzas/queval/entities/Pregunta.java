package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "pregunta")
public class Pregunta  {

    private static final int CODIGO_LENGTH = 8;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = CODIGO_LENGTH, unique = true)
    private String codigo;

    //@Lob
    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(name="es_visible")
    private Boolean esVisible;

    @Column(name="es_activa")
    private Boolean esActiva;

    @Column(name="tiempo_restante")
    private Integer tiempoRestante;

    private Integer dificultad;

    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToMany
    @JoinTable(name = "pregunta_examen",
            joinColumns = @JoinColumn(name = "pregunta_id"),
            inverseJoinColumns = @JoinColumn(name = "examen_id"))
    private Set<Examen> examenes = new LinkedHashSet<>();


    @OneToMany(mappedBy = "pregunta", orphanRemoval = true)
    private List<Respuesta> respuestas = new ArrayList<>();

}
