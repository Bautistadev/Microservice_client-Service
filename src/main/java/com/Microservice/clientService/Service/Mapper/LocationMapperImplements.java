package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.Entity.ProvinceEntity;
import com.Microservice.clientService.model.LocationDTO;
import com.Microservice.clientService.model.LocationRequestDTO;
import com.Microservice.clientService.model.ProvinceDTO;

public class LocationMapperImplements implements LocationMapper {
    @Override
    public LocationEntity map(LocationDTO locationDTO) {
        LocationEntity locationEntity = LocationEntity.builder()
                .id(locationDTO.getId())
                .name(locationDTO.getName())
                .postalCode(locationDTO.getPostalCode())
                .provinceEntity(ProvinceEntity.builder()
                        .id(locationDTO.getProvince().getId())
                        .name(locationDTO.getProvince().getName())
                        .build())
                .build();
        return locationEntity;
    }

    @Override
    public LocationDTO map(LocationEntity locationEntity) {

        LocationDTO locationDTO = new LocationDTO()
                .id(locationEntity.getId())
                .name(locationEntity.getName())
                .postalCode(locationEntity.getPostalCode())
                .province(new ProvinceDTO()
                        .id(locationEntity.getProvinceEntity().getId())
                        .name(locationEntity.getProvinceEntity().getName()
                        ));

        return locationDTO;
    }

    @Override
    public LocationEntity map(LocationRequestDTO locationDTO) {
        LocationEntity locationEntity = LocationEntity.builder()
                .name(locationDTO.getName())
                .postalCode(locationDTO.getPostalCode())
                .provinceEntity(ProvinceEntity.builder()
                        .id(locationDTO.getProvince().getId())
                        .build())
                .build();
        return locationEntity;
    }
}
