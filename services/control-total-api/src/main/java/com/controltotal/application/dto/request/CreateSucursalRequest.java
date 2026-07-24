package com.controltotal.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record CreateSucursalRequest(

        @Schema(
                description = "Identificador de la empresa propietaria de la sucursal",
                example = "550e8400-e29b-41d4-a716-446655440000"
        )
        @NotNull(message = "La empresa es obligatoria.")
        UUID empresaId,

        @Schema(
                description = "Código único de la sucursal dentro de la empresa",
                example = "MAT"
        )
        @NotBlank(message = "El código es obligatorio.")
        @Size(max = 20, message = "El código no puede superar los 20 caracteres.")
        String codigo,

        @Schema(
                description = "Nombre de la sucursal",
                example = "Casa Matriz"
        )
        @NotBlank(message = "El nombre es obligatorio.")
        @Size(max = 150, message = "El nombre no puede superar los 150 caracteres.")
        String nombre,

        @Schema(
                description = "Dirección de la sucursal",
                example = "Av. Apoquindo 1234"
        )
        @Size(max = 255, message = "La dirección no puede superar los 255 caracteres.")
        String direccion,

        @Schema(
                description = "Comuna donde se encuentra la sucursal",
                example = "Las Condes"
        )
        @Size(max = 100, message = "La comuna no puede superar los 100 caracteres.")
        String comuna,

        @Schema(
                description = "Teléfono de contacto",
                example = "+56911111111"
        )
        @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres.")
        String telefono,

        @Schema(
                description = "Correo electrónico",
                example = "matriz@controltotal.cl"
        )
        @Email(message = "El correo electrónico no es válido.")
        @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres.")
        String email

) {
}