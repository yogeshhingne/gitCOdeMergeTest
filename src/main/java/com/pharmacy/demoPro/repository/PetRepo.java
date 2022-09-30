package com.pharmacy.demoPro.repository;

import com.pharmacy.demoPro.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepo extends JpaRepository<Pet,Integer> {

}
