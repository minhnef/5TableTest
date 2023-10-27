package com.example.demo.repository;

import com.example.demo.entity.Properties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPropertiesRepo extends JpaRepository<Properties, Integer> {
}
