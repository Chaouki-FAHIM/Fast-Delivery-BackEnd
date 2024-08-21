package com.fastDelivery.mapper;

import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.dto.response.ColisResDTO;
import com.fastDelivery.entities.Colis;
import org.springframework.stereotype.Component;

@Component("colis_mapper")
public class ColisMapper implements IMapper<Colis,ColisResDTO, ColisReqDTO>{


    @Override
    public Colis fromReqToModel(ColisReqDTO colisReqDTO) {
        return new Colis(
                colisReqDTO.getNom(),
                colisReqDTO.getPrenom(),
                colisReqDTO.getVille(),
                colisReqDTO.getAdresseLocale(),
                colisReqDTO.getNumeroTelephone(),
                colisReqDTO.getMontant(),
                colisReqDTO.getVilleRamassage(),
                colisReqDTO.getDescription(),
                colisReqDTO.getNote(),
                colisReqDTO.getEchange(),
                colisReqDTO.getOuverture(),
                colisReqDTO.getEssayage()
        );
    }

    @Override
    public ColisResDTO fromModelToRes(Colis colis) {
        return new ColisResDTO(
                colis.getIdPersonne(),
                colis.getDateCreation(),
                colis.getNom(),
                colis.getPrenom(),
                colis.getVille(),
                colis.getAdresseLocale(),
                colis.getNumeroTelephone(),
                colis.getReference(),
                colis.getMontant(),
                colis.getVilleRamassage(),
                colis.getDescription(),
                colis.getNote(),
                colis.getStatut().getFormattedString(),
                colis.getEchange(),
                colis.getOuverture(),
                colis.getEssayage()
        );
    }
}
