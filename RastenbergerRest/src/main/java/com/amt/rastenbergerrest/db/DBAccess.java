package com.amt.rastenbergerrest.db;

import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBAccess {
   private static final Map<Long,FoodOffer> FOOD_OFFERS = new HashMap<>();
   private static long index;
   
   static {
       FOOD_OFFERS.put(
               ++index,
               new FoodOffer("t.gießler","http://test1.de","ich bins der tobi",index)
       );
       
       FOOD_OFFERS.put(
               ++index,
               new FoodOffer("m.jäger","http://test2.de","ich bins der masl",index)
       );
       
       FOOD_OFFERS.put(
               ++index,
               new FoodOffer("a.weiß","http://test3.de","ich bins der alex",index)
       );        
   }
   
   public List<FoodOffer> getFoodOffers(){
       return new ArrayList<>(FOOD_OFFERS.values());
       
   }
   
   public FoodOffer addFoodOffer(FoodOffer foodOffer) {
       FOOD_OFFERS.put(
               ++index,
               foodOffer
       );        
       
       foodOffer.setId(index);
       
       return foodOffer;
   }
   
   public FoodOffer updateFoodOffer(Long index, FoodOffer foodOffer) {
       
       // TODO
       
       return foodOffer;
   }
   
}
