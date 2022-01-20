package es.carlosbouzas.queval.servicios;

import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import jakarta.inject.Inject;

public class PreguntaService {

    @Inject
    PreguntaRepositorio preguntaRepositorio;


    private void testManyToMany(){
       // Pregunta pregunta = preguntaRepositorio.findById(1L);
    }

}
