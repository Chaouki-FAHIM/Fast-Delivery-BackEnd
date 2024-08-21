package com.fastDelivery.dto.response;

import com.fastDelivery.enumerator.StatutRamassage;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@NoArgsConstructor
@Getter @Setter @ToString
@Schema(description = "Ramassage Response DTO")
public class RamassageResDTO extends PersonneResDTO {

    private String reference;
    private Double frais;
    private String note;
    private String statutRamassage;
    private List<Long> listIdColis;


    public RamassageResDTO(Long idPersonne, Date dateCreationClient, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String reference, String note, String statutRamassage, List<Long> listIdColis) {
        super(idPersonne, dateCreationClient, nom, prenom, ville, adresseLocale, numeroTelephone);
        this.reference = reference;
        this.frais = 0D;
        this.note = note;
        this.statutRamassage = statutRamassage;
        this.listIdColis = listIdColis;
    }
}
