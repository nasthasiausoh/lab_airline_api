package com.example.lab_airline_api.controllers;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.repositories.PassengerRepository;
import com.example.lab_airline_api.services.FlightService;
import com.example.lab_airline_api.services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("passengers")
public class PassengerController {

    @Autowired
    PassengerRepository passengerRepository;
    @Autowired
    PassengerService passengerService;

//    API Functionality:

    // Add a new passenger: POST
    @PostMapping
    public ResponseEntity<Optional<Passenger>> addNewPassenger(@RequestBody Passenger passenger){
        passengerRepository.save(passenger);
        return new ResponseEntity(passengerRepository.findAll(), HttpStatus.CREATED);

    }

    //Display all available passengers: GET
    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        return new ResponseEntity(passengerRepository.findAll(), HttpStatus.OK);
    }

    //Display details of a specific passenger: GET ByID
    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Passenger>> getPassenger(@PathVariable Long id){
        return new ResponseEntity(passengerService.findPassenger(id), HttpStatus.OK);
    }


}
