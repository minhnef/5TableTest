package com.example.demo.repository;

import com.example.demo.entity.PropertyDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropertyDetailsRepo extends JpaRepository<PropertyDetails, Integer> {
}
