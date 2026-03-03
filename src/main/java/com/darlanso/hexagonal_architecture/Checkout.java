package com.darlanso.hexagonal_architecture;

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
