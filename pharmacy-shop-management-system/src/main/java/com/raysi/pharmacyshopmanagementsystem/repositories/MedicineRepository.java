package com.raysi.pharmacyshopmanagementsystem.repositories;

import com.raysi.pharmacyshopmanagementsystem.entities.Medicine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicineRepository extends JpaRepository<Medicine, Long> {
}
