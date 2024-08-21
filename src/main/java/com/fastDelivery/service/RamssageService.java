package com.fastDelivery.service;

import com.fastDelivery.dto.request.RamassageReqDTO;
import com.fastDelivery.dto.response.ColisResDTO;
import com.fastDelivery.dto.response.RamassageResDTO;
import com.fastDelivery.entities.Colis;
import com.fastDelivery.entities.Ramassage;
import com.fastDelivery.enumerator.StatutColis;
import com.fastDelivery.exception.*;
import com.fastDelivery.mapper.IMapper;
import com.fastDelivery.model.MetaData;
import com.fastDelivery.repo.ColisRepository;
import com.fastDelivery.repo.RamassageRepository;
import com.fastDelivery.validation.IValidation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service("ramassage_service")
@RequiredArgsConstructor
@Slf4j
public class RamssageService implements IRamassageService {

    @Autowired
    @Qualifier("ramassage_repo")
    private final RamassageRepository ramassageRepository;

    @Autowired
    @Qualifier("ramassage_mapper")
    private final IMapper<Ramassage, RamassageResDTO, RamassageReqDTO> ramassageMapper;

    @Autowired
    @Qualifier("ramassage_validation")
    private final IValidation<RamassageReqDTO,Long> ramassageValidation;

    @Autowired
    @Qualifier("colis_repo")
    private final ColisRepository colisRepository;


    private Ramassage recieveRamassage(Long id) throws NotFoundIDException {
        Ramassage ramassage = ramassageRepository.findById(id).orElse(null);

        if(ramassage == null) {
            log.error("Le ramassage avec l'id {} est introuvable",id);
            throw new NotFoundIDException("Le ramassage", id);
        }
        return ramassage;
    }


    @Override
    public String changementStatut(Long id) throws NotFoundIDException {
        log.info("Start : Change status of Ramassage by id "+id);

        Ramassage ramassage = recieveRamassage(id);

        ramassage.ChangementStatut();

        ramassageRepository.save(ramassage);

        log.info("End : Change status of Ramassage by id "+id);

        return ramassage.getStatut().getFormattedString();
    }

    @Override
    public RamassageResDTO create(RamassageReqDTO ramassageReqDTO) throws NullRequestDataException, BadMontantException, BadPasswordException, RededicationUserException, BadCinException, NotEmailException, NotFoundIDException {

        ramassageValidation.toCreate(ramassageReqDTO);

        Ramassage ramassage = ramassageMapper.fromReqToModel(ramassageReqDTO);

        List<Optional<Colis>> colisList = ramassageReqDTO.getListIdColis().stream()
                .map(colisRepository::findById)
                .toList();

        colisList.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(ramassage::addColis);

        ramassageRepository.save(ramassage);

        RamassageResDTO ramassageResDTO = ramassageMapper.fromModelToRes(ramassage);
        ramassageResDTO.setListIdColis(ramassageReqDTO.getListIdColis());

        return ramassageResDTO;
    }

    @Override
    public RamassageResDTO getById(Long id) throws NotFoundIDException {
        log.info("Start : Get Ramassage by id "+id);
        Ramassage ramassage = recieveRamassage(id);

        log.info("End : Get Colis by id "+id);
        return ramassageMapper.fromModelToRes(ramassage);
    }

    @Override
    public Map<String, Object> getAll(int pageNumber, int limitRamassage) {
        log.info("Start  : Get all Ramassages ");
        Pageable pageable = PageRequest.of(pageNumber - 1, limitRamassage);

        Page<Ramassage> ramassages = ramassageRepository.findAll(pageable);

        MetaData metaData = MetaData.builder()
                .totalCount((int) ramassages.getTotalElements())
                .page(pageNumber)
                .perPage(limitRamassage)
                .build();

        Map<String, Object> response = new HashMap<>();
        response.put("metadata", metaData);

        List<RamassageResDTO> ramassageResDTOList = ramassages.stream().map(ramassageMapper::fromModelToRes).toList();

        if(ramassageResDTOList.isEmpty()) response.put("data",null);
        else response.put("data",ramassageResDTOList);

        log.info("End : Get all Ramassages ");
        return response;
    }

    @Override
    public RamassageResDTO update(RamassageReqDTO ramassageReqDTO, Long id) throws NullRequestDataException, BadPasswordException, NotEmailException, NotFoundIDException, BadCinException, RededicationUserException, BadMontantException {
        return null;
    }

    @Override
    public void delete(Long id) throws NotFoundIDException {
        log.info("Start : Delete Ramassage by id "+id);

        ramassageRepository.delete(recieveRamassage(id));

        log.info("End : Delete Ramassage by id "+id);
    }
}
