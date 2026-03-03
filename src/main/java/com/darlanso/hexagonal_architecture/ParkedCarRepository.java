package com.darlanso.hexagonal_architecture;

import java.util.List;

public interface ParkedCarRepository {
    void save(ParkedCar parkedCar);
    void update(ParkedCar parkedCar);
    List<ParkedCar> list();
    ParkedCar get(String plate);
}
