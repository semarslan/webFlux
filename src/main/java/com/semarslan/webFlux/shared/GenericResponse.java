package com.semarslan.webFlux.shared;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor //constructor with lombok
public class GenericResponse {
    private String message;


}
