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
    /**
     *
     * This is used for regiser purpose by providing all the info of the user.
     * @param patientDto This is for patient information
     * @return id of the user if email and password match else null in case of any error/invalidation
     */
    public Integer register(PatientDto patientDto);

    /**
     * This is used for login purpose by loginDTo.
     * @param loginDto information for the login credential
     * @return id of the user if valid credentials
     */
    public Integer login(LoginDto loginDto);
}
