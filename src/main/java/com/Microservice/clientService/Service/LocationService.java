package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.Controller.Repository.LocationRepository;
import com.Microservice.clientService.Service.Mapper.LocationMapper;
import com.Microservice.clientService.model.LocationDTO;
import com.Microservice.clientService.model.LocationRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationService {

    private LocationRepository locationRepository;
    private LocationMapper locationMapper;

    public LocationService(LocationRepository locationRepository, LocationMapper locationMapper) {
        this.locationRepository = locationRepository;
        this.locationMapper = locationMapper;
    }


    /**
     * @Operation: SAVE
     * @Param:  LocationRequestDTO
     * @Return: LocationDTO
     * */
    public LocationDTO save(LocationRequestDTO locationRequestDTO){
        LocationEntity locationDB = this.locationRepository.findByidProvince(
                locationRequestDTO.getProvince().getId(),locationRequestDTO.getName());
        if(locationDB == null){
            locationDB = this.locationRepository.save(this.locationMapper.map(locationRequestDTO));
        }

        return this.locationMapper.map(locationDB);
    }
    public LocationDTO save(LocationDTO locationRequestDTO){
        LocationEntity locationDB = this.locationRepository.findByidProvince(
                locationRequestDTO.getProvince().getId(),locationRequestDTO.getName());
        if(locationDB == null){
            locationDB = this.locationRepository.save(this.locationMapper.map(locationRequestDTO));
        }

        return this.locationMapper.map(locationDB);
    }
    /**
     * @Operation: FIND BY NAME
     * @Param: String
     * @Return: LocationDTO
     * */
    public List<LocationDTO> findByName(String name){
        return this.locationRepository.findByname(name).stream().map(e ->{
            return this.locationMapper.map(e);
        }).collect(Collectors.toList());
    }

    /**
     * @Operation: FIND BY ID
     * @Param: Integer
     * @Return: LocationDTO
     * */
    public LocationDTO findById(Integer id){
        LocationEntity location = this.locationRepository.findById(id).get();
        return this.locationMapper.map(location);
    }

    /**
     * @Operation: FIND ALL
     * @Return: LIST OF LocationDTO
     * */
    public List<LocationDTO> findAll(){
        List<LocationDTO> response = this.locationRepository.findAll().stream().map(e ->{
            return this.locationMapper.map(e);
        }).collect(Collectors.toList());
        return  response;
    }
}
