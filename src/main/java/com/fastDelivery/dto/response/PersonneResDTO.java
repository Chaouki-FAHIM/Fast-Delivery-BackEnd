package com.fastDelivery.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Personne Response DTO")
public class PersonneResDTO {

    @JsonProperty("id")
    protected Long idPersonne;

    @JsonProperty("date_creation")
    protected Date dateCreationClient;

    protected String nom;
    protected String prenom;
    protected String ville;
    protected String adresseLocale;
    protected String numeroTelephone;
}
