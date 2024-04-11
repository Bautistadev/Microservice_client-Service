package com.Microservice.clientService.Controller.Repository;

import com.Microservice.clientService.Entity.AddressEntity;
import io.swagger.models.auth.In;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity,Integer> {

    @Query(value = "SELECT* FROM address WHERE name=?1 and number=?2 and location_id=?3",nativeQuery = true)
    public AddressEntity findByAttribute(String name, Integer number, Integer location_id);
}
