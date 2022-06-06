package com.soen6471.vaxsys.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SlotDetailDto {

    private  Integer patientSlotId;
    private Integer patientId;

    private Integer slotID;

    private  String slotTime;

    private Integer vaccineSupplierId;

    private String supplierLocation;

    private String vaccineName;

    private Date vacDate;
    //current_date


}
