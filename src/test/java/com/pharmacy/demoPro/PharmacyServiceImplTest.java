package com.pharmacy.demoPro;

import com.pharmacy.demoPro.dto.PetPharmacy;
import com.pharmacy.demoPro.dto.PharmacyDTO;
import com.pharmacy.demoPro.entity.Pet;
import com.pharmacy.demoPro.entity.Pharmacy;
import com.pharmacy.demoPro.repository.PetRepo;
import com.pharmacy.demoPro.repository.PharmacyRepo;
import com.pharmacy.demoPro.serviceImpl.PharmacyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PharmacyServiceImplTest {

    @MockBean
    PharmacyRepo pharmacyRepo;

    @MockBean
    PetRepo petRepo;

    @Autowired
    PharmacyServiceImpl pharmacyServiceImpl;

    @Test
    public void test_savePharmacy() {
        Pharmacy pharmacy = dummyPharmacy();
        when(pharmacyRepo.save(pharmacy)).thenReturn(dummyPharmacy());
        Pharmacy response = pharmacyServiceImpl.savePharmacy(pharmacy);
        assertNotNull(pharmacy);
    }

    @Test
    public void test_allPharmacyRecords() {
        Pharmacy pharmacy = dummyPharmacy();
        List<Pharmacy> list = new ArrayList<>();
        list.add(pharmacy);
        when(pharmacyRepo.findAll()).thenReturn(list);
        List<Pharmacy> response = pharmacyServiceImpl.allPharmacyRecords();
        assertNotNull(response);
    }
    @Test
    public  void test_insertPetPharmacy(){
        PetPharmacy petPharmacy = dummyPetPharmacy();
        Pharmacy pharmacy = dummyPharmacy();
        Pet pet = dummyPet();
        Pharmacy pharmacy1 = pharmacyRepo.save(pharmacy);
        when(pharmacyRepo.save(pharmacy)).thenReturn(pharmacy1);
        Pet pet1 = petRepo.save(pet);
        when(petRepo.save(pet)).thenReturn(pet1);
        PetPharmacy response = pharmacyServiceImpl.insertPetPharmacy(petPharmacy);
        assertNotNull(response);
    }
    @Test
    public void test_petPharmacies(){
        List<Map<String, String>> pharmacies=pharmacyRepo.findAllPetPharmacyRecords();
        when(pharmacyRepo.findAllPetPharmacyRecords()).thenReturn(pharmacies);
        List<Map<String, String>> response=pharmacyServiceImpl.petPharmacies();
        assertNotNull(response);

    }
    @Test
    public void test_updatePharmaccy() {
        Pharmacy pharmacy = dummyPharmacy();
        Integer id = 3;
        when(pharmacyRepo.getById(id)).thenReturn(pharmacy);
        Pharmacy response = pharmacyServiceImpl.updatePharmacy(id,pharmacy);
        assertNull(response);

    }

    @Test
    public void test_deletePharmacyById() {
        int id=1;
        doNothing().
                doThrow(new RuntimeException())
                .when(pharmacyRepo).deleteById(id);
        String response =pharmacyServiceImpl.deletePharmacyById(id);
        assertEquals("Record deleted successfully",response);

    }

    @Test
    public void test_getById(){
        Pharmacy pharmacy=dummyPharmacy();
        Integer id =1;
        Optional<Pharmacy> pharmacy1=pharmacyRepo.findById(id);
        when(pharmacyRepo.findById(id)).thenReturn(pharmacy1);
        Optional<Pharmacy> response=pharmacyServiceImpl.getById(id);
        assertNotNull(response);
    }

       public Pet dummyPet () {
            Pet pet = new Pet();
            pet.setPetId(1);
            pet.setPetName("dog");
            pet.setSpeciesId(2);
            pet.setPetSymptoms("abc");
            pet.setPetSpecies("xyz");
            pet.setDelete(false);
            pet.setOwnerName("abc");
            return pet;
        }

        public Pharmacy dummyPharmacy () {
            Pharmacy pharmacy = new Pharmacy();
            pharmacy.setMedicine_id(1);
            pharmacy.setPet_id(99);
            pharmacy.setDescription("description");
            pharmacy.setQuantity(2345);
            pharmacy.setPrice(3456);
            pharmacy.setMedicine_name("medicine");
            pharmacy.setMedicine_expiry_date(new Date(12/12/2022));

            return pharmacy;
        }

        PetPharmacy dummyPetPharmacy () {
            PetPharmacy petPharmacy = new PetPharmacy();
            petPharmacy.setPetSymptoms("sasas");
            petPharmacy.setPetId(2);
            petPharmacy.setDescription("sss");
            petPharmacy.setDelete(true);
            petPharmacy.setMedicine_name("asa");
            petPharmacy.setPetSymptoms("asa");
            petPharmacy.setMedicine_expiry_date(new Date(12 / 1 / 2021));
            petPharmacy.setQuantity(3);
            petPharmacy.setPet_species("aaa");
            petPharmacy.setMedicine_id(2);
            petPharmacy.setSpeciesId(2);
            petPharmacy.setPet_name("aaa");
            petPharmacy.setPrice(1.23);
            petPharmacy.setOwner_name("abc");
            return petPharmacy;
        }
    }
