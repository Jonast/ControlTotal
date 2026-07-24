package com.controltotal.infrastructure.persistence.repository;

import com.controltotal.infrastructure.persistence.entity.SucursalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface SpringDataSucursalRepository extends JpaRepository<SucursalEntity, UUID> {

    Optional<SucursalEntity> findByCodigoAndEmpresa_Id(String codigo, UUID empresaId);

    boolean existsByCodigoAndEmpresa_Id(String codigo, UUID empresaId);

}