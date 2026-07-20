package com.controltotal.application.usecase.empresa.get;

import com.controltotal.application.dto.response.EmpresaResponse;

import java.util.UUID;

public interface GetEmpresaByIdUseCase {

    EmpresaResponse execute(UUID id);

}