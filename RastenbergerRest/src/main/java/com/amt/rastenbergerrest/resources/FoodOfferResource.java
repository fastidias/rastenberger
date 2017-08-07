package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.db.DBAccess;
import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("foodoffers")
public class FoodOfferResource {

    private final DBAccess dba = new DBAccess();
            
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<FoodOffer> getFoodOffers() {

        return dba.getFoodOffers();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public FoodOffer createFoodOffer(final FoodOffer foodOffer) {
        
        dba.addFoodOffer(foodOffer);
        return foodOffer; 
    }

}
