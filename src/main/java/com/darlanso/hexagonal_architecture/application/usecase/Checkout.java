package com.darlanso.hexagonal_architecture.application.usecase;

import com.darlanso.hexagonal_architecture.adapters.input.web.dto.CheckoutInputDTO;
import com.darlanso.hexagonal_architecture.adapters.input.web.dto.CheckoutOutPutDTO;
import com.darlanso.hexagonal_architecture.domain.model.ParkedCar;
import com.darlanso.hexagonal_architecture.domain.port.ParkedCarRepository;

public class Checkout {
	protected ParkedCarRepository parkedCarRepository;

	public Checkout(ParkedCarRepository parkedCarRepository) {
		this.parkedCarRepository = parkedCarRepository;
	}

	public CheckoutOutPutDTO execute(CheckoutInputDTO checkout) {
		ParkedCar parkedCar = this.parkedCarRepository.get(checkout.getPlate());
		parkedCar.checkout(checkout.getCheckoutDate());
		this.parkedCarRepository.update(parkedCar);
		return new CheckoutOutPutDTO(parkedCar.getPrice(), parkedCar.getDiff());
	}
}
