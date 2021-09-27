package com.empresa.service;

import java.util.List;
import com.empresa.entity.Medicamento;

public interface IMedicamentoService {
    public List<Medicamento> listarMedicamentos();

    public Medicamento buscarMedicamentoXid(Integer id);

    public Medicamento guardarMedicamento(Medicamento medicamento);

    public void eliminarMedicamentoXid(Integer id);
}
