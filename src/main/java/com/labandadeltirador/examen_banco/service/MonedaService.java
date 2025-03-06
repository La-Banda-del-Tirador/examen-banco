package com.labandadeltirador.examen_banco.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.labandadeltirador.examen_banco.Models.Moneda;
import com.labandadeltirador.examen_banco.dto.MonedaDTO;
import com.labandadeltirador.examen_banco.repository.MonedaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonedaService {

    @Autowired
    private MonedaRepository monedaRepository;

    public List<MonedaDTO> listarMonedas() {
        return monedaRepository.findAll()
                .stream()
                .map(moneda -> new MonedaDTO(moneda.getId(), moneda.getNombre()))
                .collect(Collectors.toList());
    }

    public MonedaDTO obtenerPorId(String id) {
        return monedaRepository.findById(id)
                .map(moneda -> new MonedaDTO(moneda.getId(), moneda.getNombre()))
                .orElse(null);
    }

    public MonedaDTO crearMoneda(MonedaDTO dto) {
        Moneda moneda = new Moneda(dto.getId(), dto.getNombre());
        moneda = monedaRepository.save(moneda);
        return new MonedaDTO(moneda.getId(), moneda.getNombre());
    }

    public void eliminarMoneda(String id) {
        monedaRepository.deleteById(id);
    }
}
