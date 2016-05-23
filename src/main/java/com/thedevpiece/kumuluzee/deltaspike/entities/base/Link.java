package com.thedevpiece.kumuluzee.deltaspike.entities.base;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Transient;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class Link  {
    @JsonIgnore
    @Transient
    private Href href;

    @JsonIgnore
    private Map<String, Object> otherProperties;

    public Link(Href href) {
        this.href = href;
    }

    @JsonProperty
    public String getHref() {
        return href.href();
    }

    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return otherProperties;
    }

    @JsonAnySetter
    public Link set(String key, Object value) {
        if (this.otherProperties == null) otherProperties = new HashMap<>();
        this.otherProperties.put(key, value);
        return this;
    }
}
