package com.fastDelivery.dto.response;

import com.fastDelivery.enumerator.StatutColis;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.util.Date;


@NoArgsConstructor
@Getter @Setter @ToString
@Schema(description = "Colis Response DTO")
public class ColisResDTO extends PersonneResDTO {

    private String reference;
    private Double montant;
    private String villeRamassage;
    private String description;
    private String note;
    private String statutColis;
    private Boolean echange;
    private Boolean ouverture;
    private Boolean essayage;
    private Double fraisLivraison;

    public ColisResDTO(Long idPersonne, Date dateCreationClient, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String reference, Double montant, String villeRamassage, String description, String note, String statutColis,Boolean echange, Boolean ouverture, Boolean essayage) {
        super(idPersonne, dateCreationClient, nom, prenom, ville, adresseLocale, numeroTelephone);
        this.reference = reference;
        this.montant = montant;
        this.villeRamassage = villeRamassage;
        this.description = description;
        this.note = note;
        this.statutColis = statutColis;
        this.echange = echange;
        this.ouverture = ouverture;
        this.essayage = essayage;
        this.fraisLivraison = 35D;
    }
}
