package com.example.customerapi.models;


import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"Customers\"", schema = "alk")
public class Customer {
    @Id
    @SequenceGenerator(name = "some_seq", sequenceName = "alk.\"Customers_CustomerId_seq\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "some_seq") //Customers_CustomerId_seq
    @Column(name = "\"CustomerId\"")
    private Integer customerId;
    @Column (name = "\"Region\"")
    private String Region;

}
