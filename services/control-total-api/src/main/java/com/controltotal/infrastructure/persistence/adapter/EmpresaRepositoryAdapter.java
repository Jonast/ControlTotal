package com.controltotal.infrastructure.persistence.adapter;

import com.controltotal.domain.model.Empresa;
import com.controltotal.domain.repository.EmpresaRepository;
import com.controltotal.infrastructure.persistence.mapper.EmpresaMapper;
import com.controltotal.infrastructure.persistence.repository.SpringDataEmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EmpresaRepositoryAdapter implements EmpresaRepository {

    private final SpringDataEmpresaRepository empresaRepository;

    private final EmpresaMapper mapper;

    @Override
    public Empresa save(Empresa empresa){
        return mapper.toDomain(
                empresaRepository.save(
                        mapper.toEntity(empresa)
                )
        );
    }
    @Override
    public Optional<Empresa> findById(UUID id){
        return empresaRepository.findById(id)
                .map(mapper::toDomain);
    }
    @Override
    public Optional<Empresa> findByRut(String rut){
        return empresaRepository.findByRut(rut)
                .map(mapper::toDomain);
    }

    @Override
    public List<Empresa> findAll() {
        return empresaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public boolean existsByRut(String rut) {
        return empresaRepository.existsByRut(rut);
    }

    @Override
    public void deleteById(UUID id){
        empresaRepository.deleteById(id);
    }
}
