package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.model.AddressDTO;
import com.Microservice.clientService.model.AddressRequestDTO;
import com.Microservice.clientService.model.LocationDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class AddressMapperImplements implements AddressMapper{

    @Autowired
    private LocationMapper locationMapper;

    /**
     *  AddressEntity --> AddressDTO
     * */
    @Override
    public AddressDTO map(AddressEntity address) {
        AddressDTO addressDTO = new AddressDTO()
                .id(address.getId())
                .name(address.getName())
                .number(address.getNumber())
                .location(locationMapper.map(address.getLocation()));

        return addressDTO;
    }


    /**
     *  AddressDTO --> AddressEntity
     * */
    @Override
    public AddressEntity map(AddressDTO addressDTO) {
        AddressEntity address = AddressEntity.builder()
                .id(addressDTO.getId())
                .name(addressDTO.getName())
                .number(addressDTO.getNumber())
                .location(this.locationMapper.map(addressDTO.getLocation()))
                .build();
        return address;
    }

    /**
     *  AddressRequestDTO --> AddressEntity
     * */
    @Override
    public AddressEntity map(AddressRequestDTO addressDTO) {
        AddressEntity address = AddressEntity.builder()
                .name(addressDTO.getName())
                .number(addressDTO.getNumber())
                .location(LocationEntity.builder()
                        .id(addressDTO.getLocation().getId())
                        .build())
                .build();
        return address;
    }
}
