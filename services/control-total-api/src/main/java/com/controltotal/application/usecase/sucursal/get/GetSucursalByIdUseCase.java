package com.controltotal.application.usecase.sucursal.get;

import com.controltotal.application.dto.response.SucursalResponse;

import java.util.UUID;

public interface GetSucursalByIdUseCase {

    SucursalResponse execute(UUID id);

}