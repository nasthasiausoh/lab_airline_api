package com.example.lab_airline_api.controllers;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.FlightDTO;
import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("flights")
public class FlightController {

    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;

//    API Functionality:


//Display all available flights: GET
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {
            return new ResponseEntity(flightRepository.findAll(), HttpStatus.OK);
    }

//Display details of a specific flight: GET ByID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Flight>> getFlight(@PathVariable Long id){
        return new ResponseEntity(flightService.findFlight(id), HttpStatus.OK);
    }


//Book a passenger on to a flight:
    @PostMapping(value = "/booking")
    public ResponseEntity<Flight> bookPassengerOnAFlight(@RequestBody FlightDTO flightDTO){
        Flight flight = flightService.saveFlight(flightDTO);
        return new ResponseEntity(flight, HttpStatus.CREATED);
    }

//Cancel a flight: DELETE
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id){
        flightService.deleteFlight(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    // Add details of a new flight: POST SHOULD INCLUDE A REQUEST PARAM?
    @PostMapping
    public ResponseEntity<Optional<Flight>> addNewFlight(@RequestBody Flight flight){
        flightRepository.save(flight);
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.CREATED);
    }


//
}
