package com.controltotal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sucursal {

    private UUID id;

    private UUID empresaId;

    private String codigo;

    private String nombre;

    private String direccion;

    private String comuna;

    private String telefono;

    private String email;

    private Boolean activo;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}