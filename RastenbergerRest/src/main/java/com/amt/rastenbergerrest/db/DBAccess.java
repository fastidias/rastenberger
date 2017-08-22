package com.amt.rastenbergerrest.db;

import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {

    private static final List<FoodOffer> FOOD_OFFERS = new ArrayList<>();
    private static Integer index = 0;

    static {
        FOOD_OFFERS.add(
                new FoodOffer("t.gießler", "http://test1.de", "ich bins der tobi", getNextID())
        );

        FOOD_OFFERS.add(
                new FoodOffer("m.jäger", "http://test2.de", "ich bins der masl", getNextID())
        );

        FOOD_OFFERS.add(
                new FoodOffer("a.weiß", "http://test3.de", "ich bins der alex", getNextID())
        );
    }

    public List<FoodOffer> getFoodOffers() {
        return FOOD_OFFERS;

    }

    public FoodOffer addFoodOffer(FoodOffer foodOffer) {
        foodOffer.setId(getNextID());

        FOOD_OFFERS.add(
                foodOffer
        );

        return foodOffer;
    }

    private static Integer getNextID() {

        return index++;
    }

    private static Integer getID() {
        return index;
    }

    public FoodOffer updateFoodOffer(FoodOffer foodOffer, Integer id) {

        FoodOffer oldFoodOffer = getFoodOfferByID(id);

        oldFoodOffer.setDescription(foodOffer.getDescription());
        oldFoodOffer.setExternalLink(foodOffer.getExternalLink());
        oldFoodOffer.setOwner(foodOffer.getOwner());

        return foodOffer;
    }

    public FoodOffer getFoodOfferByID(final Integer id) {
        for (FoodOffer foodOffer : getFoodOffers()) {
            if (foodOffer.getId().equals(id)) {
                return foodOffer;
            }
        }
        throw new RuntimeException("FooderOffer not found");
    }

    public void deleteFoodOfferByID(final Integer id) {
        FOOD_OFFERS.remove(getFoodOfferByID(id));
    }

}
