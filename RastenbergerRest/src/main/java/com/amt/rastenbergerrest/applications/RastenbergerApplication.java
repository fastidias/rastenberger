package com.amt.rastenbergerrest.applications;

import com.amt.rastenbergerrest.resources.FoodOfferResource;
import com.amt.rastenbergerrest.resources.ParticipantResource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("rs")
public class RastenbergerApplication extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(FoodOfferResource.class);
        classes.add(ParticipantResource.class);
        return classes;
    }
    
    
    
}
