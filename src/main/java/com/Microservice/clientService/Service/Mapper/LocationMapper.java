package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.model.LocationDTO;
import com.Microservice.clientService.model.LocationRequestDTO;

public interface LocationMapper {
    public LocationEntity map(LocationDTO locationDTO);
    public LocationDTO map(LocationEntity locationEntity);
    public LocationEntity map(LocationRequestDTO locationRequestDTO);
}
