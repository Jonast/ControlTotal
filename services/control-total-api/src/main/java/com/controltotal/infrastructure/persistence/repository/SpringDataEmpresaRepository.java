package com.controltotal.infrastructure.persistence.repository;

import com.controltotal.infrastructure.persistence.entity.EmpresaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataEmpresaRepository extends JpaRepository<EmpresaEntity, UUID>{
    Optional<EmpresaEntity> findByRut(String rut);

    boolean existsByRut(String rut);
}
