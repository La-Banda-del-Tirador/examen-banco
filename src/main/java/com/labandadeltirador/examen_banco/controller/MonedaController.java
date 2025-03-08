package com.labandadeltirador.examen_banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.labandadeltirador.examen_banco.Models.Moneda;
import com.labandadeltirador.examen_banco.dto.MonedaDTO;
import com.labandadeltirador.examen_banco.service.MonedaService;

import java.util.List;

@RestController
@RequestMapping("/api/monedas")
public class MonedaController {

    @Autowired
    private MonedaService monedaService;

    @GetMapping
    public List<MonedaDTO> listarMonedas() {
        return monedaService.listarMonedas();
    }

    @GetMapping("/{id}")
    public MonedaDTO obtenerMoneda(@PathVariable String id) {
        return monedaService.obtenerPorId(id);
    }

    @PostMapping
    public MonedaDTO crearMoneda(@RequestBody MonedaDTO dto) {
        return monedaService.crearMoneda(dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarMoneda(@PathVariable String id) {
        monedaService.eliminarMoneda(id);
    }
}
