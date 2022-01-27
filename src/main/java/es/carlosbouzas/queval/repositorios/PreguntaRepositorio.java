package es.carlosbouzas.queval.repositorios;

import es.carlosbouzas.queval.entities.Pregunta;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;


@Repository
public interface PreguntaRepositorio extends EntityRepository<Pregunta, Long> {

    Pregunta findByCodigo(String codigo);

    Pregunta preguntaPorId(Long id);
}
