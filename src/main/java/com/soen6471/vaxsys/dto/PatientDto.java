package com.soen6471.vaxsys.dto;

import com.soen6471.vaxsys.model.Patient;
import lombok.*;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PatientDto {
    private String firstName;
    private String lastName;
    private String phoneNo;
    private Date dob;
    private String emailID;
    private  String address;
    private String password;

    public Patient patientDtoToPatientMapper(){
        Patient p = new Patient();
        p.setAddress(this.getAddress());
        p.setDOB(this.getDob());
        p.setPassword(this.getPassword());
        p.setEmailID(this.getEmailID());
        p.setFirstName(this.getFirstName());
        p.setLastName(this.getLastName());
        p.setPhoneNo(this.getPhoneNo());
        return p;
    }

}
