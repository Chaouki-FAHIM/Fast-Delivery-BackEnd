package com.fastDelivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
<<<<<<< HEAD
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@Schema(description = "Personne request DTO")
public abstract class PersonneReqDTO {

=======
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
@Schema(description = "Personne request DTO")
public abstract class PersonneReqDTO {

    protected String password;
    protected String email;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    protected String nom;
    protected String prenom;
    protected String ville;
    protected String adresseLocale;
    protected String numeroTelephone;
<<<<<<< HEAD

=======
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
}
