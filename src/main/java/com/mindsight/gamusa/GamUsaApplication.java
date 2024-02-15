package com.mindsight.gamusa;

import com.mindsight.gamusa.domain.Trip;
import com.mindsight.gamusa.repository.TripRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;

import java.time.LocalDate;
import java.time.Month;

@SpringBootApplication
@RequiredArgsConstructor
public class GamUsaApplication implements CommandLineRunner {
	private final Logger logger = LoggerFactory.getLogger(GamUsaApplication.class);
	private final TripRepository tripRepository;

	public static void main(String[] args) {
		SpringApplication.run(GamUsaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		tripRepository.save(new Trip(LocalDate.parse("2024-01-01"), LocalDate.parse("2024-02-01")));
		tripRepository.save(new Trip(LocalDate.parse("2024-03-01"), LocalDate.parse("2024-04-01")));
		tripRepository.save(new Trip(LocalDate.parse("2024-05-01"), LocalDate.parse("2024-06-01")));

		// Fetch all Trips and log to the console
		for(Trip trip: tripRepository.findAll()) {
			logger.info("Departure Date: {} \nReturn Date: {}", trip.getDepartureDate(), trip.getReturnDate());
		}
	}
}
