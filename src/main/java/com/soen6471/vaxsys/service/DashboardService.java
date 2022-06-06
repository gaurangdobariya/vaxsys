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


   public List<VaccineInfoDetailDto> getAllVaccineInfo();

   public List<Vaccine> getAllVaccines();

    public List<VaccineSupplier> getHospitalByVacID(Integer vaccineId);

    public Integer addSlot(SlotDto slotDto);

    public  List<SlotDetailDto> viewSlot(Integer patientId);

    public Integer cancelSlot(Integer slotId);

   public List<Slot> getSlotsByfilters(Date selectedDate, Integer patientId, Integer hospitalId);
}
