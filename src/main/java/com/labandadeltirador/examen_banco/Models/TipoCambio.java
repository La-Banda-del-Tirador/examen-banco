package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.JoinColumn;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipoCambio")
@Getter
@Setter
@NoArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moneda_origen_id", nullable = false)
    private Moneda monedaOrigen;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "moneda_destino_id", nullable = false)
    private Moneda monedaDestino;

    @NotNull
    @Column(precision = 10, scale = 4, nullable = false)
    private BigDecimal tasaCambio;

    @NotNull
    @Column(nullable = false)
    private LocalDate fecha;

    public TipoCambio(Moneda monedaOrigen, Moneda monedaDestino, BigDecimal tasaCambio, LocalDate fecha) {
        if (monedaOrigen == null || monedaDestino == null || tasaCambio == null || fecha == null) {
            throw new IllegalArgumentException("Ningún campo puede ser null");
        }
        
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.tasaCambio = tasaCambio;
        this.fecha = fecha;
    }
}