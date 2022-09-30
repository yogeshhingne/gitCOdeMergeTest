package com.pharmacy.demoPro.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PharmacyDTO {
    private Integer medicine_id;
    private String medicine_name;
    private double price;
    private int quantity;
    private String description;
    private Date medicine_expiry_date;
    private int pet_id;
}
