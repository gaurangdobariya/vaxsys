package com.soen6471.vaxsys.service.impl;

import com.soen6471.vaxsys.dao.PatientSlotMappingDao;
import com.soen6471.vaxsys.dao.SlotDao;
import com.soen6471.vaxsys.dao.VaccineDao;
import com.soen6471.vaxsys.dao.VaccineSupplierDao;
import com.soen6471.vaxsys.dto.SlotDetailDto;
import com.soen6471.vaxsys.dto.SlotDto;
import com.soen6471.vaxsys.dto.VaccineInfoDetailDto;
import com.soen6471.vaxsys.model.PatientSlotMapping;
import com.soen6471.vaxsys.model.Slot;
import com.soen6471.vaxsys.model.Vaccine;
import com.soen6471.vaxsys.model.VaccineSupplier;
import com.soen6471.vaxsys.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * This is the Concrete Implementation of the DashboardService.
 * @author Gaurang Dobariya
 */
@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private VaccineDao vaccineDao;

    @Autowired
    private VaccineSupplierDao vaccineSupplierDao;


    @Autowired
    private PatientSlotMappingDao patientSlotMappingDao;

    @Autowired
    private SlotDao slotDao;
    /**
     * {@inheritDoc}
     */
    @Override
    public List<VaccineInfoDetailDto> getAllVaccineInfo() {
        return vaccineDao.getAllVaccineInfo();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Vaccine> getAllVaccines() {
        return vaccineDao.findAll();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<VaccineSupplier> getHospitalByVacID(Integer vaccineId) {
        return vaccineSupplierDao.findByVaccineID(vaccineId);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public Integer addSlot(SlotDto slotDto) {
        PatientSlotMapping patientSlotMapping = slotDto.slotDtoToMapping();
        patientSlotMapping.setStatus(1);
        return patientSlotMappingDao.saveAndFlush(patientSlotMapping).getID();
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<SlotDetailDto> viewSlot(Integer patientId) {
        return patientSlotMappingDao.getSlotByPId(patientId);
    }
    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public Integer cancelSlot(Integer slotId) {
        return  patientSlotMappingDao.updateStatus(slotId);

    }
    /**
     * {@inheritDoc}
     */
    @Override
    public List<Slot> getSlotsByfilters(Date selectedDate, Integer patientId, Integer hospitalId) {
        List<Slot> slots = slotDao.findAll();
        List<Slot> slotList = patientSlotMappingDao.getSlots(selectedDate, patientId, hospitalId, 1);
        slots.removeAll(slotList);
         return slots;
    }
}
