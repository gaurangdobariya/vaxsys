package com.soen6471.vaxsys.controller;

import com.soen6471.vaxsys.dto.LoginDto;
import com.soen6471.vaxsys.dto.PatientDto;
import com.soen6471.vaxsys.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * This is Authentication Controller. It is used to manage all API calls related to authentication.
 * @author Gaurang Dobariya
 */
@RestController
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    /**
     *
     * This is used for regiser purpose by providing all the info of the user.
     * @param patientDto This is for patient information
     * @return id of the user if email and password match else null in case of any error/invalidation
     */
    @PostMapping("/register")
    public Integer register(@RequestBody PatientDto patientDto){
        System.out.println(patientDto);
        return authenticationService.register(patientDto);
    }

    /**
     *
     * This is used for login purpose by providing emailId and password.
     * @param emailId This is for email ID field as a param
     * @param password This is for password field as a param
     * @return id of the user if email and password match else null in case of any error/invalidation
     */
    @PostMapping("/login")
    public Integer login(@RequestParam String emailId,@RequestParam String password){
        LoginDto loginDto = new LoginDto();
        loginDto.setEmailId(emailId);
        loginDto.setPassword(password);
        return authenticationService.login(loginDto);
    }
}
