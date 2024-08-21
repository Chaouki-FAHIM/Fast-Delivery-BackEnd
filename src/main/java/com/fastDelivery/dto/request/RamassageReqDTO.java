package com.fastDelivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@NoArgsConstructor
@Getter @Setter @ToString
@Schema(description = "Ramassage Request DTO")
public class RamassageReqDTO extends PersonneReqDTO {

    private Double frais;
    private String note;
    private List<Long> listIdColis;


    public RamassageReqDTO( String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String note, List<Long> listIdColis) {
        super(nom, prenom, ville, adresseLocale, numeroTelephone);
        this.frais = 0D;
        this.note = note;
        this.listIdColis = listIdColis;
    }

}
