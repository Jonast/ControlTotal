package com.controltotal.application.usecase.sucursal.list;

import com.controltotal.application.dto.response.SucursalResponse;

import java.util.List;

public interface ListSucursalUseCase {

    List<SucursalResponse> execute();

}