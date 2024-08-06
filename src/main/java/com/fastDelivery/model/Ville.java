package com.fastDelivery.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ville {
    @JsonProperty("city")
    private String nomVille;
}
