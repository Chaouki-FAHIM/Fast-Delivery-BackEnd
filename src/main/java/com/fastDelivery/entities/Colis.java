package com.fastDelivery.entities;

<<<<<<< HEAD
import com.fastDelivery.enumerator.StatutColis;
import com.fastDelivery.enumerator.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.util.Calendar;
=======
import com.fastDelivery.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
import java.util.Date;
import java.util.Random;

@Entity
@Table(name="t_colis")
@Getter
@Setter
@ToString
<<<<<<< HEAD
@NoArgsConstructor
=======
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
public class Colis extends Personne {

    @Column(nullable = false, unique = true, length = 15)
    @NotNull(message = "Référence est obligatoire")
    private String reference;

    @Column(nullable = false)
    @NotNull(message = "Montant est obligatoire")
    private Double montant;

<<<<<<< HEAD
    @Column(nullable = false,length = 50)
    @NotNull(message = "Ville ramassage est obligatoire")
    private String villeRamassage;

    @Column(length = 200)
    private String description;

    @Column(length = 55)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @NotNull(message = "Statut est obligatoire")
    private StatutColis statut;

=======
    @Column(length = 35)
    @NotNull(message = "Description est obligatoire")
    private String description;

    @Column(length = 55)
    @NotNull(message = "Note est obligatoire")
    private String note;

>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
    @NotNull(message = "Echange est obligatoire")
    private Boolean echange;

    @NotNull(message = "Ouverture est obligatoire")
    private Boolean ouverture;

    @NotNull(message = "Essayage est obligatoire")
    private Boolean essayage;

<<<<<<< HEAD
    @Temporal(TemporalType.TIMESTAMP)
    protected Date dateStatutRefuse;

    @ManyToOne
    @JoinColumn(name = "ramassage_id")
    private Ramassage ramassage;

    public Colis(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String villeRamassage, String description, String note, Boolean echange, Boolean ouverture, Boolean essayage) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
        this.villeRamassage = villeRamassage;
=======
    public Colis(Long idPersonne, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String description, String note, Boolean echange, Boolean ouverture, Boolean essayage) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
        this.description = description;
        this.note = note;
        this.echange = echange;
        this.ouverture = ouverture;
        this.essayage = essayage;
<<<<<<< HEAD
        this.statut = StatutColis.EN_ATTENTE;
    }

    public Colis(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String villeRamassage, String description, String note) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
        this.villeRamassage = villeRamassage;
=======
    }

    public Colis(Long idPersonne, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Double montant, String description, String note) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.DESTINATAIRE);
        this.reference = generateRandomReference(15);
        this.montant = montant;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
        this.description = description;
        this.note = note;
        this.echange = false;
        this.ouverture = true;
        this.essayage = true;
<<<<<<< HEAD
        this.statut = StatutColis.EN_ATTENTE;
=======
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
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

<<<<<<< HEAD
    public void ChangementStatut(StatutColis statutColis) {

        if(this.statut == StatutColis.EN_ATTENTE)
            this.statut = StatutColis.RAMASSER;
        else if(this.statut == StatutColis.RAMASSER)
            this.statut = StatutColis.EN_COURS_LIVRAISON;
        else if(this.statut == StatutColis.EN_COURS_LIVRAISON) {
            this.statut = statutColis;
            if(statutColis == StatutColis.REFUSE)
                this.dateStatutRefuse = new Date();
        }
    }
=======
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179

}
