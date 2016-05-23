package com.thedevpiece.kumuluzee.deltaspike.entities.base;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Gabriel Francisco <gabfssilva@gmail.com>
 */
public class Envelop {
    private List<Message> messages;
    private Map<String, Link> links;

    @JsonIgnore
    private Map<String, Object> otherProperties;

    @JsonAnyGetter
    public Map<String, Object> getOtherProperties() {
        return otherProperties;
    }

    public Envelop addLink(String key, Link link) {
        if (this.links == null) links = new HashMap<>();
        this.links.put(key, link);
        return this;
    }

    public Envelop addLink(String key, String href) {
        if (this.links == null) links = new HashMap<>();
        this.links.put(key, new Link(() -> href));
        return this;
    }

    public Envelop addMessage(String message) {
        if (this.messages == null) messages = new ArrayList<>();
        this.messages.add(new Message(message));
        return this;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Envelop addMessage(String type, String message) {
        if (this.messages == null) messages = new ArrayList<>();
        this.messages.add(new Message(type, message));
        return this;
    }

    public Envelop addResource(EntityResource entityResource) {
        if (this.otherProperties == null) otherProperties = new HashMap<>();
        this.otherProperties.put(entityResource.resourceName(), entityResource);
        return this;
    }

    public Envelop addResources(String resource, List<? extends EntityResource<?>> entityResources) {
        if (this.otherProperties == null) otherProperties = new HashMap<>();
        this.otherProperties.put(resource, entityResources);
        return this;
    }
}
