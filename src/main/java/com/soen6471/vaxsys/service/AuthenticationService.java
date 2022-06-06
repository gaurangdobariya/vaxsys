package com.soen6471.vaxsys.service;

import com.soen6471.vaxsys.dto.LoginDto;
import com.soen6471.vaxsys.dto.PatientDto;
import org.springframework.stereotype.Service;

/**
 * This is used for authentication related services.
 * @author Gaurang Dobariya
 */
@Service
public interface AuthenticationService {

    public Integer register(PatientDto patientDto);

    public Integer login(LoginDto loginDto);
}
