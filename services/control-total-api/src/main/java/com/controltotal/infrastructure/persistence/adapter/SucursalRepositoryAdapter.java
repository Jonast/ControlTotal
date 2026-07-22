package com.controltotal.infrastructure.persistence.adapter;

import com.controltotal.domain.model.Sucursal;
import com.controltotal.domain.repository.SucursalRepository;
import com.controltotal.infrastructure.persistence.mapper.SucursalMapper;
import com.controltotal.infrastructure.persistence.repository.SpringDataSucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class SucursalRepositoryAdapter implements SucursalRepository {

    private final SpringDataSucursalRepository sucursalRepository;

    private final SucursalMapper mapper;

    @Override
    public Sucursal save(Sucursal sucursal) {
        return mapper.toDomain(
                sucursalRepository.save(
                        mapper.toEntity(sucursal)
                )
        );
    }

    @Override
    public Optional<Sucursal> findById(UUID id) {
        return sucursalRepository.findById(id)
                .map(mapper::toDomain);
    }

    @Override
    public Optional<Sucursal> findByCodigoAndEmpresaId(String codigo, UUID empresaId) {
        return sucursalRepository.findByCodigoAndEmpresa_Id(codigo, empresaId)
                .map(mapper::toDomain);
    }

    @Override
    public List<Sucursal> findAll() {
        return sucursalRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByCodigoAndEmpresaId(String codigo, UUID empresaId) {
        return sucursalRepository.existsByCodigoAndEmpresa_Id(codigo, empresaId);
    }

    @Override
    public void deleteById(UUID id) {
        sucursalRepository.deleteById(id);
    }

}