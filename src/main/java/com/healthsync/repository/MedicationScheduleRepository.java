package com.healthsync.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthsync.entity.MedicationSchedule;

public interface MedicationScheduleRepository extends JpaRepository<MedicationSchedule, Integer>{

}
