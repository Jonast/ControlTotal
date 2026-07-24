package com.controltotal.application.usecase.sucursal.update;

import com.controltotal.application.dto.request.UpdateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;

import java.util.UUID;

public interface UpdateSucursalUseCase {

    SucursalResponse execute(UUID id, UpdateSucursalRequest request);

}