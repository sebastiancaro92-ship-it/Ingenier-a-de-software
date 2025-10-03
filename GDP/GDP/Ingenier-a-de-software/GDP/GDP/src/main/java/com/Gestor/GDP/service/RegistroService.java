package com.gestor.gdp.service;

import com.gestor.gdp.entity.Expediente;
import com.gestor.gdp.entity.Documento;

public interface RegistroService {
    Expediente guardarExpediente(Expediente expediente);
    Documento guardarDocumento(Documento documento);
}
