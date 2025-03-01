package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cuenta_id", nullable = false)
    private Cuenta cuenta;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime fecha;

    @NotNull
    @Size(max = 3)
    @Column(length = 3, nullable = false)
    private String tipo;

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal importe;

    @Column(precision = 10, scale = 4)
    private BigDecimal tipoCambio;

    @Size(max = 100)
    @Column(length = 100)
    private String glosa;

    public Movimiento(Cuenta cuenta, LocalDateTime fecha, String tipo, BigDecimal importe, 
                     BigDecimal tipoCambio, String glosa) {
        if (cuenta == null || fecha == null || tipo == null || importe == null) {
            throw new IllegalArgumentException("Los campos cuenta, fecha, tipo e importe no pueden ser null");
        }
        
        this.cuenta = cuenta;
        this.fecha = fecha;
        this.tipo = tipo;
        this.importe = importe;
        this.tipoCambio = tipoCambio;
        this.glosa = glosa;
    }
}