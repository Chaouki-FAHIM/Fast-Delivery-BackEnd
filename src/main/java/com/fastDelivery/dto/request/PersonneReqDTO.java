package com.fastDelivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Schema(description = "Personne request DTO")
public abstract class PersonneReqDTO {

    protected String password;
    protected String email;
    protected String nom;
    protected String prenom;
    protected String ville;
    protected String adresseLocale;
    protected String numeroTelephone;
}
