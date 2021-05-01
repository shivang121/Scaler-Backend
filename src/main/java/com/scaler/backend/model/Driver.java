package com.scaler.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "driver")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Driver{
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "person_id", referencedColumnName = "id", nullable = false)
    @OneToOne
    private Person person;

}
