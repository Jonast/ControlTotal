package com.controltotal.domain.repository;

import com.controltotal.domain.model.Sucursal;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SucursalRepository {

    Sucursal save(Sucursal sucursal);

    Optional<Sucursal> findById(UUID id);

    Optional<Sucursal> findByCodigoAndEmpresaId(String codigo, UUID empresaId);

    List<Sucursal> findAll();

    void deleteById(UUID id);

    boolean existsByCodigoAndEmpresaId(String codigo, UUID empresaId);

}