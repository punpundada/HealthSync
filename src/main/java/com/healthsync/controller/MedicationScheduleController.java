package com.healthsync.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthsync.entity.MedicationSchedule;
import com.healthsync.responce.ApiResponce;
import com.healthsync.responce.UserDto;
import com.healthsync.service.MedicationScheduleService;
import com.healthsync.service.UserService;

@RestController
@RequestMapping("/api/meds")
public class MedicationScheduleController {
	
	@Autowired
	private MedicationScheduleService medicationScheduleService;
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/user/{userId}")
	public ResponseEntity<MedicationSchedule> saveMeds(@RequestBody MedicationSchedule medicationSchedule,@PathVariable Integer userId){
		
		MedicationSchedule schedule = this.medicationScheduleService.saveMedicationSchedule(medicationSchedule, userId);
		return new ResponseEntity<MedicationSchedule>(schedule , HttpStatus.CREATED);
	}
	
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<MedicationSchedule>> getAllMeds(@PathVariable Integer userId) {
		UserDto dto = this.userService.getUser(userId);
		List<MedicationSchedule> allMeds = dto.getAllMeds();
		return new ResponseEntity<List<MedicationSchedule>>(allMeds , HttpStatus.OK);
	}
	
	@PutMapping("/user/{userId}")
	public ResponseEntity<MedicationSchedule> updateMeds(MedicationSchedule medicationSchedule , Integer medId){
		MedicationSchedule schedule = this.medicationScheduleService.updateMedicationSchedule(medicationSchedule, medId);
		return new ResponseEntity<MedicationSchedule>(schedule , HttpStatus.OK);
	}
	
	public ResponseEntity<ApiResponce> deleteMed(Integer medId){
		this.medicationScheduleService.deleteMedicationSchedule(medId);
		return new ResponseEntity<ApiResponce>(new ApiResponce(String.format("The medicine with id %d is deleted", medId),true),HttpStatus.OK);
	}
	

}
