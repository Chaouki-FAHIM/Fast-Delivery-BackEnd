package com.fastDelivery.service;

import com.fastDelivery.dto.request.ClientReqDTO;
import com.fastDelivery.dto.response.ClientResDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("client_service")
@Slf4j
@RequiredArgsConstructor
public class ClientServiceImpl implements IService<ClientReqDTO, ClientResDTO,Long>{

    @Override
    public ClientResDTO create(ClientReqDTO clientReqDTO) {
        return null;
    }

    @Override
    public ClientResDTO getById(Long id) {
        return null;
    }

    @Override
    public List<ClientResDTO> getAll() {
        return List.of();
    }

    @Override
    public ClientResDTO update(ClientReqDTO clientReqDTO, Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
