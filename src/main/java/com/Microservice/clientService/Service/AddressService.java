package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.Repository.AddressRepository;
import com.Microservice.clientService.Service.Mapper.AddressMapper;
import com.Microservice.clientService.model.AddressDTO;
import com.Microservice.clientService.model.AddressRequestDTO;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    /**
     * @Operation: SAVE
     * @Param:  AddressRequestDTO
     * @Return: AddressDTO
     * */
    public AddressDTO save(AddressRequestDTO addressRequestDTO){
        AddressEntity address = this.addressRepository.findByAttribute(
                addressRequestDTO.getName(),
                addressRequestDTO.getNumber(),
                addressRequestDTO.getLocation().getId());

       if(address == null){
          address = this.addressRepository.save(this.addressMapper.map(addressRequestDTO));
       }

        return this.addressMapper.map(address);
    }

    public AddressDTO save(AddressDTO addressRequestDTO){
        AddressEntity address = this.addressRepository.findByAttribute(
                addressRequestDTO.getName(),
                addressRequestDTO.getNumber(),
                addressRequestDTO.getLocation().getId());

        if(address == null){
            address = this.addressRepository.save(this.addressMapper.map(addressRequestDTO));
        }

        return this.addressMapper.map(address);
    }
    /**
     * @Operation: FIND BY ID
     * @Param: Integer
     * @Return: AddressDTO
     * */
    public AddressDTO findById(Integer id){
        return this.addressMapper.map(this.addressRepository.findById(id).get());
    }

    /**
     * @Operation: FIND ALL
     * @Return: LIST OF AddressDTO
     * */
    public List<AddressDTO> findAll(){
        List<AddressDTO> response = this.addressRepository.findAll().stream().map(e->{
            return this.addressMapper.map(e);
        }).collect(Collectors.toList());
        return response;
    }

    /**
     * @Operation: EXIST
     * @Param: AddressDTO
     * @Return: true or false
     * */
    public Boolean exist(AddressDTO addressDTO){
        return this.addressRepository.existsById(addressDTO.getId());
    }

}
