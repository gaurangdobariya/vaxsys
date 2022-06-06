package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This is Repository class for AAA table. It is used to manage all database relate transaction for this table.
 * This facility  is used by various services.
 * @author Gaurang Dobariya
 */
@Repository
public interface AuthenticationDao extends JpaRepository<Patient,Integer> {
    List<Patient> findByEmailID(String emailId);

//    Optional<Patient> findByEmailID(String email);
}
