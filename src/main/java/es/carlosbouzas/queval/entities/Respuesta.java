package es.carlosbouzas.queval.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "respuesta")
public class Respuesta {

    private static final int CODIGO_LENGTH = 3;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = CODIGO_LENGTH)
    private String codigo;

    //@Lob
    @Column(columnDefinition = "TEXT")
    private String texto;

    @Column(name="es_correcta")
    private Boolean esCorrecta;

    private Integer orden;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "pregunta_id", nullable = false)
    private Pregunta pregunta;

}
