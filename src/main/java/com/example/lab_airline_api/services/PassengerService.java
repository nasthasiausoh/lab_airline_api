package com.example.lab_airline_api.services;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.FlightRepository;
import com.example.lab_airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public Passenger findPassenger(Long id) {
        return passengerRepository.findById(id).get();
    }

}
