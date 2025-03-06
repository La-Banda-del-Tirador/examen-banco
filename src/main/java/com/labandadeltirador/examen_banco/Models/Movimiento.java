package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movimiento")
@Getter
@Setter
@NoArgsConstructor
public class Movimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Identificador único para la transacción

    @ManyToOne
    @JoinColumn(name = "nro_cuenta", nullable = false)
    private Cuenta cuenta; // Relación con la cuenta

    @Column(nullable = false)
    private LocalDateTime fecha; // Fecha de operación

    @Column(length = 1, nullable = false)
    private String tipo; // Tipo de operación (D - Débito, A - Abono)

    @Column(precision = 12, scale = 2, nullable = false)
    private BigDecimal importe; // Importe de la operación

    @Column(precision = 15, scale = 5, nullable = false)
    private BigDecimal tipoCambio; // Tipo de cambio de la operación

    @Column(length = 25)
    private String glosa; // Glosa de la transacción
}