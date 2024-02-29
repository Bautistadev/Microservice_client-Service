package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.model.AddressDTO;
import com.Microservice.clientService.model.AddressRequestDTO;

public interface AddressMapper {

    /**
     * @Param: AddressEntity
     * @Return AddressDTO
     * */
    public AddressDTO map(AddressEntity address);

    /**
     * @Param: AddressDTO
     * @Return: AddressEntity
     * */
    public AddressEntity map(AddressDTO addressDTO);

    /**
     * @Param: AddressRequestDTO
     * @Return: AddressEntity
     * */
    public AddressEntity map(AddressRequestDTO addressRequestDTO);
}
