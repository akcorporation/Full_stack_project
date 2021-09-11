package com.newProject.repositories;

import com.newProject.models.Bill;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends JpaRepository<Bill , Long> {
    
}
