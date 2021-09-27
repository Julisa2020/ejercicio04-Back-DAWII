package com.empresa.service;

import java.util.List;

import com.empresa.entity.Medicamento;
import com.empresa.repository.MedicamentoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentoServiceImpl implements IMedicamentoService {

    @Autowired
    private MedicamentoRepository medicamentoRepository;

    @Override
    public List<Medicamento> listarMedicamentos() {
        List<Medicamento> medicamento = medicamentoRepository.findAll();
        return medicamento;
    }

    @Override
    public Medicamento buscarMedicamentoXid(Integer id) {
        return medicamentoRepository.findById(id).orElse(null);
    }

    @Override
    public Medicamento guardarMedicamento(Medicamento medicamento) {
        return medicamentoRepository.save(medicamento);
    }

    @Override
    public void eliminarMedicamentoXid(Integer id) {
        medicamentoRepository.deleteById(id);
    }

}
