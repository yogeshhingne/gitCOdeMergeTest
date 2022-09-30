package com.pharmacy.demoPro.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Date;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class PetPharmacy {

    private Integer medicine_id;
    private String medicine_name;
    private double price;
    private int quantity;
    private String description;
    private Date medicine_expiry_date;

    private int petId;
    private String pet_name;
    private String owner_name;
    private int speciesId;
    private String pet_species;
    private String petSymptoms;
    private boolean isDelete;

}
