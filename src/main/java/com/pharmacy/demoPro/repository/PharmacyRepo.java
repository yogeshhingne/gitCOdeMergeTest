package com.pharmacy.demoPro.repository;

import com.pharmacy.demoPro.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PharmacyRepo extends JpaRepository<Pharmacy, Integer> {
  @Query(value = " select p.pet_id,p.pet_name,p.pet_species,p.owner_name,ph.medicine_name,ph.price,ph.quantity,\n" +
          "ph.medicine_expiry_date,ph.description \n" +
          "from pet p inner join\n" +
          "pharmacy ph on p.pet_id = ph.pet_id",nativeQuery = true)
          public List<Map<String,String>> findAllPetPharmacyRecords();
}

