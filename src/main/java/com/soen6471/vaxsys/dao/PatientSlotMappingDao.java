package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.dto.SlotDetailDto;
import com.soen6471.vaxsys.model.PatientSlotMapping;
import com.soen6471.vaxsys.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
/**
 * This is Repository class for PatientSlotMapping table. It is used to manage all database relate transaction for this table.
 * This facility  is used by various services.
 * @author Gaurang Dobariya
 */
@Repository
public interface PatientSlotMappingDao extends JpaRepository<PatientSlotMapping,Integer> {

    /**
     * This is used to view all teh upcoming appointments
     * @param patientId patient ID
     * @return list of the upcoming slot registration
     */
    @Query("SELECT new com.soen6471.vaxsys.dto.SlotDetailDto (" +
            "p.ID , p.patientId,s.ID,s.time,vs.ID,vs.location,v.name,p.vacDate) " +
            "FROM PatientSlotMapping p " +
            "JOIN Slot s ON s.ID = p.slotID " +
            "JOIN VaccineSupplier vs ON vs.ID = p.vaccineSupplierId " +
            "JOIN Vaccine v ON v.ID = vs.vaccineID " +
            "WHERE p.patientId = :patientId AND p.status = 1 AND p.vacDate >= current_date")
    public List<SlotDetailDto>  getSlotByPId(@Param("patientId") Integer patientId);

    /**
     * This is used to update status to inactive for canceleed slots
     * @param slotId Id of the slots
     * @return status of cancellation process
     */
    @Modifying
    @Query("UPDATE PatientSlotMapping p SET p.status = 0 WHERE  p.ID = :slotId")
    public Integer updateStatus(Integer slotId);

    /**
     * This is used to get all the remained /unbooked slots
     * @param selectedDate Date for which user is looking for the appointment
     * @param patientId Id of the patient
     * @param hospitalId Hospital Id selected for booking slot
     * @param status This is used to get active slots
     * @return list of booked slots
     */
    @Query("SELECT new com.soen6471.vaxsys.model.Slot (s.ID,s.time)" +
            "    FROM PatientSlotMapping p" +
            "   JOIN Slot s ON s.ID = p.slotID" +
            "    WHERE p.status = :status AND p.patientId = :patientId" +
            "     AND p.vaccineSupplierId = :hospitalId AND p.vacDate >= :selectedDate")
    List<Slot> getSlots(@Param("selectedDate")Date selectedDate,@Param("patientId") Integer patientId,
                        @Param("hospitalId") Integer hospitalId,@Param("status") int status);
}
