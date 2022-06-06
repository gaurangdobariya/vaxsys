package com.soen6471.vaxsys.controller;

import com.soen6471.vaxsys.dao.VaccineDao;
import com.soen6471.vaxsys.dto.LoginDto;
import com.soen6471.vaxsys.dto.SlotDetailDto;
import com.soen6471.vaxsys.dto.SlotDto;
import com.soen6471.vaxsys.dto.VaccineInfoDetailDto;
import com.soen6471.vaxsys.model.Slot;
import com.soen6471.vaxsys.model.Vaccine;
import com.soen6471.vaxsys.model.VaccineSupplier;
import com.soen6471.vaxsys.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * This is Dashboard Controller. It is used to manage all API calls related to Dashboard and add or delete appointments.
 * @author Gaurang Dobariya
 */
@RestController
public class DashboardController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/dashboard/vaccineInfo")
    public List<VaccineInfoDetailDto> vaccinationInfo(){
        return dashboardService.getAllVaccineInfo();
    }


    @GetMapping("/dashboard/vaccines")
    public List<Vaccine> vaccineList(){
        return dashboardService.getAllVaccines();
    }

    @PostMapping("/dashboard/hospitalByVacId")
    public List<VaccineSupplier> getHospitalsByVaccineId(@RequestParam Integer vaccineId){
        return dashboardService.getHospitalByVacID(vaccineId);
    }

    @GetMapping("/dashboard/slotsByFilters")
    public List<Slot> getSlotsByFilters(@RequestParam Date selectedDate, @RequestParam Integer patientId,
                                        @RequestParam  Integer vaccineSupplierId){
        return dashboardService.getSlotsByfilters(selectedDate,patientId,vaccineSupplierId);
    }

    @PostMapping("/slot/book")
    public Integer addSlot(@RequestBody SlotDto slotDto){
        return dashboardService.addSlot(slotDto);
    }

    @GetMapping("/slot/view")
    public List<SlotDetailDto> viewSlot(@RequestParam Integer patientId){
        return dashboardService.viewSlot(patientId);
    }

    @GetMapping("/slot/cancel")
    public Integer cancelSlot(@RequestParam Integer slotId){
        return dashboardService.cancelSlot(slotId);
    }








}
