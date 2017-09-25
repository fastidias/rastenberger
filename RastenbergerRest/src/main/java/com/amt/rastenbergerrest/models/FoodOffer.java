package com.amt.rastenbergerrest.models;

import com.amt.rastenbergerrest.db.FoodOfferEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FoodOffer {

    private String owner;
    private String externalLink;
    private String description;
    private Long id;
    private List<Link> links;

    public FoodOffer(FoodOfferEntity foodOffer) {
        this(
                foodOffer.getOwner(),
                foodOffer.getExternalLink(),
                foodOffer.getDescription(),
                foodOffer.getId());
    }
    
    public FoodOffer(String owner, String externalLink, String description, Long id) {
        this.owner = owner;
        this.externalLink = externalLink;
        this.description = description;
        this.id = id;
        links = new ArrayList<>();
    }

    public FoodOffer() {
        links = new ArrayList<>();
    }

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

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }
  
    public void addLink(String uri, String relation) {
        links.add(new Link(uri, relation));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.owner);
        hash = 29 * hash + Objects.hashCode(this.externalLink);
        hash = 29 * hash + Objects.hashCode(this.description);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FoodOffer other = (FoodOffer) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        if (!Objects.equals(this.externalLink, other.externalLink)) {
            return false;
        }
        return Objects.equals(this.description, other.description);
    }

}
