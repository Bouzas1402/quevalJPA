package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Pregunta  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 8)
    private String codigo;

    @Column(columnDefinition = "Texto")
    private String texto;

    @Column(name = "eval_tipo", nullable = false)
    private int evalTipo;

    @Column(name = "es_visible")
    private boolean esVisible;

    @Column(name = "es_activa")
    private boolean esActiva;

    @Column(name = "tiempo_restante")
    private int tiempoRestante;


    @ManyToOne
    @JoinColumn(name = "tema_id")
    private Tema tema;





}
