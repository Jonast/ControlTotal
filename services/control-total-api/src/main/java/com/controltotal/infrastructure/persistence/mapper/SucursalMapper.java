package com.controltotal.infrastructure.persistence.mapper;

import com.controltotal.domain.model.Sucursal;
import com.controltotal.infrastructure.persistence.entity.EmpresaEntity;
import com.controltotal.infrastructure.persistence.entity.SucursalEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.UUID;

@Mapper(componentModel = "spring")
public interface SucursalMapper {

    @Mapping(target = "empresaId", source = "empresa.id")
    Sucursal toDomain(SucursalEntity entity);

    @Mapping(target = "empresa", source = "empresaId")
    SucursalEntity toEntity(Sucursal sucursal);

    default EmpresaEntity map(UUID empresaId) {

        if (empresaId == null) {
            return null;
        }

        EmpresaEntity empresa = new EmpresaEntity();
        empresa.setId(empresaId);

        return empresa;
    }

}