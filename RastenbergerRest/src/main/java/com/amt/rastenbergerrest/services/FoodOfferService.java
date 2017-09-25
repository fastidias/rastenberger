package com.amt.rastenbergerrest.services;

import com.amt.rastenbergerrest.db.FoodOfferEntity;
import com.amt.rastenbergerrest.models.FoodOffer;
import java.util.List;
import java.util.stream.Collectors;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class FoodOfferService {

    @Inject
    private EntityManagerFactory factory;

    public FoodOffer createFoodOffer(FoodOffer foodOffer) {
        EntityManager em = factory.createEntityManager();

        FoodOfferEntity foodOfferEntity = new FoodOfferEntity(foodOffer);

        em.getTransaction().begin();
        em.persist(foodOfferEntity);
        em.getTransaction().commit();
        em.close();

        foodOffer.setId(foodOfferEntity.getId());

        return foodOffer;
    }

    public List<FoodOffer> getFoodOffers() {
        EntityManager em = factory.createEntityManager();

        Query query = em.createQuery("SELECT e FROM FoodOfferEntity e");
        List<FoodOfferEntity> foodOffersEntities = query.getResultList();
        em.close();

        return foodOffersEntities
                .stream()
                .map(entity -> new FoodOffer(entity))
                .collect(Collectors.toList());
    }

    public FoodOffer getFoodOfferById(final Long id) {
        return getFoodOffers()
                .stream()
                .findFirst()
                .filter(foodOffer -> foodOffer.getId().equals(id))
                .get();
    }

    public FoodOffer updateFoodOffer(final FoodOffer foodOffer) {
        EntityManager em = factory.createEntityManager();

        final FoodOfferEntity entity = em.find(
                FoodOfferEntity.class,
                foodOffer.getId());

        entity.setOwner(foodOffer.getOwner());
        entity.setDescription(foodOffer.getDescription());
        entity.setExternalLink(foodOffer.getExternalLink());

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();

        return foodOffer;
    }

    public void deleteFoodOffer(final FoodOffer foodOffer) {
        EntityManager em = factory.createEntityManager();

        final FoodOfferEntity entity = em.find(
                FoodOfferEntity.class,
                foodOffer.getId());

        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        em.close();

        return;
    }

}
