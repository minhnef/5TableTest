package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "productdetails")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailid")
    private Integer productDetailID;
    @Column(name = "productpropertyname")
    private String productPropertyName;
    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price")
    private float price;
    @Column(name = "shellprice")
    private float shellPrice;
    @Column(name = "parentid", insertable = false, updatable = false)
    private Integer parentID;

    @OneToMany(mappedBy = "productDetail")
    @JsonManagedReference(value = "pdpd-prdd")
    private List<ProductDetailPropertyDetails> pdpds;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "parentid")
    private ProductDetails productDetail;


}
