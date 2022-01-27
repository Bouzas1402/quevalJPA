package es.carlosbouzas.queval.controlador;

import es.carlosbouzas.queval.entities.Pregunta;
import es.carlosbouzas.queval.entities.Respuesta;
import es.carlosbouzas.queval.repositorios.PreguntaRepositorio;
import es.carlosbouzas.queval.repositorios.RespuestaRepositorio;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import org.eclipse.krazo.engine.Viewable;

import java.util.List;

@Path("preguntas")
@Controller
@RequestScoped
public class ControladorPregunta {


    @Inject
    private Models models;

    @Inject
    PreguntaRepositorio preguntaRepository;

    @GET
    @Path("{id}")
    public Viewable detalle(@PathParam("id") @NotNull Long id) {

        Pregunta pregunta = preguntaRepository.preguntaPorId(id);

        models.put("pregunta", pregunta);

        return new Viewable("pregunta-detalle.jsp");
    }

}
