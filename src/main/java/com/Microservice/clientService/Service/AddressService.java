package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Repository.AddressRepository;
import com.Microservice.clientService.Service.Mapper.AddressMapper;
import com.Microservice.clientService.model.AddressDTO;
import com.Microservice.clientService.model.AddressRequestDTO;
import com.Microservice.clientService.model.LocationDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService {

    private AddressRepository addressRepository;
    private AddressMapper addressMapper;
    private LocationService locationService;

    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper,LocationService locationService) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
        this.locationService = locationService;
    }

    /**
     * @Operation: SAVE
     * @Param:  AddressRequestDTO
     * @Return: AddressDTO
     * */
    public AddressDTO save(AddressRequestDTO addressRequestDTO){
        /**
         * EXISTE LA DIRECCION
        * */
        AddressEntity address = this.addressRepository.findByAttribute(
                addressRequestDTO.getName(),
                addressRequestDTO.getNumber(),
                addressRequestDTO.getLocation().getId());

        /**
         * SINO EXISTE
         * */
        if(address == null){
            /**
             * EXISTE LA LOCALIDAD
             * */
            if(addressRequestDTO.getLocation().getId() == null){
                /**
                 * DAMOS DE ALTA LA LOCALIDAD
                 * */
                LocationDTO locationDTO = this.locationService.save(addressRequestDTO.getLocation());
                addressRequestDTO.setLocation(locationDTO);
            }

            address = this.addressRepository.save(this.addressMapper.map(addressRequestDTO));
        }

        return this.addressMapper.map(address);
    }

    /**
     * @Operation: SAVE
     * @Param:  AddressDTO
     * @Return: AddressDTO
     * */
    public AddressDTO save(AddressDTO addressRequestDTO){
        AddressEntity address = this.addressRepository.findByAttribute(
                addressRequestDTO.getName(),
                addressRequestDTO.getNumber(),
                addressRequestDTO.getLocation().getId());

        /**
         * SINO EXISTE
         * */
       if(address == null){
            /**
             * EXISTE LA LOCALIDAD
             * */
           if(addressRequestDTO.getLocation().getId() == null){
                /**
                 * DAMOS DE ALTA LA LOCALIDAD
                 * */
                LocationDTO locationDTO = this.locationService.save(addressRequestDTO.getLocation());
                addressRequestDTO.setLocation(locationDTO);
           }

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
