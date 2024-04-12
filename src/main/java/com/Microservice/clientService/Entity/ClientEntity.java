package com.Microservice.clientService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;


import java.time.LocalDate;

@Entity
@Table(name="client")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "lastname",nullable = false)
    private String lastname;
    @Column(name = "dni",nullable = false)
    private Integer dni;
    @Column(name = "cuil",nullable = false)
    private Integer cuil;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "telephone",nullable = false)
    private String telephone;
    @Temporal(TemporalType.DATE)
    private LocalDate birth;
    @ManyToOne
    @JoinColumn(name="addressId",referencedColumnName = "id")
    private AddressEntity address;

    @Override
    public String toString() {
        return "ClientEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dni=" + dni +
                ", cuil=" + cuil +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", birth=" + birth +
                ", address=" + address +
                '}';
    }
}
