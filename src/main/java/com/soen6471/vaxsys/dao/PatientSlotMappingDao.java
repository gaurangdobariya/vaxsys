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

@Repository
public interface PatientSlotMappingDao extends JpaRepository<PatientSlotMapping,Integer> {

    @Query("SELECT new com.soen6471.vaxsys.dto.SlotDetailDto (" +
            "p.ID , p.patientId,s.ID,s.time,vs.ID,vs.location,v.name,p.vacDate) " +
            "FROM PatientSlotMapping p " +
            "JOIN Slot s ON s.ID = p.slotID " +
            "JOIN VaccineSupplier vs ON vs.ID = p.vaccineSupplierId " +
            "JOIN Vaccine v ON v.ID = vs.vaccineID " +
            "WHERE p.patientId = :patientId AND p.status = 1 AND p.vacDate >= current_date")
    public List<SlotDetailDto>  getSlotByPId(@Param("patientId") Integer patientId);

    @Modifying
    @Query("UPDATE PatientSlotMapping p SET p.status = 0 WHERE  p.ID = :slotId")
    public Integer updateStatus(Integer slotId);

    @Query("SELECT new com.soen6471.vaxsys.model.Slot (s.ID,s.time)" +
            "    FROM PatientSlotMapping p" +
            "   JOIN Slot s ON s.ID = p.slotID" +
            "    WHERE p.status = :status AND p.patientId = :patientId" +
            "     AND p.vaccineSupplierId = :hospitalId AND p.vacDate >= :selectedDate")
    List<Slot> getSlots(@Param("selectedDate")Date selectedDate,@Param("patientId") Integer patientId,
                        @Param("hospitalId") Integer hospitalId,@Param("status") int status);
}
