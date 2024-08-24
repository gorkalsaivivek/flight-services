package com.practice.flight_services.controllers;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import com.practice.flight_services.dto.FlightDTO;
import com.practice.flight_services.entity.FlightServiceEntity;
import com.practice.flight_services.repository.FlightServiceRepository;

@RestController
public class FlightController {
	
	@Autowired
	FlightServiceRepository flightServiceRepository;
	
	@GetMapping("/flights")
	public List<FlightDTO> getData() {
	
	List<FlightServiceEntity> flightEnityList=flightServiceRepository.findAll();
	return flightEnityList.stream().map(this::convertToDTO).collect(Collectors.toList());
	
	
	}
	
	@GetMapping("/checkFlightService")
	public String getFlightService() {
		return "UP";
	}

	private FlightDTO convertToDTO(FlightServiceEntity entity) {
	FlightDTO dto = new FlightDTO();
    dto.setId(entity.getId());
    dto.setFlightNumber(entity.getFlightNumber());
    dto.setOperatingAirlines(entity.getOperatingAirlines());
    dto.setDepartureCity(entity.getDepartureCity());
    dto.setArrivalCity(entity.getArrivalCity());
    dto.setDateOfDeparture(entity.getDateOfDeparture());
    dto.setEstimatedDepartureTime(entity.getEstimatedDepartureTime());
    return dto;
	}

}
