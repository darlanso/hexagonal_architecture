package com.darlanso.hexagonal_architecture.adapters.input.web.dto;

public class ParkedCarInputDTO {
    private String plate;
    private String checkinDate;

    public ParkedCarInputDTO(String plate, String checkinDate){
        this.plate = plate;
        this.checkinDate = checkinDate;
    }

    public String getPlate() {
        return plate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }
}
