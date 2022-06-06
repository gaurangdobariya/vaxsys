package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;
/**
 * This is model classs for vaccine.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`vaccine`")
public class Vaccine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "Name")
    private String name;

    @Column(name = "NoOfDoses")
    private Integer noOfDoses;

    @Column(name = "DiseaseID")
    private Integer diseaseID;

//    SELECT disease.Name,vaccine.Name ,vaccine.NoOfDoses, vaccineSupplier.Name FROM vaccine JOIN disease ON vaccine.DiseaseID = disease.ID JOIN vaccineSupplier ON vaccine.ID = vaccineSupplier.VaccineID;
}
