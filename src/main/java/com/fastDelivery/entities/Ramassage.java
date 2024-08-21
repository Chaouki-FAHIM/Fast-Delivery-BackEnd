package com.fastDelivery.entities;

import com.fastDelivery.enumerator.Role;
import com.fastDelivery.enumerator.StatutRamassage;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "t_ramassage")
public class Ramassage extends Personne {

    @Column(nullable = false, unique = true, length = 15)
    @NotNull(message = "Référence est obligatoire")
    private String reference;

    @Column(length = 55)
    private String note;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    @NotNull(message = "Statut est obligatoire")
    private StatutRamassage statut;

    @OneToMany(mappedBy = "ramassage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Colis> colisList = new ArrayList<>();

    public Ramassage(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String note, List<Colis> colisList) {
        super(new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.RAMASSEUR);
        this.reference = generateRandomReference(10);
        this.note = note;
        this.statut = StatutRamassage.EN_ATTENTE;
        this.colisList = colisList;
    }

    public Ramassage(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String note) {
        super(new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.RAMASSEUR);
        this.reference = generateRandomReference(10);
        this.note = note;
        this.statut = StatutRamassage.EN_ATTENTE;
    }

    public void addColis(Colis colis) {
        colisList.add(colis);
        colis.setRamassage(this);
    }

    public void removeColis(Colis colis) {
        colisList.remove(colis);
        colis.setRamassage(null);
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

    public void ChangementStatut() {

        if(this.statut == StatutRamassage.EN_ATTENTE)
            this.statut = StatutRamassage.RAMASSER;
        else if(this.statut == StatutRamassage.RAMASSER)
            this.statut = StatutRamassage.ENTREPOT;

    }
}
