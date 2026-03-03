package com.darlanso.hexagonal_architecture.application.usecase;

import com.darlanso.hexagonal_architecture.adapters.input.web.dto.ParkedCarOutputDTO;
import com.darlanso.hexagonal_architecture.domain.port.ParkedCarRepository;

import java.util.List;

public class GetParkedCars {
	protected ParkedCarRepository parkedCarRepository;
	protected List<ParkedCarOutputDTO> parkedCarsList;

	public GetParkedCars(ParkedCarRepository parkedCarRepository) {
		this.parkedCarRepository = parkedCarRepository;
	}

	public List<ParkedCarOutputDTO> execute() {
		this.parkedCarsList = this.parkedCarRepository.list().stream().map(parkedCar -> new ParkedCarOutputDTO(parkedCar.getPlate(), parkedCar.getCheckinDate())).toList();
		return this.parkedCarsList;
	}
}
