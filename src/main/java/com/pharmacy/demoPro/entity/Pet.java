package com.pharmacy.demoPro.entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "petId")
    private Integer petId;

    @Column(name = "PetName")
    private String petName;

    @Column(name = "ownerName")
    private String ownerName;

    @Column(name = "species_id")
    private int speciesId;

    @Column(name = "petSpecies")
    private String petSpecies;

    @Column(name = "petSymptoms")
    private String petSymptoms;

    @Column(name = "delete_Status")
    private boolean isDelete;
}
