package es.carlosbouzas.queval.servicios;

import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@ApplicationScoped
public class PreguntaService {

    @Inject
    PreguntaRepositorio preguntaRepositorio;

    public Pregunta preguntaPorId(Long id) {
        return preguntaRepositorio.findOptionalBy(id).get();
    }

}
