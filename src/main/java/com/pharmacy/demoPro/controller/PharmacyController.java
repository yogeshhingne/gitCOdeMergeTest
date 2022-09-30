package com.pharmacy.demoPro.controller;

import com.pharmacy.demoPro.dto.PetPharmacy;
import com.pharmacy.demoPro.dto.PharmacyDTO;
import com.pharmacy.demoPro.entity.Pharmacy;
import com.pharmacy.demoPro.repository.PharmacyRepo;
import com.pharmacy.demoPro.service.PharmacyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/pharmacies")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    private PharmacyRepo pharmacyRepo;


    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/insert")
    public ResponseEntity<PharmacyDTO> insertPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {

        Pharmacy pharmacyReq = modelMapper.map(pharmacyDTO, Pharmacy.class);

        Pharmacy phar = pharmacyService.savePharmacy(pharmacyReq);


        PharmacyDTO pharmacyDTO1 = modelMapper.map(phar, PharmacyDTO.class);
        return new ResponseEntity<>(pharmacyDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/pharmacy-list")
    public List<Pharmacy> allPharmacies() {
        return pharmacyService.allPharmacyRecords();
    }

    @GetMapping("/byId/{medicine_id}")
    public Optional<Pharmacy> pharmacyById(@PathVariable Integer medicine_id) {
        return pharmacyService.getById(medicine_id);
    }

    @DeleteMapping("/deletebyId/{medicine_id}")
    public String pharmacyDeleteById(@PathVariable Integer medicine_id) {
        return pharmacyService.deletePharmacyById(medicine_id);
    }

    @PutMapping("/updatePharmacy/{medicine_id}")
    public Pharmacy updatePharma(@PathVariable Integer medicine_id,@RequestBody Pharmacy pharmacy) {
        return pharmacyService.updatePharmacy(medicine_id,pharmacy);
    }

    @GetMapping("/petPharmacy-list")
    public List<Map<String, String>> allpetPharmacies() {
        return pharmacyService.petPharmacies();
    }

    @PostMapping("insertPetPharmacy")
    public PetPharmacy insertPetpharmacies(@RequestBody PetPharmacy petPharmacy) {
        return pharmacyService.insertPetPharmacy(petPharmacy);
    }
}
