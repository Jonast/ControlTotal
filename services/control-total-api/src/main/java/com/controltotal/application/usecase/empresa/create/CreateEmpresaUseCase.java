package com.controltotal.application.usecase.empresa.create;

import com.controltotal.application.dto.request.CreateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;

public interface CreateEmpresaUseCase {

    EmpresaResponse execute(CreateEmpresaRequest request);

}