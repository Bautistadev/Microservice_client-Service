package com.Microservice.clientService.Repository;

import com.Microservice.clientService.Entity.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Integer> {
    public ClientEntity findBydni(Integer dni);

    public List<ClientEntity> findByname(String name);

}
