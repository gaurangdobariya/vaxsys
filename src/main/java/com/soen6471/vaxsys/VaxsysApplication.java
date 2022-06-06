package com.soen6471.vaxsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.autoconfigure.security.servlet.ManagementWebSecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * This is the main class of the application/VAXSYS. This is the entry point for the execution of the backend application.
 * @author Gaurang Dobariya
 */
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class, ManagementWebSecurityAutoConfiguration.class })
public class VaxsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(VaxsysApplication.class, args);
	}

}
