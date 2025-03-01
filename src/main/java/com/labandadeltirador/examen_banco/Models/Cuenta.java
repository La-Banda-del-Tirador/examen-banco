package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
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
    private String nroCuenta;
    
    @NotNull
    @Size(max = 3)
    @Column(length = 3, nullable = false)
    private String tipo;
    
    @ManyToOne
    @JoinColumn(name = "moneda_id", nullable = false)
    private Moneda moneda;
    
    @NotNull
    @Column(length = 40, nullable = false)
    private String nombre;
    
    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal saldo;
    
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta(String nroCuenta, String tipo, Moneda moneda, String nombre, BigDecimal saldo) {
        if (nroCuenta == null || tipo == null || moneda == null || nombre == null || saldo == null) {
            throw new IllegalArgumentException("Ningún campo puede ser null");
        }
        
        this.nroCuenta = nroCuenta;
        this.tipo = tipo;
        this.moneda = moneda;
        this.nombre = nombre;
        this.saldo = saldo.setScale(2, RoundingMode.HALF_UP);
    }

    public void addMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
        movimiento.setCuenta(this);
    }

    public void removeMovimiento(Movimiento movimiento) {
        movimientos.remove(movimiento);
        movimiento.setCuenta(null);
    }
}