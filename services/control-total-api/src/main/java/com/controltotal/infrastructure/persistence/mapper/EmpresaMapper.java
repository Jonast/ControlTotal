package com.controltotal.infrastructure.persistence.mapper;

import com.controltotal.domain.model.Empresa;
import com.controltotal.infrastructure.persistence.entity.EmpresaEntity;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {

    Empresa toDomain(EmpresaEntity entity);

    EmpresaEntity toEntity(Empresa empresa);
}
