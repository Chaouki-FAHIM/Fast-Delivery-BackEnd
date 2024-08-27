package com.fastDelivery.entities;

<<<<<<< HEAD
import com.fastDelivery.enumerator.Role;
=======
import com.fastDelivery.model.Role;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Entity
@Table(name = "t_client")
public class Client extends Personne {

    @NotNull(message = "Email est obligatoire")
    @Email(message = "Email excepte juste format d'email")
    private String email;

    @NotNull(message = "Password est obligatoire")
    @Size(min = 8, message = "Password excepte juste 8 caractère et plus")
    private String password;

    @NotNull(message = "Username est obligatoire")
    private String username;

    @Column(nullable = false, length = 8)
    @NotNull(message = "CIN est obligatoire")
    private String CIN;

    @Column(nullable = false, length = 24)
    @NotNull(message = "RIB est obligatoire")
    private String rib;

    @Column(nullable = false, length = 15)
    @NotNull(message = "Nom de banque est obligatoire")
    private String banque;

<<<<<<< HEAD
    public Client(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String email, String password, String CIN, String rib, String banque) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.CLIENT);
        this.email = email;
        this.password = password;
        this.username = nom.toLowerCase()+ "_" +prenom.toLowerCase();
=======
    public Client(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String email, String password, String username, String CIN, String rib, String banque) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.CLIENT);
        this.email = email;
        this.password = password;
        this.username = username;
>>>>>>> cda643eaa56729a0317e3646aaca7c86d30b8179
        this.CIN = CIN;
        this.rib = rib;
        this.banque = banque;
    }
}
