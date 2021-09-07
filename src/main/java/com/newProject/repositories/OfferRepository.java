package com.newProject.repositories;

import java.util.List;
import java.util.Optional;

import com.newProject.models.Offer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<Offer , Long> {
        
    Offer save(Offer offerDeatil);

    @Query(value = "SELECT * FROM OFFER_MASTER", 
    nativeQuery = true)
    List<Offer> getAllOffers();

    Optional<Offer> findById(Long Id);

    @Query(value = "SELECT * FROM OFFER_MASTER o where o.offer_id = :Id", 
    nativeQuery = true)
    Optional<Offer> check(Long Id);
    
}
