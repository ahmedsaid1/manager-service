package com.stc.manager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stc.manager.model.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager, Long> {

}
