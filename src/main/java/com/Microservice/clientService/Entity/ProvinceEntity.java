package com.Microservice.clientService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="province")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProvinceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;

    @Override
    public String toString() {
        return "ProvinceEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
