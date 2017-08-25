package com.amt.rastenbergerrest.db;

import com.amt.rastenbergerrest.models.FoodOffer;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FoodOfferEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String owner;
    private String externalLink;
    private String description;

    public FoodOfferEntity() {
    }

    public FoodOfferEntity(FoodOffer foodoffer) {
        this.owner = foodoffer.getOwner();
        this.externalLink = foodoffer.getExternalLink();
        this.description = foodoffer.getDescription();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FoodOfferEntity)) {
            return false;
        }
        FoodOfferEntity other = (FoodOfferEntity) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "com.amt.rastenbergerrest.db.FoodOffer[ id=" + id + " ]";
    }
    
}
