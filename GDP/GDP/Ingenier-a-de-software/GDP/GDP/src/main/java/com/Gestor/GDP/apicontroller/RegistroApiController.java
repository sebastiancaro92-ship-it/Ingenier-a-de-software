package com.gestor.gdp.apicontroller;

import com.Gestor.GDP.api.dto.RegistroRequest;
import com.gestor.gdp.entity.Expediente;
import com.gestor.gdp.entity.Documento;
import com.gestor.gdp.service.RegistroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registro")
@CrossOrigin(origins = "*")
public class RegistroApiController {

    @Autowired
    private RegistroService registroService;

@PostMapping
public ResponseEntity<String> registrar(@RequestBody RegistroRequest request) {
    try {
        // 1️⃣ Crear y llenar el expediente
        Expediente expediente = new Expediente();
        expediente.setCodigo_expediente(request.getExpediente().getCodigo_expediente());
        expediente.setNombre_expediente(request.getExpediente().getNombre_expediente());
        expediente.setDependencia(request.getExpediente().getDependencia());
        expediente.setEstado(request.getExpediente().getEstado());
        expediente.setUbicacion_fisica(request.getExpediente().getUbicacion_fisica());
        expediente.setUbicacion_digital(request.getExpediente().getUbicacion_digital());
        expediente.setFecha_creacion(request.getExpediente().getFecha_creacion());
        expediente.setFecha_cierre(request.getExpediente().getFecha_cierre());

        // 2️⃣ Guardar expediente (aquí se valida si ya existe)
        Expediente expedienteGuardado = registroService.guardarExpediente(expediente);

        // 3️⃣ Crear y llenar documento
        Documento documento = new Documento();
        documento.setExpediente(expedienteGuardado);
        documento.setNombre(request.getDocumento().getNombre());
        documento.setTipologia(request.getDocumento().getTipologia());
        documento.setFecha_creacion(request.getDocumento().getFecha_creacion());
        documento.setFecha_incorporacion(request.getDocumento().getFecha_incorporacion());
        documento.setFormato(request.getDocumento().getFormato());
        documento.setTamano_kb(request.getDocumento().getTamano_kb());
        documento.setHash_valor(request.getDocumento().getHash_valor());
        documento.setOrigen(request.getDocumento().getOrigen());
        documento.setVersion(request.getDocumento().getVersion());
        documento.setEstado(request.getDocumento().getEstado());

        // 4️⃣ Guardar documento (también valida duplicado)
        registroService.guardarDocumento(documento);

        return ResponseEntity.ok("Registro guardado correctamente en expediente y documento.");

    } catch (IllegalArgumentException e) {
        // Error controlado (duplicado)
        return ResponseEntity.badRequest().body(e.getMessage());
    } catch (Exception e) {
        // Error inesperado
        return ResponseEntity.internalServerError().body("Error al guardar el registro: " + e.getMessage());
    }
}

