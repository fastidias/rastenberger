package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.models.FoodOffer;
import com.amt.rastenbergerrest.services.FoodOfferService;
import java.net.URI;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("/foodoffers")
@Produces(MediaType.APPLICATION_JSON)
public class FoodOfferResource {

    @Inject
    private FoodOfferService service;

    // For methods as additional params there are @QueryParams("foodOfferTest")
    @GET
    public List<FoodOffer> getFoodOffers(@Context UriInfo uriinfo) {
        List<FoodOffer> foodOffers = this.addSelfLink(service.getFoodOffers(), uriinfo);

        return foodOffers;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFoodOffer(@Context UriInfo uriinfo, final FoodOffer foodOffer) {

        FoodOffer createdOffer = service.createFoodOffer(foodOffer);

        this.addSelfLink(createdOffer, uriinfo);

        final URI addedUri = uriinfo
                .getAbsolutePathBuilder()
                .path(Long.toString(createdOffer.getId()))
                .build();

        return Response.created(addedUri).status(Response.Status.CREATED).entity(createdOffer).build();
    }

    @GET
    @Path("{offerId}")
    public Response getFoodOffer(@Context UriInfo uriinfo, @PathParam("offerId") Long offerId) {
        final FoodOffer matchingOffer = service.getFoodOfferById(offerId);

        final URI addedUri = uriinfo
                .getAbsolutePathBuilder()
                .path(Long.toString(matchingOffer.getId()))
                .build();

        return Response.created(addedUri).status(Response.Status.OK).entity(matchingOffer).build();
    }

    @PUT
    @Path("{offerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateFoodOffer(@Context UriInfo uriinfo, @PathParam("offerId") Long offerId, final FoodOffer foodOffer) {

        foodOffer.setId(offerId);

        FoodOffer updatedOffer = service.updateFoodOffer(foodOffer);

        final URI addedUri = uriinfo
                .getAbsolutePathBuilder()
                .path(Long.toString(updatedOffer.getId()))
                .build();

        return Response.created(addedUri).status(Response.Status.OK).entity(updatedOffer).build();
    }

    @DELETE
    @Path("{offerId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFoodOffer(@Context UriInfo uriinfo, @PathParam("offerId") Long offerId) {
        final FoodOffer matchingFoodOffer = service.getFoodOfferById(offerId);

        service.deleteFoodOffer(matchingFoodOffer);

        final URI addedUri = uriinfo
                .getAbsolutePathBuilder()
                .build();

        return Response.created(addedUri).status(Response.Status.NO_CONTENT).build();
    }

    // Add sub resource
    @Path("{offerId}/participants")
    public ParticipantResource getParticipantResource() {
        return new ParticipantResource();
    }


    private List<FoodOffer> addSelfLink(List<FoodOffer> foodOffers, UriInfo uriinfo) {
        foodOffers.forEach((foodOffer) -> {
            this.addSelfLink(foodOffer, uriinfo);
        });

        return foodOffers;
    }

    private FoodOffer addSelfLink(FoodOffer foodOffer, UriInfo uriinfo) {

        foodOffer.addLink(uriinfo.getBaseUriBuilder().path(getClass()).path(Long.toString(foodOffer.getId())).build().toString(), "self");
        return foodOffer;
    }

}
