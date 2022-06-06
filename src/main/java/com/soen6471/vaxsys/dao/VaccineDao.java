package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.dto.VaccineInfoDetailDto;
import com.soen6471.vaxsys.model.Patient;
import com.soen6471.vaxsys.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * This is Repository class for AAA table. It is used to manage all database relate transaction for this table.
 * This facility  is used by various services.
 * @author Gaurang Dobariya
 */
@Repository
public interface VaccineDao extends JpaRepository<Vaccine,Integer> {

    @Query("SELECT new com.soen6471.vaxsys.dto.VaccineInfoDetailDto( d.name,v.name ,v.noOfDoses, vs.name )" +
            "FROM Vaccine v " +
            "JOIN Disease d ON v.diseaseID = d.ID " +
            "JOIN VaccineSupplier vs ON v.ID = vs.vaccineID")
    public List<VaccineInfoDetailDto> getAllVaccineInfo();
}
