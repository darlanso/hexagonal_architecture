package com.darlanso.hexagonal_architecture;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record ParkedCarOutputDTO(String plate,
																 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssXXX") Date checkinDate) {

}
