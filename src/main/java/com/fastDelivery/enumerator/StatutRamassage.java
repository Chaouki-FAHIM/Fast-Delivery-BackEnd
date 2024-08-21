package com.fastDelivery.enumerator;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum StatutRamassage {

    EN_ATTENTE("En attente"),
    RAMASSER("Ramasser"),
    ENTREPOT("Entrepôt");

    private final String nomStatut;

    public String getFormattedString() {
        return nomStatut;
    }

    @JsonCreator
    public static StatutRamassage fromString(String nomStatut) {
        for (StatutRamassage s : StatutRamassage.values()) {
            if (s.getFormattedString().equals(nomStatut)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Statut de ramassage est inavlide : " + nomStatut);
    }
}
