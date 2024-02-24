package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.model.AddressDTO;
import com.Microservice.clientService.model.AddressRequestDTO;

public interface AddressMapper {
    public AddressDTO map(AddressEntity address);
    public AddressEntity map(AddressDTO addressDTO);
    public AddressEntity map(AddressRequestDTO addressRequestDTO);
}
