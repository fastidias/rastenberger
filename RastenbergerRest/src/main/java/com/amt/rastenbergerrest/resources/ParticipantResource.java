package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.models.Participant;
import com.amt.rastenbergerrest.services.ParticipantService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
public class ParticipantResource {

    // TODO: use injection
    private ParticipantService service = new ParticipantService();

    @GET
    public List<Participant> getParticipants() {

        throw new RuntimeException("please implement get all test");
    }

    @GET
    @Path("{participantID}")
    public Participant getParticipant() {

        throw new RuntimeException("please implement get test");
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Participant createParticipant(final Participant participant) {

        return service.createParticipant(participant);
    }

    @PUT
    @Path("{participantID}")
    public Participant updateParticipant() {
        throw new RuntimeException("please implement put test");
    }

    @DELETE
    @Path("{participantID}")
    public void deleteParticipant() {
        throw new RuntimeException("please implement delete test");
    }
}
