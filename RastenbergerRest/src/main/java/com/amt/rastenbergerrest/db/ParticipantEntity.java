package com.amt.rastenbergerrest.db;

import com.amt.rastenbergerrest.models.Participant;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ParticipantEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String LastName;
    private Integer cost;

    public ParticipantEntity(Participant participant) {
        this.firstName  = participant.getFirstName();
        this.LastName   = participant.getLastName();
        this.cost = participant.getCost();
    }

    public ParticipantEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer price) {
        this.cost = price;
    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
