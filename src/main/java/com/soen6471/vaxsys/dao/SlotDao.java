package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotDao extends JpaRepository<Slot,Integer> {

}