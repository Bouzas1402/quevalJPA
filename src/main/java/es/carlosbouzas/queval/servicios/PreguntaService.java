package es.carlosbouzas.queval.servicios;

import es.carlosbouzas.queval.entities.Examen;
import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.entities.Respuesta;
import es.carlosbouzas.queval.repositorios.ExamenRepositorio;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Startup
@Singleton
public class PreguntaService {

    @Inject
    PreguntaRepositorio preguntaRepositorio;

    @Inject
    ExamenRepositorio examenRepositorio;

    private static final Long PREGUNTA_ID_1 = 1L;
    private static final String RESPUESTA_DOC_1 = "R001";

    public void testFindByid(){
       // Optional<Respuesta> respuesta = preguntaRepositorio.
    }

    @PostConstruct
    public void init() {
        //testManyToMany();
    }
}
