package com.fastDelivery.service;

import com.fastDelivery.dto.request.ColisReqDTO;
import com.fastDelivery.dto.response.ColisResDTO;
import com.fastDelivery.entities.Colis;
import com.fastDelivery.enumerator.StatutColis;
import com.fastDelivery.exception.*;
import com.fastDelivery.mapper.ColisMapper;
import com.fastDelivery.model.MetaData;
import com.fastDelivery.repo.ColisRepository;
import com.fastDelivery.validation.ColisValidation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("colis_service")
@RequiredArgsConstructor
@Slf4j
public class ColisService implements IColisService {

    @Autowired
    @Qualifier("colis_repo")
    private final ColisRepository colisRepository;

    @Autowired
    @Qualifier("colis_mapper")
    private final ColisMapper colisMapper;

    @Autowired
    @Qualifier("colis_validation")
    private final ColisValidation colisValidation;

    private Colis recieveColis(long id) throws NotFoundIDException {

        Colis colis = colisRepository.findById(id).orElse(null);

        if(colis == null) {
            log.error("Le colis avec l'id {} est introuvable",id);
            throw new NotFoundIDException("Le colis", id);
        }
        return colis;
    }


    @Override
    public ColisResDTO create(ColisReqDTO colisReqDTO) throws NullRequestDataException, BadMontantException {

        colisValidation.toCreate(colisReqDTO);

        Colis colis = colisMapper.fromReqToModel(colisReqDTO);

         colisRepository.save(colis);

        return colisMapper.fromModelToRes(colis);
    }

    @Override
    public ColisResDTO getById(Long id) throws NotFoundIDException {
        log.info("Start : Get Colis by id "+id);
        Colis colis = recieveColis(id);

        log.info("End : Get Colis by id "+id);
        return colisMapper.fromModelToRes(colis);
    }

    @Override
    public Map<String, Object> getAll(int pageNumber, int limitColis) {

        log.info("Start  : Get all Colis ");
        Pageable pageable = PageRequest.of(pageNumber - 1, limitColis);

        Page<Colis> colis = colisRepository.findAll(pageable);

        MetaData metaData = MetaData.builder()
                .totalCount((int) colis.getTotalElements())
                .page(pageNumber)
                .perPage(limitColis)
                .build();

        Map<String, Object> response = new HashMap<>();
        response.put("metadata", metaData);

        List<ColisResDTO> colisResDTOList = colis.stream().map(colisMapper::fromModelToRes).toList();

        if(colisResDTOList.isEmpty()) response.put("data",null);
        else response.put("data",colisResDTOList);

        log.info("End : Get all Colis ");
        return response;
    }

    @Override
    public ColisResDTO update(ColisReqDTO colisReqDTO, Long id) throws NullRequestDataException, BadMontantException, NotFoundIDException, NonAutoriserException {

        Colis colis = recieveColis(id);

        if(colis.getStatut() != StatutColis.EN_ATTENTE) {
            log.error("Le colis en statut est non en attente, alors l'opération de mise à jour non autorisé");
            throw new NonAutoriserException();
        }

        colisValidation.toUpdate(colisReqDTO,id);

        colis.setNom(colisReqDTO.getNom());
        colis.setPrenom(colisReqDTO.getPrenom());
        colis.setVille(colisReqDTO.getVille());
        colis.setAdresseLocale(colisReqDTO.getAdresseLocale());
        colis.setNumeroTelephone(colisReqDTO.getNumeroTelephone());
        colis.setMontant(colisReqDTO.getMontant());
        colis.setVilleRamassage(colisReqDTO.getVilleRamassage());
        colis.setDescription(colisReqDTO.getDescription());
        colis.setNote(colisReqDTO.getNote());
        colis.setEchange(colisReqDTO.getEchange());
        colis.setOuverture(colisReqDTO.getOuverture());
        colis.setEssayage(colisReqDTO.getEssayage());

        colisRepository.save(colis);

        return colisMapper.fromModelToRes(colis);
    }

    @Override
    public void delete(Long id) throws NotFoundIDException {

        log.info("Start : Delete Colis by id "+id);

        colisRepository.delete(recieveColis(id));

        log.info("End : Delete Colis by id "+id);
    }

    @Override
    public String changementStatut(String statut, Long id) throws NotFoundIDException {

        log.info("Start : Change status of Colis by id "+id);

        Colis colis = recieveColis(id);

        colis.ChangementStatut(StatutColis.fromString(statut));

        colisRepository.save(colis);

        log.info("End : Change status of Colis by id "+id);

        return colis.getStatut().getFormattedString();
    }

    @Override
    public Map<String, Object> GetAllColisEnAttente(int pageNumber, int limitColis) {
        log.info("Start  : Get all Colis at waiting");
        Pageable pageable = PageRequest.of(pageNumber - 1, limitColis);

        Page<Colis> colis = colisRepository.findByStatut(StatutColis.EN_ATTENTE,pageable);

        MetaData metaData = MetaData.builder()
                .totalCount((int) colis.getTotalElements())
                .page(pageNumber)
                .perPage(limitColis)
                .build();

        Map<String, Object> response = new HashMap<>();
        response.put("metadata", metaData);

        List<ColisResDTO> colisResDTOList = colis.stream().map(colisMapper::fromModelToRes).toList();

        if(colisResDTOList.isEmpty()) response.put("data",null);
        else response.put("data",colisResDTOList);

        log.info("End : Get all Colis at waiting");
        return response;
    }

    @Scheduled(cron = "0 0 * * * *")
    @Transactional
    public void updateColisStatus() {
        List<Colis> colisList = colisRepository.findAllByStatutAndDateStatutRefuseBefore(StatutColis.REFUSE, new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000));

        for (Colis colis : colisList) {
            colis.setStatut(StatutColis.ANNULE);
            colisRepository.save(colis);
        }
    }

}
