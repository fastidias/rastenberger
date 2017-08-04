package com.amt.rastenbergerrest.resources;

import com.amt.rastenbergerrest.models.FoodOffer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("foodoffers")
public class FoodOfferResource {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public FoodOffer getResource () {
     
        FoodOffer foodOffer = new FoodOffer();
        foodOffer.setOwner("Tobias Gießler");
        foodOffer.setDescription("Eat my ....");
        foodOffer.setExternalLink("https://epages.de");
                
        return foodOffer;
    }
    
}
