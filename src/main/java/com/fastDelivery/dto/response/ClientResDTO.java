package com.fastDelivery.dto.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;


@Setter
@Getter
@ToString
@Schema(description = "Client Response DTO")
public class ClientResDTO extends PersonneResDTO {

    private String email;
    private String cin;
    private String rib;
    private String denominationBanque;

    public ClientResDTO(Long idPersonne, Date dateCreationClient, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String email, String cin, String rib, String denominationBanque) {
        super(idPersonne, dateCreationClient, nom, prenom, ville, adresseLocale, numeroTelephone);
        this.email = email;
        this.cin = cin;
        this.rib = rib;
        this.denominationBanque = denominationBanque;
    }
}
