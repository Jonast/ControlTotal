package com.controltotal.application.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UpdateEmpresaRequest(

        @Schema(
                description = "Nombre comercial de la empresa",
                example = "Control Total"
        )
        @NotBlank(message = "El nombre comercial es obligatorio.")
        @Size(max = 150, message = "El nombre comercial no puede superar los 150 caracteres.")
        String nombreComercial,

        @Schema(
                description = "Razón social",
                example = "Control Total SPA"
        )
        @NotBlank(message = "La razón social es obligatoria.")
        @Size(max = 200, message = "La razón social no puede superar los 200 caracteres.")
        String razonSocial,

        @Schema(
                description = "RUT de la empresa",
                example = "76.123.456-7"
        )
        @NotBlank(message = "El RUT es obligatorio.")
        @Size(max = 20, message = "El RUT no puede superar los 20 caracteres.")
        String rut,

        @Schema(
                description = "Correo electrónico",
                example = "contacto@controltotal.cl"
        )
        @Email(message = "El correo electrónico no es válido.")
        @Size(max = 150, message = "El correo electrónico no puede superar los 150 caracteres.")
        String email,

        @Schema(
                description = "Teléfono",
                example = "+56911111111"
        )
        @Size(max = 30, message = "El teléfono no puede superar los 30 caracteres.")
        String telefono,

        @Schema(
                description = "Logo",
                example = "logo.png"
        )
        @Size(max = 255, message = "El logo no puede superar los 255 caracteres.")
        String logo

) {
}