package com.darlanso.hexagonal_architecture.application.usecase;
import com.darlanso.hexagonal_architecture.adapters.input.web.dto.ParkedCarInputDTO;
import com.darlanso.hexagonal_architecture.domain.model.ParkedCar;
import com.darlanso.hexagonal_architecture.domain.port.ParkedCarRepository;

import java.time.OffsetDateTime;

import java.util.Date;

public class Checkin {

	protected ParkedCarRepository parkedCarRepository;

	public Checkin(ParkedCarRepository parkedCarRepository) {
		this.parkedCarRepository = parkedCarRepository;
	}

	public void execute(ParkedCarInputDTO parkedCar) {
		Date checkinDate = Date.from(
				OffsetDateTime.parse(parkedCar.getCheckinDate()).toInstant()
		);
		this.parkedCarRepository.save(new ParkedCar(parkedCar.getPlate(), checkinDate));
	}
}
