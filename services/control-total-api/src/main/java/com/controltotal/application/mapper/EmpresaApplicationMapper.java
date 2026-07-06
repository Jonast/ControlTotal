package com.controltotal.application.mapper;

import com.controltotal.application.dto.request.CreateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.domain.model.Empresa;
import org.mapstruct.Mapper;
@Mapper(componentModel = "spring")
public interface EmpresaApplicationMapper {
    Empresa toDomain(CreateEmpresaRequest request);

    EmpresaResponse toResponseEmpresa(Empresa empresa);
}
