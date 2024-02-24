package com.Microservice.clientService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name="address")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "number",nullable = false)
    private Integer number;
    @ManyToOne
    @JoinColumn(name="locationId")
    private LocationEntity location;

    @Override
    public String toString() {
        return "AddressEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", location=" + location +
                '}';
    }
}
