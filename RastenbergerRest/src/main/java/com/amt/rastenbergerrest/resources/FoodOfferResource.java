package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.models.FoodOffer;
import com.amt.rastenbergerrest.service.FoodOfferService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("foodoffers")
@Produces(MediaType.APPLICATION_JSON)
public class FoodOfferResource {

    // For methods as additional params there are @QueryParams("foodOfferTest")
    @GET
    public List<FoodOffer> getFoodOffers(@Context UriInfo uriinfo) {
        FoodOfferService service = new FoodOfferService();
        List<FoodOffer> foodOffers = this.addSelfLink(service.getFoodOffers(), uriinfo);

        return foodOffers;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createFoodOffer(@Context UriInfo uriinfo, final FoodOffer foodOffer) {

        foodOffer.saveToDatabase();
        this.addSelfLink(foodOffer, uriinfo);
        
        final URI addedUri = uriinfo
                .getAbsolutePathBuilder()
                .path(Long.toString(foodOffer.getId()))
                .build();

        return Response.created(addedUri).entity(foodOffer).build();
    }

    @GET
    @Path("{id}")
    public FoodOffer getFoodOffer(@Context UriInfo uriinfo, @PathParam("id") Long id) {
        final FoodOfferService service = new FoodOfferService();
        final FoodOffer matchingFoodOffer = service.getFoodOfferById(id);

        return this.addSelfLink(matchingFoodOffer, uriinfo);
    }

//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public FoodOffer updateFoodOffer(@Context UriInfo uriinfo, @PathParam("id") Long id, final FoodOffer foodOffer) {
//
//        return this.addSelfLink(dba.updateFoodOffer(foodOffer, id), uriinfo);
//    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteFoodOffer(@PathParam("id") Long id) {
        final FoodOfferService service = new FoodOfferService();
        final FoodOffer matchingFoodOffer = service.getFoodOfferById(id);
        
        service.deleteFoodOffer(matchingFoodOffer);
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
