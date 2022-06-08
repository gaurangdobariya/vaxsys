package com.soen6471.vaxsys.dto;

import com.soen6471.vaxsys.model.PatientSlotMapping;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SlotDto {

    private Integer vaccineSupplierId;

    private Integer patientId;

    private Date vacDate;

    private Integer slotID;


    public PatientSlotMapping slotDtoToMapping(){
        PatientSlotMapping p  =  new PatientSlotMapping();
        p.setSlotID(this.getSlotID());
        p.setPatientId(this.getPatientId());
        p.setVacDate(this.getVacDate());
        p.setVaccineSupplierId(this.getVaccineSupplierId());
        return p;
    }
}
