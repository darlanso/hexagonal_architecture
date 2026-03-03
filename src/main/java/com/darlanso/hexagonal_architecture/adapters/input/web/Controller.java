package com.darlanso.hexagonal_architecture.adapters.input.web;

import com.darlanso.hexagonal_architecture.adapters.input.web.dto.CheckoutInputDTO;
import com.darlanso.hexagonal_architecture.adapters.input.web.dto.CheckoutOutPutDTO;
import com.darlanso.hexagonal_architecture.adapters.input.web.dto.ParkedCarInputDTO;
import com.darlanso.hexagonal_architecture.adapters.input.web.dto.ParkedCarOutputDTO;
import com.darlanso.hexagonal_architecture.adapters.output.repository.ParkedCarMemoryRepository;
import com.darlanso.hexagonal_architecture.application.usecase.Checkin;
import com.darlanso.hexagonal_architecture.application.usecase.Checkout;
import com.darlanso.hexagonal_architecture.application.usecase.GetParkedCars;
import com.darlanso.hexagonal_architecture.domain.port.ParkedCarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class Controller {

	protected final ParkedCarRepository repository;
	private final Checkin checkin;
	private final Checkout checkout;
	private final GetParkedCars getParkedCars;

	public Controller() {
		this.repository = new ParkedCarMemoryRepository();
		this.checkin = new Checkin(this.repository);
		this.checkout = new Checkout(this.repository);
		this.getParkedCars = new GetParkedCars(this.repository);
	}

	@PostMapping("/checkin")
	public ResponseEntity<String> checkin(@RequestBody ParkedCarInputDTO parkedCar) {
		this.checkin.execute(parkedCar);
		return ResponseEntity.ok("Success!");
	}

	@GetMapping("/parked_cars")
	public ResponseEntity<List<ParkedCarOutputDTO>> getParkedCars() {
		return ResponseEntity.ok(this.getParkedCars.execute());
	}

	@PostMapping("/checkout")
	public ResponseEntity<CheckoutOutPutDTO> checkout(@RequestBody CheckoutInputDTO checkout) {
		return ResponseEntity.ok(this.checkout.execute(checkout));
	}
}
