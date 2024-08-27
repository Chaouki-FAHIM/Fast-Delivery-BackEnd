package com.fastDelivery.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
<<<<<<< HEAD
import lombok.*;
=======
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179

import java.util.Date;

@Setter
@Getter
@ToString
@AllArgsConstructor
<<<<<<< HEAD
@NoArgsConstructor
@Schema(description = "Personne Response DTO")
=======
@Schema(description = "Client Response DTO")
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
public class PersonneResDTO {

    @JsonProperty("id")
    protected Long idPersonne;

<<<<<<< HEAD
=======
    @JsonProperty("email")
    protected String emailClient;

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    @JsonProperty("date_creation")
    protected Date dateCreationClient;

    protected String nom;
<<<<<<< HEAD
    protected String prenom;
    protected String ville;
    protected String adresseLocale;
=======

    protected String prenom;

    @JsonProperty("ville")
    protected String ville;

    protected String adresseLocale;

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    protected String numeroTelephone;
}
