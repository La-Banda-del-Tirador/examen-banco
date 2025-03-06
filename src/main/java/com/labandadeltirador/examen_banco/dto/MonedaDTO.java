package com.labandadeltirador.examen_banco.dto;
import lombok.*;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MonedaDTO {
    private String id;      // "BOL" o "USD"
    private String nombre;  // "Bolivianos" o "Dólares"
}
