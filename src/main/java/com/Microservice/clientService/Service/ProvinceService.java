package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.ProvinceEntity;
import com.Microservice.clientService.Controller.Repository.ProvinceRepository;
import com.Microservice.clientService.Service.Mapper.ProvinceMapper;
import com.Microservice.clientService.model.ProvinceDTO;
import com.Microservice.clientService.model.ProvinceRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProvinceService {

    private ProvinceRepository provinceRepository;
    private ProvinceMapper provinceMapper;

    public ProvinceService(ProvinceRepository provinceRepository,ProvinceMapper provinceMapper) {
        this.provinceRepository = provinceRepository;
        this.provinceMapper = provinceMapper;
    }

    /**
     * @Param: ProvinceRequestDTO
     * @Return: ProvinceDTO
     * */

    public ProvinceDTO save(ProvinceRequestDTO provinceRequestDTO){
        ProvinceEntity provinceDB = this.provinceRepository.findByname(provinceRequestDTO.getName());

        if( provinceDB ==null) {
            ProvinceEntity provinceSave = this.provinceMapper.map(provinceRequestDTO);
            provinceDB = this.provinceRepository.save(provinceSave);
        }

        return this.provinceMapper.map(provinceDB);
    }
    public ProvinceDTO save(ProvinceDTO provinceRequestDTO){
        ProvinceEntity provinceDB = this.provinceRepository.findByname(provinceRequestDTO.getName());

        if( provinceDB ==null) {
            ProvinceEntity provinceSave = this.provinceMapper.map(provinceRequestDTO);
            provinceDB = this.provinceRepository.save(provinceSave);
        }

        return this.provinceMapper.map(provinceDB);
    }

    /**
     * @Operation: FIND BY ID
     * @Param: Integer
     * @Return: ProvinceDTO
     * */
    public ProvinceDTO findById(Integer id){
        return this.provinceMapper.map(this.provinceRepository.findById(id).get());
    }

    /**
     * @Operation: FIND BY NAME
     * @Param: String
     * @Return: ProvinceDTO
     * */
    public ProvinceDTO findByName(String name){
        ProvinceEntity provinceDB = this.provinceRepository.findByname(name);
        if(provinceDB == null)
            return null;

        return this.provinceMapper.map(provinceDB);
    }

    /**
     * @Operation: EXIST
     * @Param: ProvinceDTO
     * @Return: true or false
     * */
    public Boolean exist(ProvinceDTO provinceDTO){
        return this.provinceRepository.existsById(provinceDTO.getId());
    }

    /**
     * @Operation: FIND ALL
     * @Return: LIST OF ProvinceDTO
     * */
    public List<ProvinceDTO> findAll(){
        List<ProvinceDTO> response = this.provinceRepository.findAll().stream().map( e ->{
            return this.provinceMapper.map(e);
        }).collect(Collectors.toList());

        return response;
    }

}
