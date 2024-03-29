package com.Microservice.clientService.Service.Mapper;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.ClientEntity;
import com.Microservice.clientService.model.ClientDTO;
import com.Microservice.clientService.model.ClientRequestDTO;

public class ClientMapperImplements implements ClientMapper{

    private AddressMapper addressMapper;

    public ClientMapperImplements(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }


    /**
     *  ClientDTO --> ClientEntity
     * */
    @Override
    public ClientEntity map(ClientDTO clientDTO) {
        ClientEntity client = ClientEntity.builder()
                .id(clientDTO.getId())
                .name(clientDTO.getName())
                .lastname(clientDTO.getLastname())
                .dni(clientDTO.getDni())
                .birth(clientDTO.getBirth())
                .email(clientDTO.getEmail())
                .cuil(clientDTO.getCuil())
                .telephone(clientDTO.getTelephone())
                .address(this.addressMapper.map(clientDTO.getAddress()))
                .build();
        return client;
    }

    /**
     *  ClientRequestDTO --> ClientEntity
     * */
    @Override
    public ClientEntity map(ClientRequestDTO clientDTO) {
        ClientEntity client = ClientEntity.builder()
                .name(clientDTO.getName())
                .lastname(clientDTO.getLastname())
                .dni(clientDTO.getDni())
                .email(clientDTO.getEmail())
                .birth(clientDTO.getBirth())
                .cuil(clientDTO.getCuil())
                .telephone(clientDTO.getTelephone())
                .address(AddressEntity.builder()
                        .id(clientDTO.getAddress().getId())
                        .build())
                .build();
        return client;
    }

    /**
     *  ClientEntity --> ClientDTO
     * */
    @Override
    public ClientDTO map(ClientEntity client) {
        ClientDTO clientDTO = new ClientDTO()
                .id(client.getId())
                .name(client.getName())
                .lastname(client.getLastname())
                .dni(client.getDni())
                .birth(client.getBirth())
                .cuil(client.getCuil())
                .email(client.getEmail())
                .telephone(client.getTelephone())
                .address(this.addressMapper.map(client.getAddress()));
        return clientDTO;
    }
}
