package com.darlanso.hexagonal_architecture.adapters.output.repository;

import com.darlanso.hexagonal_architecture.domain.model.ParkedCar;
import com.darlanso.hexagonal_architecture.domain.port.ParkedCarRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkedCarMemoryRepository implements ParkedCarRepository {
	private List<ParkedCar> parkedCars;
	private Optional<ParkedCar> existingParkedCar;

	public ParkedCarMemoryRepository() {
		this.parkedCars = new ArrayList<>();
	}

	@Override
	public void save(ParkedCar parkedCar) {
		this.parkedCars.add(parkedCar);
		System.out.println("Save " + parkedCar.getPlate());
	}

	@Override
	public void update(ParkedCar parkedCar) {
		this.existingParkedCar = this.parkedCars.stream().filter(car -> car.getPlate().equals(parkedCar.getPlate())).findFirst();
		if (this.existingParkedCar.isEmpty()) {
			System.out.println("No found ParkedCar " + parkedCar.getPlate());
			return;
		}
		this.existingParkedCar.get().setCheckoutDate(parkedCar.getCheckoutDate());
	}

	@Override
	public List<ParkedCar> list() {
		return this.parkedCars.stream().filter(parkedCarEntry -> parkedCarEntry.getCheckoutDate() == null).toList();
	}

	@Override
	public ParkedCar get(String plate) {
		this.existingParkedCar = this.parkedCars.stream().filter(car -> car.getPlate().equals(plate)).findFirst();
		if (this.existingParkedCar.isEmpty()) {
			throw new RuntimeException("No found ParkedCar " + plate);
		}
		return this.existingParkedCar.get();
	}
}
