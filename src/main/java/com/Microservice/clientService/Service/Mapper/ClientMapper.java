package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.ClientEntity;
import com.Microservice.clientService.model.ClientDTO;
import com.Microservice.clientService.model.ClientRequestDTO;

public interface ClientMapper {
    public ClientEntity map(ClientDTO clientDTO);
    public ClientEntity map(ClientRequestDTO clientRequestDTO);
    public ClientDTO map(ClientEntity client);
}
