package com.amt.rastenbergerrest.models;

import com.amt.rastenbergerrest.db.ParticipantEntity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Participant {

    private Long id;
    private String firstName;
    private String lastName;

    // TODO: Make me money :)
    private Integer cost;

    public Participant(ParticipantEntity participantEntity) {
        this.id         = participantEntity.getId();
        this.firstName  = participantEntity.getFirstName();
        this.lastName   = participantEntity.getLastName();
        this.cost       = participantEntity.getCost();
    }

    public Participant(String firstName, String lastName, Integer cost, Long id) {
        this.firstName  = firstName;
        this.lastName = lastName;
        this.cost       = cost;
        this.id         = id;
    }

    public Participant() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
