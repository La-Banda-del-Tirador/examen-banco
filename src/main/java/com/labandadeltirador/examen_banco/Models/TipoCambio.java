package com.labandadeltirador.examen_banco.Models;

import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Table(name = "tipo_cambio")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TipoCambio {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "moneda_origen", nullable = false)
    private Moneda monedaOrigen;

    @ManyToOne
    @JoinColumn(name = "moneda_destino", nullable = false)
    private Moneda monedaDestino;

    @Column(precision = 15, scale = 5, nullable = false)
    private BigDecimal tasaCambio;

    @Column(nullable = false)
    private LocalDateTime fecha;
}
