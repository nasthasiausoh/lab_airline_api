package com.example.lab_airline_api.services;

import com.example.lab_airline_api.models.Flight;
import com.example.lab_airline_api.models.FlightDTO;
import com.example.lab_airline_api.models.Passenger;
import com.example.lab_airline_api.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightService {

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerService passengerService;

    public Flight findFlight(Long id) {
        return flightRepository.findById(id).get();
    }

    public Flight saveFlight(FlightDTO flightDTO) {
        Flight flight = new Flight(flightDTO.getDestination(), flightDTO.getCapacity(), flightDTO.getDepartureDate(), flightDTO.getDepartureTime());
        for (Long passengerId :flightDTO.getPassengerIds()){
            Passenger passenger = passengerService.findPassenger(passengerId);
            flight.addPassenger(passenger);
        }
        return flightRepository.save(flight);
    }

    public void deleteFlight(Long id) {
        flightRepository.deleteById(id);
    }


//
}
