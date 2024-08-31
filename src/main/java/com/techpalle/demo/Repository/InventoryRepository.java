package com.techpalle.demo.Repository;

import org.hibernate.type.descriptor.converter.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techpalle.demo.Entity.Project1;

@Repository
public interface InventoryRepository extends JpaRepository<Project1, Integer> {

}
