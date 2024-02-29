package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.model.LocationDTO;
import com.Microservice.clientService.model.LocationRequestDTO;

public interface LocationMapper {

    /**
     * @Param: LocationDTO
     * @Return: LocationEntity
     * */
    public LocationEntity map(LocationDTO locationDTO);

    /**
     * @Param: LocationEntity
     * @Return: LocationDTO
     * */
    public LocationDTO map(LocationEntity locationEntity);

    /**
     * @Param: LocationRequestDTO
     * @Return: LocationEntity
     * */
    public LocationEntity map(LocationRequestDTO locationRequestDTO);
}
