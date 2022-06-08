package com.soen6471.vaxsys.controller;

import com.soen6471.vaxsys.dto.SlotDetailDto;
import com.soen6471.vaxsys.dto.SlotDto;
import com.soen6471.vaxsys.dto.VaccineInfoDetailDto;
import com.soen6471.vaxsys.model.Slot;
import com.soen6471.vaxsys.model.Vaccine;
import com.soen6471.vaxsys.model.VaccineSupplier;
import com.soen6471.vaxsys.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * This is Dashboard Controller. It is used to manage all API calls related to Dashboard and add or delete appointments.
 *
 * @author Gaurang Dobariya
 */
@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    /**
     * This is used to view vaccine information
     *
     * @return List of vaccines along with all the information.
     */
    @GetMapping("/dashboard/vaccineInfo")
    public List<VaccineInfoDetailDto> vaccinationInfo() {
        return dashboardService.getAllVaccineInfo();
    }

    /**
     * This is used to get list of vaccines
     *
     * @return list of the vaccines
     */
    @GetMapping("/dashboard/vaccines")
    public List<Vaccine> vaccineList() {
        return dashboardService.getAllVaccines();
    }

    /**
     * This is used to get hospitals according to Vaccine Id
     *
     * @param vaccineId vaccine ID
     * @return list of the hospitals
     */
    @PostMapping("/dashboard/hospitalByVacId")
    public List<VaccineSupplier> getHospitalsByVaccineId(@RequestParam Integer vaccineId) {
        return dashboardService.getHospitalByVacID(vaccineId);
    }

    /**
     * This is used to get remaining slots for vaccination
     *
     * @param selectedDate      selected date
     * @param patientId         Id of the user
     * @param vaccineSupplierId hospital Id
     * @return list of available slots
     */
    @GetMapping("/dashboard/slotsByFilters")
    public List<Slot> getSlotsByFilters(@RequestParam @DateTimeFormat(pattern = "MM/dd/yyyy") Date selectedDate, @RequestParam Integer patientId,
                                        @RequestParam Integer vaccineSupplierId) {
        return dashboardService.getSlotsByfilters(selectedDate, patientId, vaccineSupplierId);
    }

    /**
     * This is used to book slot
     *
     * @param slotDto data for registration
     * @return id of the booked slot
     */
    @PostMapping("/patient/{patientId}/slot")
    public Integer addSlot(@PathVariable Integer patientId, @RequestBody SlotDto slotDto) {
        slotDto.setPatientId(patientId);
        return dashboardService.addSlot(slotDto);
    }

    /**
     * This is used to view all the upcoming appointments
     *
     * @param patientId Id of the patient
     * @return list of booked slots from today
     */
    @GetMapping("/patient/{patientId}/slot")
    public List<SlotDetailDto> viewSlot(@PathVariable Integer patientId) {
        return dashboardService.viewSlot(patientId);
    }

    /**
     * This is used to cancel the appointment
     *
     * @param slotId Id of the mapping needs to cancel
     * @return id of the canceled slot
     */
    @DeleteMapping("patient/{patientId}/slot/{slotId}")
    public Integer cancelSlot(@PathVariable Integer patientId, @PathVariable Integer slotId) {
        return dashboardService.cancelSlot(slotId);
    }

}
