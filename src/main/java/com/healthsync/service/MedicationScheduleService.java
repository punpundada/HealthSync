package com.healthsync.service;

import java.util.List;

import com.healthsync.entity.MedicationSchedule;

public interface MedicationScheduleService {
	
	public MedicationSchedule saveMedicationSchedule(MedicationSchedule medicationSchedule,Integer userId);
	public List<MedicationSchedule> getAllMedicationSchedule(Integer userId);
	public MedicationSchedule updateMedicationSchedule(MedicationSchedule medicationSchedule , Integer medId);
	public void deleteMedicationSchedule(Integer medId);
	
		
	

}
