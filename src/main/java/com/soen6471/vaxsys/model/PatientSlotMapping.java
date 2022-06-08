package com.soen6471.vaxsys.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

/**
 * This is model classs for patientSlotMapping.This also has ID column as a Unique key.
 * @author Gaurang Dobariya
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "`patientSlotMapping`")
public class PatientSlotMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @Column(name = "VaccineSupplierId")
    private Integer vaccineSupplierId;

    @Column(name = "PatientId")
    private Integer patientId;

    @Column(name = "VacDate")
    private Date vacDate;

    @Column(name = "SlotID")
    private Integer slotID;

    @Column(name = "Status")
    private Integer status;
}
