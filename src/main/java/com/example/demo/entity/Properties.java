package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Entity
@Table(name = "properties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Properties {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertyid")
    private int propertyID;
    @Column(name = "productid", insertable = false, updatable = false)
    private int productID;
    @Column(name = "productname")
    private String propertyName;
    @Column(name = "propertysort")
    private int propertySort;

    @ManyToOne
    @JsonBackReference(value = "prd-prop")
    @JoinColumn(name = "productid")
    private Products product;

    @OneToMany(mappedBy = "property")
    @JsonManagedReference(value = "pro-prod")
    private List<PropertyDetails> propertyDetails;




}
