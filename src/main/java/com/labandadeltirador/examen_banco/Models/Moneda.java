package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.*;

@Entity
@Table(name = "moneda")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Moneda {

    @Id
    @Column(length = 3, nullable = false)
    private String id; // "BOL" o "USD"

    @Column(length = 20, nullable = false, unique = true)
    private String nombre;
}
