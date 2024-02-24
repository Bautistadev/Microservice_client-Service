package com.Microservice.clientService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="location")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name="postalCode",nullable = false)
    private Integer postalCode;
    @ManyToOne
    @JoinColumn(name="idProvince")
    private ProvinceEntity provinceEntity;

}
