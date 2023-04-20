package com.example.lab_airline_api.repositories;

import com.example.lab_airline_api.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
