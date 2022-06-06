package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.model.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * This is Repository class for AAA table. It is used to manage all database relate transaction for this table.
 * This facility  is used by various services.
 * @author Gaurang Dobariya
 */
@Repository
public interface SlotDao extends JpaRepository<Slot,Integer> {

}