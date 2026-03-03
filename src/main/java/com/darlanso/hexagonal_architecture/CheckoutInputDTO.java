package com.darlanso.hexagonal_architecture;

public class CheckoutInputDTO {
	private String plate;
	private String checkoutDate;

	public CheckoutInputDTO(String plate, String checkoutDate) {
		this.plate = plate;
		this.checkoutDate = checkoutDate;
	}

	public String getPlate() {
		return plate;
	}

	public String getCheckoutDate() {
		return checkoutDate;
	}
}
