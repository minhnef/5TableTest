package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "propertydetails")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PropertyDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "propertydetailid")
    private int propertyDetailID;
    @Column(name = "propertyid",insertable = false, updatable = false)
    private int propertyID;
    @Column(name = "propertydetailcode")
    private String propertyDetailCode;
    @Column(name = "propertydetaildetail")
    private String propertyDetailDetail;


    @ManyToOne
    @JsonBackReference(value = "pro-prod")
    @JoinColumn(name = "propertyid")
    private Properties property;

    @OneToMany(mappedBy = "propertyDetail")
    @JsonManagedReference(value = "pd-pdpd")
    private List<ProductDetailPropertyDetails>pdpds;

}
