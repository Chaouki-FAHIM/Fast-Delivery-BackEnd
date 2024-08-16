package com.fastDelivery.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Setter
@Getter
@ToString
@Schema(description = "Client request DTO")
public class ClientReqDTO  extends PersonneReqDTO {

    private String cin;
    private String rib;
    private String denominationBanque;

    public ClientReqDTO( String password, String email,String nom, String prenom, String ville, String adresseLocale,String numeroTelephone) {
        super(password, email, nom, prenom, ville, adresseLocale, numeroTelephone);
    }
}
