package com.amt.rastenbergerrest.db;

import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
   private static final List<FoodOffer> FOOD_OFFERS = new ArrayList<>();
   private static long index;
   
   static {
       FOOD_OFFERS.add(
               new FoodOffer("t.gießler","http://test1.de","ich bins der tobi",getNextID())
       );
       
       FOOD_OFFERS.add(
               new FoodOffer("m.jäger","http://test2.de","ich bins der masl",getNextID())
       );
       
       FOOD_OFFERS.add(
               new FoodOffer("a.weiß","http://test3.de","ich bins der alex",getNextID())
       );        
   }
   
   public List<FoodOffer> getFoodOffers(){
       return FOOD_OFFERS;
       
   }
   
   public FoodOffer addFoodOffer(FoodOffer foodOffer) {       
       foodOffer.setId(getNextID());

       FOOD_OFFERS.add(
               foodOffer
       );        
       
       return foodOffer;
   }
   
    private static Long getNextID() {
        
        return ++index;
    }
    
    private static Long getID() {
        return index;
    }
   
   public FoodOffer updateFoodOffer(Long index, FoodOffer foodOffer) {
       
       // TODO
       
       return foodOffer;
   }
   
}