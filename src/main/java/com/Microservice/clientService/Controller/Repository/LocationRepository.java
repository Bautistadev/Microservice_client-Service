package com.Microservice.clientService.Controller.Repository;

import com.Microservice.clientService.Entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity,Integer> {

    @Query(value ="SELECT * FROM location WHERE name=?2 and id_province=?1" ,nativeQuery = true)
    public LocationEntity findByidProvince(Integer idLocation,String name);

    public List<LocationEntity> findByname(String name);
}
