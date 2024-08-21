package com.fastDelivery.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


@NoArgsConstructor
@Getter @Setter @ToString
@Schema(description = "Colis Request DTO")
public class ColisReqDTO extends PersonneReqDTO {

    private Double montant;
    private String villeRamassage;
    private String description;
    private String note;
    private Boolean echange;
    private Boolean ouverture;
    private Boolean essayage;


    public ColisReqDTO(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String ref, Double montant, String villeRamassage, String description, String note, Boolean echange, Boolean ouverture, Boolean essayage) {
        super(nom, prenom, ville, adresseLocale, numeroTelephone);
        this.montant = montant;
        this.villeRamassage = villeRamassage;
        this.description = description;
        this.note = note;
        this.echange = echange;
        this.ouverture = ouverture;
        this.essayage = essayage;
    }
}
