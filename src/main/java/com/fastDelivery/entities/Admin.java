package com.fastDelivery.entities;

import com.fastDelivery.enumerator.Role;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
@Table(name = "t_admin")
public class Admin extends Personne {

    @NotNull(message = "Email est obligatoire")
    @Email(message = "Email excepte juste format d'email")
    private String email;

    @NotNull(message = "Password est obligatoire")
    @Size(min = 8, message = "Password excepte juste 8 caractère et plus")
    private String password;

    @NotNull(message = "Username est obligatoire")
    private String username;


    public Admin(String nom, String prenom, String ville, String adresseLocale, String numeroTelephone, String email, String password) {
        super( new Date(), nom, prenom, ville, adresseLocale, numeroTelephone, Role.ADMIN);
        this.email = email;
        this.password = password;
        this.username = nom.toLowerCase()+ "_" +prenom.toLowerCase();
    }
}
