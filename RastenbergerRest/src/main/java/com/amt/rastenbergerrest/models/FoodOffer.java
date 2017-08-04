package com.amt.rastenbergerrest.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoodOffer {

    private String owner;
    private String externalLink;
    private String description;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
