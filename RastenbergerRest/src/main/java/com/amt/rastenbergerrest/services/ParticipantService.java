package com.amt.rastenbergerrest.services;

import com.amt.rastenbergerrest.db.EntityManagerFactoryProvider;
import com.amt.rastenbergerrest.db.ParticipantEntity;
import com.amt.rastenbergerrest.models.Participant;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@RequestScoped
public class ParticipantService {

    @Inject
    private EntityManagerFactory factory;

    public Participant createParticipant(Participant participant) {
        EntityManager em = factory.createEntityManager();

        ParticipantEntity createdParticipant = new ParticipantEntity(participant);

        em.getTransaction().begin();
        em.persist(createdParticipant);
        em.getTransaction().commit();
        em.close();

        participant.setId(createdParticipant.getId());

        return participant;
    }
}
