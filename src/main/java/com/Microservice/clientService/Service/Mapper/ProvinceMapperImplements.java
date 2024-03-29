package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.ProvinceEntity;
import com.Microservice.clientService.Service.Mapper.ProvinceMapper;
import com.Microservice.clientService.model.ProvinceDTO;
import com.Microservice.clientService.model.ProvinceRequestDTO;

public class ProvinceMapperImplements implements ProvinceMapper {

    /**
     * PronvinceDTO  --> ProvinceEntity
     * */
    @Override
    public ProvinceEntity map(ProvinceDTO provinceDTO) {

        ProvinceEntity provinceEntity = ProvinceEntity.builder()
                .id(provinceDTO.getId())
                .name(provinceDTO.getName())
                .build();

        return provinceEntity;
    }

    /**
     * PronvinceRequestDTO  --> ProvinceEntity
     * */
    @Override
    public ProvinceEntity map(ProvinceRequestDTO provinceRequestDTO) {
        ProvinceEntity provinceEntity = ProvinceEntity.builder()
                .name(provinceRequestDTO.getName())
                .build();

        return provinceEntity;
    }

    /**
     * ProvinceEntity   --> PronvinceDTO
     * */
    @Override
    public ProvinceDTO map(ProvinceEntity provinceEntity) {
        ProvinceDTO provinceDTO = new ProvinceDTO()
                .id(provinceEntity.getId())
                .name(provinceEntity.getName());
        return provinceDTO;
    }
}
