package com.labandadeltirador.examen_banco.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "moneda")
@Getter
@Setter
@NoArgsConstructor
public class Moneda {
    @Id
    @Column(length = 3, nullable = false)
    private String codigo;

    @NotNull
    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal valor;

    @NotNull
    @Column(length = 40, nullable = false)
    private String nombre;

    @Size(max = 1)
    @Column(length = 1)
    private String simbolo;
    
    @Column(nullable = false)
    private boolean activo;

    @OneToMany(mappedBy = "moneda")
    private List<Cuenta> cuentas = new ArrayList<>();

    @OneToMany(mappedBy = "monedaOrigen")
    private List<TipoCambio> tipoCambiosOrigen = new ArrayList<>();

    @OneToMany(mappedBy = "monedaDestino")
    private List<TipoCambio> tipoCambiosDestino = new ArrayList<>();
    
    public Moneda(String codigo, BigDecimal valor, String nombre, String simbolo) {
        if (codigo == null || valor == null || nombre == null) {
            throw new IllegalArgumentException("Código, valor y nombre no pueden ser null");
        }
        
        this.codigo = codigo;
        this.valor = valor;
        this.nombre = nombre;
        this.simbolo = simbolo;
        this.activo = true;
    }
}