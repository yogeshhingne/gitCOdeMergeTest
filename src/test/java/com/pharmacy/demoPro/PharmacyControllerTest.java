package com.pharmacy.demoPro;

import com.pharmacy.demoPro.controller.PharmacyController;
import com.pharmacy.demoPro.dto.PetPharmacy;
import com.pharmacy.demoPro.dto.PharmacyDTO;
import com.pharmacy.demoPro.entity.Pet;
import com.pharmacy.demoPro.entity.Pharmacy;
import com.pharmacy.demoPro.serviceImpl.PharmacyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class PharmacyControllerTest {
    @Autowired
    PharmacyController pharmacyController;

    @MockBean
    PharmacyServiceImpl pharmacyServiceImpl;


    @Test
    public void test_updatePharma() {
        Pharmacy pharmacy = dummyPharmacy();
        Integer id = 3;
        when(pharmacyServiceImpl.updatePharmacy(id, pharmacy)).thenReturn(pharmacy);
        Pharmacy response = pharmacyController.updatePharma(id, pharmacy);
        assertNotNull(response);
    }

    @Test
    public void test_pharmacyById() {
        Integer id = 3;
        Optional<Pharmacy> pharmacy = pharmacyServiceImpl.getById(id);
        when(pharmacyServiceImpl.getById(id)).thenReturn(pharmacy);
        Optional<Pharmacy> response = pharmacyController.pharmacyById(id);
        assertNotNull(response);

    }


    @Test
    public void test_insertPharmacy() {
        PharmacyDTO pharmacyDTO = dummyPharmacyDTO();
        Pharmacy pharmacy = dummyPharmacy();
    //    Pharmacy pharmacy1 = pharmacyServiceImpl.savePharmacy(pharmacy);
        when(pharmacyServiceImpl.savePharmacy(pharmacy)).thenReturn(pharmacy);
        ResponseEntity<PharmacyDTO> response = pharmacyController.insertPharmacy(pharmacyDTO);
        assertNotNull(response);
    }
@Test
public void test_pharmacyDeleteById(){
        Integer id=1;
        when(pharmacyServiceImpl.deletePharmacyById(id)).thenReturn("Record deleted successfully");
        String response=pharmacyController.pharmacyDeleteById(id);
        assertEquals(response,"Record deleted successfully");
}

    @Test
    public void test_allPharmacies() {
        List<Pharmacy> pharmacies = pharmacyServiceImpl.allPharmacyRecords();
        when(pharmacyServiceImpl.allPharmacyRecords()).thenReturn(pharmacies);
        List<Pharmacy> response = pharmacyController.allPharmacies();
        assertNotNull(response);
    }

    @Test
    public void test_insertPetpharmacies(){
        PetPharmacy petPharmacy=dummyPetPharmacy();
        Pet pet = dummyPet();
        Pharmacy pharmacy = dummyPharmacy();
       // PetPharmacy petPharmacy1 = pharmacyServiceImpl.insertPetPharmacy(petPharmacy);
        when(pharmacyServiceImpl.insertPetPharmacy(petPharmacy)).thenReturn(petPharmacy);
        PetPharmacy response=pharmacyController.insertPetpharmacies(petPharmacy);
        assertNotNull(response);
    }
@Test
public void test_allpetPharmacies(){
    List<Map<String, String>> pharmacies=pharmacyServiceImpl.petPharmacies();
    when(pharmacyServiceImpl.petPharmacies()).thenReturn(pharmacies);
    List<Map<String, String>> response=pharmacyController.allpetPharmacies();
    assertNotNull(response);
}
    public Pet dummyPet() {
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


//    public Pharmacy dummyPharmacy() {
//        Pharmacy pharmacy = new Pharmacy();
//        pharmacy.setMedicine_id(1);
//        pharmacy.setPet_id(99);
//        pharmacy.setDescription("description");
//        pharmacy.setQuantity(2345);
//        pharmacy.setPrice(3456);
//        pharmacy.setMedicine_name("medicine");
//        pharmacy.setMedicine_expiry_date(new Date(12/12/2022));
//
//        return pharmacy;
//    }
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

    PetPharmacy dummyPetPharmacy() {
        PetPharmacy petPharmacy = new PetPharmacy();
        petPharmacy.setPetSymptoms("sasas");
        petPharmacy.setPetId(2);
        petPharmacy.setDescription("sss");
        petPharmacy.setDelete(true);
        petPharmacy.setMedicine_name("asa");
        petPharmacy.setPetSymptoms("asa");
        petPharmacy.setMedicine_expiry_date(new Date(12/1/2021));
        petPharmacy.setQuantity(3);
        petPharmacy.setPet_species("aaa");
        petPharmacy.setMedicine_id(2);
        petPharmacy.setSpeciesId(2);
        petPharmacy.setPet_name("aaa");
        petPharmacy.setPrice(1.23);
        petPharmacy.setOwner_name("abc");
        return petPharmacy;
    }

    PharmacyDTO dummyPharmacyDTO() {
        PharmacyDTO pharmacyDTO = new PharmacyDTO();
        pharmacyDTO.setMedicine_id(1);
        pharmacyDTO.setPet_id(99);
        pharmacyDTO.setDescription("description");
        pharmacyDTO.setQuantity(2345);
        pharmacyDTO.setPrice(3456);
        pharmacyDTO.setMedicine_name("medicine");
        pharmacyDTO.setMedicine_expiry_date(new Date(12/12/2022));
        return pharmacyDTO;
    }
}
