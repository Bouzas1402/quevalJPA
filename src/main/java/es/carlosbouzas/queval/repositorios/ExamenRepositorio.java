package es.carlosbouzas.queval.repositorios;

import es.carlosbouzas.queval.entities.Examen;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface ExamenRepositorio extends EntityRepository<Examen, Long> {


}
