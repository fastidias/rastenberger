package com.amt.rastenbergerrest.models;

import com.amt.rastenbergerrest.db.ParticipantEntity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Participant {

    private Long id;
    private String firstName;
    private String lastName;
    private String comment;

    // TODO: Make me money :)
    private Integer amount;

    public Participant(ParticipantEntity participantEntity) {
        this.id         = participantEntity.getId();
        this.firstName  = participantEntity.getFirstName();
        this.lastName   = participantEntity.getLastName();
        this.amount     = participantEntity.getAmount();
        this.comment    = participantEntity.getComment();
    }

    public Participant(String firstName, String lastName, Integer amount, String comment, Long id) {
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.amount     = amount;
        this.comment    = comment;
        this.id         = id;
    }

    public Participant() {
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
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getFirstName() {
        return firstName;

    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}
