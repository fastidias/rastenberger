package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.models.FoodOffer;
import com.amt.rastenbergerrest.service.FoodOfferService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("foodoffers")
@Produces(MediaType.APPLICATION_JSON)
public class FoodOfferResource {

    // For methods as additionl params there are @QueryParams("foodOfferTest")
    @GET
    public List<FoodOffer> getFoodOffers(@Context UriInfo uriinfo) {
        FoodOfferService service = new FoodOfferService();
        List<FoodOffer> foodOffers = this.addSelfLink(service.getFoodOffers(), uriinfo);

        return foodOffers;

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public FoodOffer createFoodOffer(@Context UriInfo uriinfo, final FoodOffer foodOffer) {

        foodOffer.saveToDatabase();
        this.addSelfLink(foodOffer, uriinfo);

        return foodOffer;
    }

//    @GET
//    @Path("{id}")
//    public FoodOffer getFoodOffer(@Context UriInfo uriinfo, @PathParam("id") Long id) {
//
//        return this.addSelfLink(dba.getFoodOfferByID(id), uriinfo);
//    }
//
//    @PUT
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public FoodOffer updateFoodOffer(@Context UriInfo uriinfo, @PathParam("id") Long id, final FoodOffer foodOffer) {
//
//        return this.addSelfLink(dba.updateFoodOffer(foodOffer, id), uriinfo);
//    }
//
//    @DELETE
//    @Path("{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteFoodOffer(@PathParam("id") Long id) {
//        dba.deleteFoodOfferByID(id);
//    }
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
