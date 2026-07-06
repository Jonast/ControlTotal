package com.controltotal.application.dto.response;

import java.time.LocalDateTime;
import java.util.UUID;

public record EmpresaResponse(
        UUID id,
        String nombreComercial,
        String razonSocial,
        String rut,
        String email,
        String telefono,
        String logo,
        Boolean activo,
        LocalDateTime createdAt
) {

}
