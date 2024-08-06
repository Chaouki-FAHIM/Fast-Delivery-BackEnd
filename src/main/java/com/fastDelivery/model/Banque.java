package com.fastDelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Banque {
    @JsonProperty("bank")
    private String nomBanque;
}
