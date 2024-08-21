package com.fastDelivery.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;


@Setter
@Getter
@ToString
@Schema(description = "Client request DTO")
public class ClientReqDTO  extends PersonneReqDTO {

    protected String password;
    protected String email;
    private String cin;
    private String rib;
    private String denominationBanque;


    public ClientReqDTO(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String password, String denominationBanque, String rib, String cin, String email) {
        super(nom, prenom, ville, adresseLocale, numeroTelephone);
        this.password = password;
        this.denominationBanque = denominationBanque;
        this.rib = rib;
        this.cin = cin;
        this.email = email;
    }
}
