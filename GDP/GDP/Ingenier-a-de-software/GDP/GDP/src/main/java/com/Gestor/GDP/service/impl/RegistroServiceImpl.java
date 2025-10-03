package com.gestor.gdp.service.impl;

import com.gestor.gdp.entity.Expediente;
import com.gestor.gdp.entity.Documento;
import com.gestor.gdp.repository.ExpedienteRepository;
import com.gestor.gdp.repository.DocumentoRepository;
import com.gestor.gdp.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroServiceImpl implements RegistroService {

    @Autowired
    private ExpedienteRepository expedienteRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Override
    public Expediente guardarExpediente(Expediente expediente) {
        return expedienteRepository.save(expediente);
    }

    @Override
    public Documento guardarDocumento(Documento documento) {
        return documentoRepository.save(documento);
    }
}
