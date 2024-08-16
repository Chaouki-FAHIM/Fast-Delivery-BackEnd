package com.fastDelivery.entities;

import com.fastDelivery.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.Random;

@Entity
@Table(name="t_colis")
@Getter
@Setter
@ToString
public class Colis extends Personne {

    @Column(nullable = false, unique = true, length = 15)
    @NotNull(message = "Référence est obligatoire")
    private String reference;

    @Column(nullable = false)
    @NotNull(message = "Montant est obligatoire")
    private Double montant;

    @Column(length = 35)
    @NotNull(message = "Description est obligatoire")
    private String description;

    @Column(length = 55)
    @NotNull(message = "Note est obligatoire")
    private String note;

    @NotNull(message = "Echange est obligatoire")
    private Boolean echange;

    @NotNull(message = "Ouverture est obligatoire")
    private Boolean ouverture;

    @NotNull(message = "Essayage est obligatoire")
    private Boolean essayage;

    public Colis(Long idPersonne, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String description, String note, Boolean echange, Boolean ouverture, Boolean essayage) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
        this.description = description;
        this.note = note;
        this.echange = echange;
        this.ouverture = ouverture;
        this.essayage = essayage;
    }

    public Colis(Long idPersonne, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String description, String note) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
        this.description = description;
        this.note = note;
        this.echange = false;
        this.ouverture = true;
        this.essayage = true;
    }

    private String generateRandomReference(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder reference = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            reference.append(characters.charAt(random.nextInt(characters.length())));
        }

        return reference.toString();
    }


}
