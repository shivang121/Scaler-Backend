package com.scaler.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @JoinColumn(name = "person_id", referencedColumnName = "id",  nullable = false)
    @OneToOne
    private final Person person;

    public Customer(Person person){
        this.person = person;
    }
}
