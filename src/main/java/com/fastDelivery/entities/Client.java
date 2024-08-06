package com.fastDelivery.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Setter
@Getter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idClient;

    @NotNull(message = "Email est obligatoire")
    @Email(message = "Email excepte juste format d'email")
    private String email;

    @NotNull(message = "Password est obligatoire")
    @Size(min = 8, message = "Password excepte juste 8 caractère et plus")
    private String password;

    @NotNull(message = "Username est obligatoire")
    private String username;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    @PastOrPresent(message = "Date de création excepte juste le présent et le passer")
    private Date dateCreation;

    @Column(nullable = false, length = 25)
    @NotNull(message = "Nom est obligatoire")
    private String nom;

    @Column(nullable = false, length = 25)
    @NotNull(message = "Prenom est obligatoire")
    private String prenom;

    @Column(nullable = false, unique = true, length = 40)
    @NotNull(message = "Ville est obligatoire")
    private String ville;

    @Column(nullable = false, length = 15)
    @NotNull(message = "Numero de téléphone est obligatoire")
    private String numeroTelephone;

    @Column(nullable = false, length = 8)
    @NotNull(message = "CIN est obligatoire")
    private String CIN;

    @Column(nullable = false, length = 24)
    @NotNull(message = "RIB est obligatoire")
    private String rib;

    @Column(nullable = false, length = 15)
    @NotNull(message = "Nom de banque est obligatoire")
    private String banque;
}
