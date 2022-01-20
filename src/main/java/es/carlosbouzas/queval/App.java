package es.carlosbouzas.queval;


import es.carlosbouzas.queval.servicios.PreguntaService;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Startup
public class App {

    @Inject
    PreguntaService ps;

    @PostConstruct
    public void init(){



    }
}
