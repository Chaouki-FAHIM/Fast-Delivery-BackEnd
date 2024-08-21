package com.fastDelivery.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatutColis {

    EN_ATTENTE("En attente"),
    RAMASSER("Ramasser"),
    EN_COURS_LIVRAISON("En cours de livraison"),
    LIVRE("Livré"),
    REFUSE("Refusé"),
    ANNULE("Annulé");

    private final String nomStatut;

    public String getFormattedString() {
        return nomStatut;
    }

    @JsonCreator
    public static StatutColis fromString(String nomStatut) {
        for (StatutColis s : StatutColis.values()) {
            if (s.getFormattedString().equals(nomStatut)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Statut de colis est inavlide : " + nomStatut);
    }
}
