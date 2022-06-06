package com.soen6471.vaxsys.service;

import com.soen6471.vaxsys.dto.SlotDetailDto;
import com.soen6471.vaxsys.dto.SlotDto;
import com.soen6471.vaxsys.dto.VaccineInfoDetailDto;
import com.soen6471.vaxsys.model.Slot;
import com.soen6471.vaxsys.model.Vaccine;
import com.soen6471.vaxsys.model.VaccineSupplier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * This is related to dashboard related services.
 * @author Gaurang Dobariya
 */
@Service
public interface DashboardService {

    /**
     * This is used to view vacccine information
     * @return List of vaccines along with all the information.
     */
   public List<VaccineInfoDetailDto> getAllVaccineInfo();

    /**
     * This is used to get list of all  vaccines
     * @return list of the vaccines
     */
   public List<Vaccine> getAllVaccines();

    /**
     *This is used to get hospitals according to Vaccine Id
     * @param vaccineId vaccine ID
     * @return list of the hospitals
     */
    public List<VaccineSupplier> getHospitalByVacID(Integer vaccineId);

    /**
     * This is used to add slot
     * @param slotDto data for registration
     * @return id of the booked slot
     */
    public Integer addSlot(SlotDto slotDto);

    /**
     * This is used to view all teh upcoming appointments
     * @param patientId Id of the patient
     * @return list of booked slots from today
     */
    public  List<SlotDetailDto> viewSlot(Integer patientId);

    /**
     * This is used to cancel the appointment
     * @param slotId Id of the mapping needs to cancel
     * @return id of the canceled slot
     */
    public Integer cancelSlot(Integer slotId);

    /**
     * This is used to get remaining slots for vaccination
     * @param selectedDate selected date
     * @param patientId Id of the user
     * @param hospitalId hospital Id
     * @return list of available slots
     */
   public List<Slot> getSlotsByfilters(Date selectedDate, Integer patientId, Integer hospitalId);
}
