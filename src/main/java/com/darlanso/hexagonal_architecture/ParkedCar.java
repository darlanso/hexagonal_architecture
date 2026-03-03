package com.darlanso.hexagonal_architecture;

import java.time.OffsetDateTime;
import java.util.Date;

public class ParkedCar {
	private String plate;
	private Date checkinDate;
	private Date checkoutDate;
	private Integer diff;
	private Integer price;

	public Date getCheckoutDate() {
		return checkoutDate;
	}

	public void setCheckoutDate(Date checkoutDate) {
		this.checkoutDate = checkoutDate;
	}

	public Date getCheckinDate() {
		return checkinDate;
	}

	public ParkedCar(String plate, Date checkinDate) {
		this.plate = plate;
		this.checkinDate = checkinDate;
	}

	public ParkedCar(Date checkoutDate, Date checkinDate, String plate) {
		this.checkoutDate = checkoutDate;
		this.checkinDate = checkinDate;
		this.plate = plate;
	}

	public void checkout(String checkoutDate) {
		this.checkoutDate =  Date.from(
				OffsetDateTime.parse(checkoutDate).toInstant()
		);

		long diffMillis = this.checkoutDate.getTime() - checkinDate.getTime();
		this.diff = (int) (diffMillis / (1000 * 60 * 60));;
		this.price = this.diff * 10;
	}

	public String getPlate() {
		return plate;
	}

	public Integer getDiff() {
		return diff;
	}

	public Integer getPrice() {
		return price;
	}
}
