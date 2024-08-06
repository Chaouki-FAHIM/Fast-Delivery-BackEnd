package com.fastDelivery.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
@Builder
public class ClientResDTO {

    @JsonProperty("id")
    private Long idClient;

    @JsonProperty("email")
    private String emailClient;

    @JsonProperty("date_creation")
    private Date dateCreationClient;

    @JsonProperty("nom")
    private String nom;

    @JsonProperty("prenom")
    private String prenom;

    @JsonProperty("ville")
    private String ville;

    @JsonProperty("numero_telephone")
    private String numeroTelephone;

    @JsonProperty("cin")
    private String cin;

    @JsonProperty("rib")
    private String rib;

    @JsonProperty("denomination_banquaire")
    private String denominationBanque;

}
