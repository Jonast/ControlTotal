package com.controltotal.application.usecase.sucursal.get;

import com.controltotal.application.dto.response.SucursalResponse;

import java.util.UUID;

public interface GetSucursalUseCase {

    SucursalResponse execute(UUID id);

}