package com.labandadeltirador.examen_banco.Models;

import java.math.BigDecimal;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
@NoArgsConstructor
public class Cuenta {
    @Id
    @Column(length = 14, nullable = false, unique = true)
    private String nroCuenta; // Número de cuenta

    @Column(length = 3, nullable = false)
    private String tipo; // Tipo de cuenta (AHO/CTE)

    @Column(name = "moneda_id", length = 3, nullable = false)
    private String moneda; // Identificador de moneda (BOL/USD)

    @Column(length = 40, nullable = false)
    private String nombre; // Nombre de la cuenta

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal saldo; // Saldo actual

}