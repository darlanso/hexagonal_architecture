package com.darlanso.hexagonal_architecture.domain.port;

import com.darlanso.hexagonal_architecture.domain.model.ParkedCar;

import java.util.List;

public interface ParkedCarRepository {
    void save(ParkedCar parkedCar);
    void update(ParkedCar parkedCar);
    List<ParkedCar> list();
    ParkedCar get(String plate);
}
