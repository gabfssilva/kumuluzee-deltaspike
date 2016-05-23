package com.thedevpiece.kumuluzee.deltaspike.entities.base;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
@MappedSuperclass
public abstract class EntityResource<T extends EntityResource> implements Serializable {
    @Id
    @GeneratedValue
    protected Long id;
    @JsonProperty("_links")
    @Transient
    private Map<String, Link> links;

    public EntityResource() {
        if (this.links == null) this.links = new HashMap<>();
        this.links.put("self", new Link(() -> "/api/" + resourceName() + "s/" + id.toString()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public abstract String resourceName();
}
