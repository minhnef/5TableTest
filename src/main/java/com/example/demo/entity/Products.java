package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productid")
    private int productID;
    @Column(name = "productname")
    private String productName;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "prd-prop")
    private List<Properties> properties;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference(value = "prd-pdpd")
    private List<ProductDetailPropertyDetails> pdpd;
}
