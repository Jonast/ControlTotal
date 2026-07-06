package com.controltotal.domain.repository;

import com.controltotal.domain.model.Empresa;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EmpresaRepository {

    Empresa save(Empresa empresa);
    Optional<Empresa> findById(UUID id);
    Optional<Empresa> findByRut(String rut);
    List<Empresa> findAll();
    void deleteById(UUID id);

    boolean existsByRut(String rut);

}
