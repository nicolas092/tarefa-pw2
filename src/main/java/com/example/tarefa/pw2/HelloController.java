package com.example.tarefa.pw2;

import javax.inject.Singleton;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 */
@Path("/conversao")
@Singleton
public class HelloController {

    public static final double FATOR_KMH_PARA_MPH = 0.621371;
    public static final double FATOR_NOS_PARA_KMH = 1.852;

    // Quilômetro por hora para milhas por hora (1=0.621371) – esse método deve
    // responder por POST e receber/enviar dados em form-encoded
    @POST
    @Path("/kmhParaMph")
    @Produces(value = MediaType.TEXT_PLAIN) // pode comentar essa linha porque TEXT_PLAIN ja eh o padrao
    public double converterKmhParaMph(@FormParam("km") double km) {
        return km * FATOR_KMH_PARA_MPH;
    }

    // Nós para quilometro por hora (1=1.852) – esse método deve responder por POST
    // e receber/enviar dados em JSON
    @GET
    @Path("/nosParaKmh/{nos}")
    @Produces(MediaType.APPLICATION_JSON)
    public double converterNosParaKmh(@PathParam("nos") double nos) {
        return nos * FATOR_NOS_PARA_KMH;
    }

}
