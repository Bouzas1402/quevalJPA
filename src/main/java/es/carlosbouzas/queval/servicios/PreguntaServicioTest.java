package es.carlosbouzas.queval.servicios;


import es.carlosbouzas.queval.entities.Examen;
import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.repositorios.ExamenRepositorio;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@ApplicationScoped
public class PreguntaServicioTest {

    @Resource
    UserTransaction transaction;

    @Inject
    PreguntaRepositorio preguntaRepository;
    @Inject
    ExamenRepositorio examenRepository;

    private static final Long PREGUNTA_ID_1 = 1L;
    private static final Long EXAMEN_ID_1 = 1L;
    private static final Long EXAMEN_ID_2 = 2L;
    private static final String PREGUNTA_COD_2 = "P002";

    public void testManyToMany() throws Exception {
        Optional<Pregunta> pregunta = preguntaRepository.findOptionalBy(PREGUNTA_ID_1);
        if (pregunta.isPresent()) {
            log.debug("Exámenes de la pregunta {} {}", PREGUNTA_ID_1, pregunta.get().getExamenes());

            Optional<Examen> examen1 = examenRepository.findOptionalBy(EXAMEN_ID_1);
            Optional<Examen> examen2 = examenRepository.findOptionalBy(EXAMEN_ID_2);

            Set<Examen> examenes = new LinkedHashSet<>();
            examen1.ifPresent(ex -> examenes.add(ex));
            examen2.ifPresent(ex -> examenes.add(ex));

            pregunta.get().setExamenes(examenes);
            try {
                transaction.begin();
                preguntaRepository.save(pregunta.get());
                transaction.commit();
            } catch (Exception e) {
                if (transaction != null ) {
                    transaction.rollback();
                }
                throw e;
            }

        } else {
            log.debug("No existe pregunta {}", PREGUNTA_ID_1);
        }

    }

    public void testOrphanRemoval() throws Exception {
        log.debug("Buscando pregunta");
        Pregunta pregunta = preguntaRepository.findByCodigo(PREGUNTA_COD_2);

        log.debug("Borrando pregunta y sus respuestas asociadas");
        try {
            transaction.begin();
            preguntaRepository.attachAndRemove(pregunta);
            //preguntaRepository.remove(pregunta); // da excepción de intento de borrado de una entidad desligada
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null ) {
                transaction.rollback();
            }
            throw e;
        }
    }


    public void onStart(@Observes @Initialized(ApplicationScoped.class) Object objeto) {
        log.debug("Ejecutado al arrancar");
        try {
            testManyToMany();
            testOrphanRemoval();
        } catch (Exception e) {
            log.debug ("Se ha producido una excepción", e);
        }
    }



}
