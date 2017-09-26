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
    private Integer amount;
    private String comment;

    public ParticipantEntity(Participant participant) {
        this.firstName  = participant.getFirstName();
        this.LastName   = participant.getLastName();
        this.amount     = participant.getAmount();
        this.comment    = participant.getComment();
    }

    public ParticipantEntity() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer price) {
        this.amount = price;
    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
