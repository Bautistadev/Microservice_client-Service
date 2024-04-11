package com.Microservice.clientService.Configuration;

import com.Microservice.clientService.Controller.Repository.AddressRepository;
import com.Microservice.clientService.Controller.Repository.ClientRepository;
import com.Microservice.clientService.Controller.Repository.LocationRepository;
import com.Microservice.clientService.Controller.Repository.ProvinceRepository;
import com.Microservice.clientService.Service.*;
import com.Microservice.clientService.Service.Mapper.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfigure {

    /**
     * MAPPER
     * */

    @Bean
    public AddressMapper addressMapper(){
        return new AddressMapperImplements();
    }
    @Bean
    public LocationMapper locationMapper(){
        return new LocationMapperImplements();
    }
    @Bean
    public ProvinceMapper provinceMapper(){
        return new ProvinceMapperImplements();
    }
    @Bean
    public ClientMapper clientMapper(AddressMapper addressMapper){
        return new ClientMapperImplements(addressMapper);
    }

    /**
     * SERVICE
     * */

    @Bean
    public ProvinceService provinceService(ProvinceRepository provinceRepository,ProvinceMapper provinceMapper){
        return new ProvinceService(provinceRepository,provinceMapper);
    }

    @Bean
    public LocationService locationService(LocationRepository locationRepository, LocationMapper locationMapper){
        return new LocationService(locationRepository,locationMapper);
    }

    @Bean
    public AddressService addressService(AddressRepository addressRepository, AddressMapper addressMapper){
        return new AddressService(addressRepository,addressMapper);
    }

    @Bean
    public ClientService clientService(ClientRepository clientRepository, ClientMapper clientMapper){
        return new ClientService(clientRepository,clientMapper);
    }


}
