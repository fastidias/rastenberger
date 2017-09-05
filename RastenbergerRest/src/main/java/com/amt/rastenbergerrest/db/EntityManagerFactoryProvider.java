package com.amt.rastenbergerrest.db;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryProvider {

    private static final String PERSISTENCE_UNIT_NAME = "com.amt_RastenbergerRest_war_0.1PU";

    @Produces
    public EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    }

}
