package com.scaler.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ride")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Driver driver;

    @JoinColumn(name = "id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Customer customer;

    private Double cost;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pickup_location_id", referencedColumnName = "id", nullable = false)
    private Address pickup_location;

    @OneToOne
    @JoinColumn(name = "drop_location_id", referencedColumnName = "id", nullable = false)
    private Address drop_location;

    private RideStatus status;

}
