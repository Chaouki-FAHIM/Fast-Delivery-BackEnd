package com.fastDelivery.entities;


<<<<<<< HEAD
import com.fastDelivery.enumerator.Role;
=======
import com.fastDelivery.model.Role;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import lombok.*;

import java.util.Date;

<<<<<<< HEAD
=======
@AllArgsConstructor
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "t_personne")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Personne {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long idPersonne;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @PastOrPresent(message = "Date de création excepte juste le présent et le passer")
    protected Date dateCreation;

    @Column(nullable = false, length = 25)
    @NotNull(message = "Nom est obligatoire")
    protected String nom;

    @Column(nullable = false, length = 25)
    @NotNull(message = "Prenom est obligatoire")
    protected String prenom;

    @Column(nullable = false, length = 40)
    @NotNull(message = "Ville est obligatoire")
    protected String ville;

    @Column(nullable = false, length = 40)
    @NotNull(message = "Adresse locale est obligatoire")
    protected String adresseLocale;

    @Column(nullable = false, length = 15)
    @NotNull(message = "Numero de téléphone est obligatoire")
    protected String numeroTelephone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    @NotNull(message = "Role est obligatoire")
    protected Role role;

    public Personne(Date dateCreation, String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, Role role) {
        this.dateCreation = dateCreation;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.adresseLocale = adresseLocale;
        this.numeroTelephone = numeroTelephone;
        this.role = role;
    }
}
