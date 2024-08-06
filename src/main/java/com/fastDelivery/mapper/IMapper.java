package com.fastDelivery.mapper;

public interface IMapper <Model,ResDTO,ReqDTO> {

    Model fromReqToModel(ReqDTO reqDTO) ;
    ResDTO froModelToRes(Model model) ;
}
