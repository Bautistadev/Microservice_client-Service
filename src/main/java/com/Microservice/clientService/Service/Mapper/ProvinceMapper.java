package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.ProvinceEntity;
import com.Microservice.clientService.model.ProvinceDTO;
import com.Microservice.clientService.model.ProvinceRequestDTO;

public interface ProvinceMapper {

    /**
     * @Param: ProvinceDTO
     * @Return: ProvinceEntity
     * */
    public ProvinceEntity map(ProvinceDTO provinceDTO);

    /**
     * @Param: ProvinceEntity
     * @Return: ProvinceRequestDTO
     * */
    public ProvinceEntity map(ProvinceRequestDTO provinceRequestDTO);

    /**
     * @Param: ProvinceEntity
     * @Return: ProvinceDTO
     * */
    public ProvinceDTO map(ProvinceEntity provinceEntity);

}
