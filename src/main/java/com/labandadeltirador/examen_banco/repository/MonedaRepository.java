package com.labandadeltirador.examen_banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.labandadeltirador.examen_banco.Models.Moneda;
@Repository
public interface MonedaRepository extends JpaRepository<Moneda, String> {
}
