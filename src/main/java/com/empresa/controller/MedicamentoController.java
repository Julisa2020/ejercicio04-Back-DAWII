package com.empresa.controller;

import java.util.List;

import com.empresa.entity.Medicamento;
import com.empresa.service.IMedicamentoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class MedicamentoController {
    @Autowired
    private IMedicamentoService medicamentoServicio;

    @GetMapping("/medicamentos")
    public List<Medicamento> listar() {
        return medicamentoServicio.listarMedicamentos();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/medicamento/{id}")
    public Medicamento buscarXid(@PathVariable Integer id) {
        return medicamentoServicio.buscarMedicamentoXid(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/medicamento")
    public Medicamento guardar(@RequestBody Medicamento medicamento) {
        return medicamentoServicio.guardarMedicamento(medicamento);
    }

    @PutMapping("/medicamento/{id}")
    public Medicamento actualizar(@RequestBody Medicamento medicamento, @PathVariable Integer id) {
        Medicamento medicamentoActualizado = medicamentoServicio.buscarMedicamentoXid(id);
        medicamentoActualizado.setLaboratorio(medicamento.getLaboratorio());
        medicamentoActualizado.setNombre(medicamento.getNombre());
        medicamentoActualizado.setPrecio(medicamento.getPrecio());
        medicamentoActualizado.setStock(medicamento.getStock());

        medicamentoServicio.guardarMedicamento(medicamento);
        return medicamentoActualizado;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/medicamento/{id}")
    public void eliminar(@PathVariable Integer id) {
        medicamentoServicio.eliminarMedicamentoXid(id);
    }

}
