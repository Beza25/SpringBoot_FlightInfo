package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FlightRepository extends CrudRepository<FlightInfo, Long> {
    ArrayList<FlightInfo> findByAirlineContainingIgnoreCase(String airline);

}
