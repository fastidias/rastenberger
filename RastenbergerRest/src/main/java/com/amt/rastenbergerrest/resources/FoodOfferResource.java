package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.db.DBAccess;
import com.amt.rastenbergerrest.models.FoodOffer;
import com.amt.rastenbergerrest.models.Links;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("foodoffers")
@Produces(MediaType.APPLICATION_JSON)
public class FoodOfferResource {
    // For methods as additionl params there are @QueryParams("foodOfferTest")
    private final DBAccess dba = new DBAccess();
            
    @GET
    public List<FoodOffer> getFoodOffers() {

        return dba.getFoodOffers();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public FoodOffer createFoodOffer(final FoodOffer foodOffer) {
        
        dba.addFoodOffer(foodOffer);
        return foodOffer; 
    }

    @GET
    @Path("{id}")
    public FoodOffer getFoodOffer(@Context UriInfo uriinfo, @PathParam("id") Long id) {
        
        FoodOffer foodOffer = dba.getFoodOfferByID(id);
        Links links = new Links(uriinfo.getBaseUriBuilder().path(getClass()).path(Long.toString(id)).build().toString());
        foodOffer.setLinks(links);
        
        return dba.getFoodOfferByID(id);
    }
        
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public FoodOffer updateFoodOffer(@PathParam("id") Long id, final FoodOffer foodOffer) {
        
        return dba.updateFoodOffer(foodOffer,id);
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteFoodOffer (@PathParam("id") Long id) {
        dba.deleteFoodOfferByID(id);    
    }
}
