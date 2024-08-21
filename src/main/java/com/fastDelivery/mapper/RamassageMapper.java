package com.fastDelivery.mapper;

import com.fastDelivery.dto.request.RamassageReqDTO;
import com.fastDelivery.dto.response.RamassageResDTO;
import com.fastDelivery.entities.Ramassage;
import org.springframework.stereotype.Component;

@Component("ramassage_mapper")
public class RamassageMapper implements IMapper<Ramassage, RamassageResDTO, RamassageReqDTO> {


    @Override
    public Ramassage fromReqToModel(RamassageReqDTO ramassageReqDTO) {
        return new Ramassage(
                ramassageReqDTO.getNom(),
                ramassageReqDTO.getPrenom(),
                ramassageReqDTO.getVille(),
                ramassageReqDTO.getAdresseLocale(),
                ramassageReqDTO.getNumeroTelephone(),
                ramassageReqDTO.getNote()
        );
    }

    @Override
    public RamassageResDTO fromModelToRes(Ramassage ramassage) {
        return new RamassageResDTO(
                ramassage.getIdPersonne(),
                ramassage.getDateCreation(),
                ramassage.getNom(),
                ramassage.getPrenom(),
                ramassage.getVille(),
                ramassage.getAdresseLocale(),
                ramassage.getNumeroTelephone(),
                ramassage.getReference(),
                ramassage.getNote(),
                ramassage.getStatut().getFormattedString(),
                null
        );
    }
}
