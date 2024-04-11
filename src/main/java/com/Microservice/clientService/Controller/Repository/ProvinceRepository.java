package com.Microservice.clientService.Controller.Repository;

import com.Microservice.clientService.Entity.ProvinceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends JpaRepository<ProvinceEntity,Integer> {

    public ProvinceEntity findByname(String name);
}
