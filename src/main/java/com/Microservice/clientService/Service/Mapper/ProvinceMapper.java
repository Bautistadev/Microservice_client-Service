package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.ProvinceEntity;
import com.Microservice.clientService.model.ProvinceDTO;
import com.Microservice.clientService.model.ProvinceRequestDTO;

public interface ProvinceMapper {
    public ProvinceEntity map(ProvinceDTO provinceDTO);
    public ProvinceEntity map(ProvinceRequestDTO provinceRequestDTO);
    public ProvinceDTO map(ProvinceEntity provinceEntity);

}
