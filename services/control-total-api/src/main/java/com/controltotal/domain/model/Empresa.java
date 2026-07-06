package com.controltotal.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.UUID;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Empresa {

    private UUID id;
    private String nombreComercial;
    private String razonSocial;
    private String rut;
    private String email;
    private String telefono;
    private String logo;
    private Boolean activo;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

