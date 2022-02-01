package com.simulation.Parkhaus.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Parkticket {

    private final UUID id;
    private final String zahl;

    public Parkticket(@JsonProperty("id") UUID id,
                      @JsonProperty("zahl") String zahl) {
        this.id = id;
        this.zahl = zahl;
    }

    public UUID getId() {
        return id;
    }

    public String getZahl() {
        return zahl;
    }
}
