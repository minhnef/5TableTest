package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "productdetailpropertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailPropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productdetailpropertydetailid")
    private int productDetailPropertyDetailsID;
    @Column(name = "productdetailid", insertable = false, updatable = false)
    private int productDetailID;
    @Column(name = "propertydetailid", insertable = false, updatable = false)
    private int propertyDetailID;
    @Column(name = "productid", insertable = false, updatable = false)
    private int productID;

    @ManyToOne
    @JsonBackReference(value = "prd-pdpd")
    @JoinColumn(name = "productid")
    private Products product;

    @ManyToOne
    @JsonBackReference(value = "pd-pdpd")
    @JoinColumn(name = "propertydetailid")
    private PropertyDetails propertyDetail;

    @ManyToOne
    @JsonBackReference(value = "pdpd-prdd")
    @JoinColumn(name = "productdetailid")
    private ProductDetails productDetail;

}
