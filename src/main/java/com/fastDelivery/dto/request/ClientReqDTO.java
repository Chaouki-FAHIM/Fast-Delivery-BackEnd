package com.fastDelivery.dto.request;


import jakarta.validation.constraints.*;
import lombok.*;


@Setter
@Getter
@ToString
@Builder
public class ClientReqDTO {

    @NotBlank(message = "Password est obligatoire")
    @Size(min = 8, message = "Password excepte juste 8 caractère et plus")
    private String password;

    @NotBlank(message = "Email est obligatoire")
    @Email(message = "Email excepte juste son format")
    private String email;

    @NotBlank(message = "Nom est obligatoire")
    private String nom;

    @NotBlank(message = "Prénom est obligatoire")
    private String prenom;

    @NotBlank(message = "Ville est obligatoire")
    private String ville;

    @NotBlank(message = "Numero téléphone est obligatoire")
    private String numeroTelephone;

    @NotBlank(message = "CIN est obligatoire")
    private String cin;

    @NotBlank(message = "RIB est obligatoire")
    private String rib;

    @NotBlank(message = "Dénomination de banque est obligatoire")
    private String denominationBanque;

}
