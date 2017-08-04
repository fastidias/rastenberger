package com.amt.rastenbergerrest.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("foodoffers")
public class FoodOfferResource {
    
    @GET
    public String getResource () {
     
        return "Test";
    }
    
}
