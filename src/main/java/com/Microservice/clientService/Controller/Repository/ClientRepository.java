package com.Microservice.clientService.Controller.Repository;

import com.Microservice.clientService.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
    public ClientEntity findBydni(Integer dni);
}
