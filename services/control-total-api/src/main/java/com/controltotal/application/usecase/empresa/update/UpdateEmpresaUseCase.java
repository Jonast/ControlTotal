package com.controltotal.application.usecase.empresa.update;

import com.controltotal.application.dto.request.UpdateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;

import java.util.UUID;

public interface UpdateEmpresaUseCase {

    EmpresaResponse execute(UUID id, UpdateEmpresaRequest request);
}
