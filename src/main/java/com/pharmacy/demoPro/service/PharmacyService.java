package com.pharmacy.demoPro.service;

import com.pharmacy.demoPro.dto.PetPharmacy;
import com.pharmacy.demoPro.entity.Pharmacy;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface PharmacyService {
    public Pharmacy savePharmacy(Pharmacy pharmacy);

    public List<Pharmacy> allPharmacyRecords();

    public Optional<Pharmacy> getById(Integer medicine_id);

  public String deletePharmacyById(Integer medicine_id);

   public Pharmacy updatePharmacy(Integer medicine_id,Pharmacy pharmacy);
  //public PetPharmacy updatePetPharmacy(PetPharmacy petPharmacy);
    public PetPharmacy insertPetPharmacy(PetPharmacy petPharmacy);


    List<Map<String, String>> petPharmacies();
}
