package com.controltotal.application.mapper;

import com.controltotal.application.dto.request.CreateSucursalRequest;
import com.controltotal.application.dto.request.UpdateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.domain.model.Sucursal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SucursalApplicationMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Sucursal toDomain(CreateSucursalRequest request);

    SucursalResponse toResponseSucursal(Sucursal sucursal);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "activo", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    void updateDomain(
            @MappingTarget Sucursal sucursal,
            UpdateSucursalRequest request
    );
}