package es.carlosbouzas.queval.servicios;


import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.entities.Respuesta;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import es.carlosbouzas.queval.repositorios.RespuestaRepositorio;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.transaction.UserTransaction;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

@Slf4j
@ApplicationScoped
public class RespuestaServicioTest {

    // Solamente es necesario injectarlo si vamos a usar métodos como clear(), detach()
    // para probar alguna parte del ciclo de vida. O si queremos usar las clases del paquete dao
    // De lo contrario, con @Repository deberíamos tener cubierta la mayor parte de funcionalidad.
    //@PersistenceContext
    //EntityManager em;

    // Usaremos UserTransaction en lugar de EntityTransaction
    // EntityTransaction no muestra el comportamiento esperado en combinación con @Repository
    @Resource
    UserTransaction transaction;

    @Inject
    RespuestaRepositorio respuestaRepository;

    @Inject
    PreguntaRepositorio preguntaRepository;

    private static final Long PREGUNTA_ID_1 = 1L;
    private static final String PREGUNTA_COD_1 = "P001";
    private static final String PREGUNTA_COD_2 = "P002";
    private static final String RESPUESTA_COD_1 = "R01";
    private static final String RESPUESTA_COD_2 = "R02";
    private static final String RESPUESTA_COD_3 = "R03";

    public void testFindById() {
        Optional<Respuesta> respuesta = respuestaRepository.findOptionalBy(PREGUNTA_ID_1);
        respuesta.ifPresent(resp -> log.debug("Respuesta encontrada: {} {}", resp.getCodigo(), resp.getTexto()));
    }

    public void testFindByCodigo() {
        List<Respuesta> respuestas = respuestaRepository.findByCodigoOrderByOrdenAsc(RESPUESTA_COD_1);
        respuestas.forEach(resp -> log.debug("Respuesta encontrada: {} {}", resp.getCodigo(), resp.getTexto()));
    }

    public void testCascadeInsert() throws Exception {
        Pregunta pregunta = new Pregunta();
        pregunta.setCodigo(PREGUNTA_COD_2);
        pregunta.setDificultad(1);
        pregunta.setTexto("Pregunta2");
        Respuesta respuesta = new Respuesta();
        respuesta.setCodigo("R03");
        respuesta.setOrden(3);
        respuesta.setTexto("Respuesta4");
        respuesta.setPregunta(pregunta);
        try {
            transaction.begin();
            //preguntaRepository(pregunta);  //No hace falta si está activado CascadeType.PERSIST
            respuestaRepository.save(respuesta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null ) {
                transaction.rollback();
            }
            throw e;
        }
    }

    public void testCascadeUpdate() throws Exception {
        log.debug("Buscando respuesta");
        Respuesta respuesta = respuestaRepository.findByCodigo(RESPUESTA_COD_3);
        log.debug("Buscando pregunta");
        Pregunta pregunta = preguntaRepository.findByCodigo(PREGUNTA_COD_1);
        log.debug("Actualizando pregunta");
        pregunta.setTexto("Nuevo texto de preguntas con @Repository");
        log.debug("Actualizando respuesta");
        respuesta.setPregunta(pregunta);

        log.debug("Guardando respuesta");
        try {
            transaction.begin();
            respuestaRepository.save(respuesta);
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
            testFindById();
            testFindByCodigo();
            testCascadeInsert();
            testCascadeUpdate();
        } catch (Exception e) {
            log.debug ("Se ha producido una excepción", e);
        }
    }
}
