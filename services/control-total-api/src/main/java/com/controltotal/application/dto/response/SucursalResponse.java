package com.controltotal.application.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.UUID;

public record SucursalResponse(

        @Schema(
                description = "Identificador de la sucursal",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        UUID id,

        @Schema(
                description = "Identificador de la empresa",
                example = "550e8400-e29b-41d4-a716-446655440001"
        )
        UUID empresaId,

        @Schema(
                description = "Código de la sucursal",
                example = "MAT"
        )
        String codigo,

        @Schema(
                description = "Nombre de la sucursal",
                example = "Casa Matriz"
        )
        String nombre,

        @Schema(
                description = "Dirección"
        )
        String direccion,

        @Schema(
                description = "Comuna"
        )
        String comuna,

        @Schema(
                description = "Teléfono"
        )
        String telefono,

        @Schema(
                description = "Correo electrónico"
        )
        String email,

        @Schema(
                description = "Estado"
        )
        Boolean activo,

        @Schema(
                description = "Fecha de creación"
        )
        LocalDateTime createdAt

) {
}