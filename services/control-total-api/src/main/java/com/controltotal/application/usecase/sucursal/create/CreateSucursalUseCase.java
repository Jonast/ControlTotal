package com.controltotal.application.usecase.sucursal.create;

import com.controltotal.application.dto.request.CreateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;

public interface CreateSucursalUseCase {

    SucursalResponse execute(CreateSucursalRequest request);

}