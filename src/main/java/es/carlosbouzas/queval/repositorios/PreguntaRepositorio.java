package es.carlosbouzas.queval.repositorios;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Stateless
public class PreguntaRepositorio {

    @PersistenceContext
    EntityManager em;

}
