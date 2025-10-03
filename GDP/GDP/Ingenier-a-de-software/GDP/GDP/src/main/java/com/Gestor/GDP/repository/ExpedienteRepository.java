package com.gestor.gdp.repository;

import com.gestor.gdp.entity.Expediente;
import com.gestor.gdp.entity.Expediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpedienteRepository extends JpaRepository<Expediente, Long> {
}
