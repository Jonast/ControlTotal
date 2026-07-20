package com.controltotal.application.mapper;

import com.controltotal.application.dto.request.CreateEmpresaRequest;
import com.controltotal.application.dto.request.UpdateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.domain.model.Empresa;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
@Mapper(componentModel = "spring")
public interface EmpresaApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Empresa toDomain(CreateEmpresaRequest request);

    EmpresaResponse toResponseEmpresa(Empresa empresa);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateDomain(
            @MappingTarget Empresa empresa,
            UpdateEmpresaRequest request
    );
}
