package com.practice.flight_services.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.flight_services.entity.FlightServiceEntity;

public interface FlightServiceRepository extends JpaRepository<FlightServiceEntity, Long>{

}
