package com.soen6471.vaxsys.service.impl;

import com.soen6471.vaxsys.dao.AuthenticationDao;
import com.soen6471.vaxsys.dto.LoginDto;
import com.soen6471.vaxsys.dto.PatientDto;
import com.soen6471.vaxsys.model.Patient;
import com.soen6471.vaxsys.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

/**
 * This is the Concrete Implementation of the AuthenticationService.
 * @author Gaurang Dobariya
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
   private AuthenticationDao authenticationDao;

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer register (PatientDto patientDto){
        Patient patient = patientDto.patientDtoToPatientMapper();
        Patient savedPatient = authenticationDao.saveAndFlush(patient);
        return savedPatient.getID();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Integer login(LoginDto loginDto) {
         String email = loginDto.getEmailId();
        String pass = loginDto.getPassword();
        List<Patient> selectedPatient = authenticationDao.findByEmailID(email);
        if(selectedPatient.size() >0){
            Patient p = selectedPatient.get(0);
            if(pass.equals(p.getPassword()))
                   return selectedPatient.get(0).getID();
        }
        return null;
    }
}
