package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.ClientEntity;
import com.Microservice.clientService.model.ClientDTO;
import com.Microservice.clientService.model.ClientRequestDTO;

public interface ClientMapper {

    /**
     * @Param: ClientDTO
     * @Return: ClientEntity
     * */
    public ClientEntity map(ClientDTO clientDTO);

    /**
     * @Param: ClientRequestDTO
     * @Return: ClientEntity
     * */
    public ClientEntity map(ClientRequestDTO clientRequestDTO);

    /**
     * @Param: ClientEntity
     * @Return: ClientDTO
     * */
    public ClientDTO map(ClientEntity client);
}
