package com.amt.rastenbergerrest.service;

import com.amt.rastenbergerrest.db.FoodOfferEntity;
import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class FoodOfferService {

    private static final String PERSISTENCE_UNIT_NAME = "com.amt_RastenbergerRest_war_0.1PU";
    private EntityManagerFactory factory;
    
    public List<FoodOffer> getFoodOffers() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        
        Query query = em.createQuery("SELECT e FROM FoodOfferEntity e");
        List<FoodOfferEntity> foodOffersEntities = query.getResultList();
        em.close();
        
        return foodOffersEntities
                .stream()
                .map(entity -> new FoodOffer(entity))
                .collect(Collectors.toList());
    }
    
}