package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.ClientEntity;
import com.Microservice.clientService.Repository.ClientRepository;
import com.Microservice.clientService.Service.Mapper.ClientMapper;
import com.Microservice.clientService.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    @Autowired
    private AddressService addressService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private ProvinceService provinceService;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    /**
     * @Operation: save client
     * @Param: ClientRequestDTO
     * @Return: ClientDTO
     * */
    public ClientDTO save(ClientRequestDTO clientRequestDTO) {

        /**
         * SI EL ID ES NULO, DEBE DARSE DE ALTA LA DIRECCION
         * */
        if(clientRequestDTO.getAddress().getId() == null) {
            /**
             * PERSISTIMOS LA DIRECCION
             * */
            AddressDTO address = this.addressService.save(clientRequestDTO.getAddress());
            clientRequestDTO.setAddress(address);
            /**
             * PERSISTIMOS EL CLIENTE CON LA DIRECCIONDADA DE ALTA
             * */
            ClientEntity response = this.clientRepository.save(this.clientMapper.map(clientRequestDTO));
            return this.clientMapper.map(response);
        }

        /**
         * SI LA DIRECCION SE ENCUENTRA REGISTRADA, SOLO GUARDAMOS AL CLIENTE
         * */
        ClientEntity response = this.clientRepository.save(this.clientMapper.map(clientRequestDTO));

        return this.clientMapper.map(response);
    }

    /**
     * @Operation: UPDATE
     * @Param: ClientDTO
     * @Return: ClientDTO
     * */
    public ClientDTO update(ClientDTO clientDTO){
        if(clientDTO.getAddress().getId() == null) {
            AddressDTO address = this.addressService.save(clientDTO.getAddress());
            clientDTO.setAddress(address);
            ClientEntity response = this.clientRepository.save(this.clientMapper.map(clientDTO));
            return this.clientMapper.map(response);
        }

        ClientEntity response = this.clientRepository.save(this.clientMapper.map(clientDTO));

        return this.clientMapper.map(response);
    }

    /**
     * @Operation: Retrieve all clients
     * @Param: -
     * @Return: ClientDTO List
     * */
    public List<ClientDTO> findAll(){
        List<ClientDTO> response = this.clientRepository.findAll().stream().map(e ->{
            return this.clientMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

    /**
     * @Operation: retrieve client by id
     * @Param: Integer
     * @Return: ClientDTO
     * */
    public ClientDTO findById(Integer id){
        ClientEntity clientDB = this.clientRepository.findById(id).get();
        return this.clientMapper.map(clientDB);
    }

    /**
     * @Operation: retrieve client by dni
     * @Param: Integer
     * @Return: ClientDTO
     * */
    public ClientDTO findByDni(Integer dni){
        ClientEntity clientDB = this.clientRepository.findBydni(dni);
        return this.clientMapper.map(clientDB);
    }

}
