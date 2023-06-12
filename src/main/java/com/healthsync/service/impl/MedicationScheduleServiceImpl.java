package com.healthsync.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthsync.entity.MedicationSchedule;
import com.healthsync.entity.User;
import com.healthsync.exception.ResourceNotFoundException;
import com.healthsync.repository.MedicationScheduleRepository;
import com.healthsync.repository.UserRepository;
import com.healthsync.service.MedicationScheduleService;

@Service
public class MedicationScheduleServiceImpl implements MedicationScheduleService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private MedicationScheduleRepository scheduleRepository;

	@Override
	public MedicationSchedule saveMedicationSchedule(MedicationSchedule medicationSchedule, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<MedicationSchedule> allMeds = user.getAllMedicationSchedule();
		allMeds.add(medicationSchedule);
		this.userRepository.save(user);
		return this.scheduleRepository.save(medicationSchedule);
		
	}

	@Override
	public List<MedicationSchedule> getAllMedicationSchedule(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "id", userId));
		List<MedicationSchedule> allMeds = user.getAllMedicationSchedule();
		return allMeds;
	}

	@Override
	public MedicationSchedule updateMedicationSchedule(MedicationSchedule medicationSchedule, Integer medId) {
		MedicationSchedule schedule = this.scheduleRepository.findById(medId).orElseThrow(()-> new ResourceNotFoundException("MedicationSchedule", "id", medId));
		schedule.setMedicineName(medicationSchedule.getMedicineName());
		schedule.setPrecautions(medicationSchedule.getPrecautions());
		schedule.setTime(medicationSchedule.getTime());
		MedicationSchedule savedMed = this.scheduleRepository.save(schedule);
		return savedMed;
	}

	@Override
	public void deleteMedicationSchedule(Integer medId) {
		this.scheduleRepository.findById(medId).orElseThrow(()-> new ResourceNotFoundException("MedicationSchedule", "id", medId));
		this.scheduleRepository.deleteById(medId);
		
	}

}
