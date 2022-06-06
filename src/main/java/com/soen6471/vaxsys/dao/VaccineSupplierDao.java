package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.model.VaccineSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface VaccineSupplierDao extends JpaRepository<VaccineSupplier,Integer> {

    public List<VaccineSupplier> findByVaccineID(Integer vaccineId);
}