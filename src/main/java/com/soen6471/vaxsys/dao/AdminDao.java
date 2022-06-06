package com.soen6471.vaxsys.dao;

import com.soen6471.vaxsys.model.Admin;
import com.soen6471.vaxsys.model.Vaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminDao extends JpaRepository<Admin,Integer> {

}
