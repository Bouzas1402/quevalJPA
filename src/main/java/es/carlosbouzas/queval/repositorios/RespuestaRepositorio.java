package es.carlosbouzas.queval.repositorios;

import es.carlosbouzas.queval.entities.Respuesta;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

import java.util.List;


@Repository
public interface RespuestaRepositorio extends EntityRepository<Respuesta, Long> {

    List<Respuesta> findByCodigoOrderByOrdenAsc(String codigo);


}
