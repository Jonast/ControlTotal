package com.controltotal.infrastructure.controller;

import com.controltotal.application.dto.request.CreateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.application.usecase.empresa.create.CreateEmpresaUseCase;
import com.controltotal.application.usecase.empresa.list.ListEmpresasUseCase;
import com.controltotal.shared.response.ApiResponse;
import com.controltotal.application.usecase.empresa.update.UpdateEmpresaUseCase;
import com.controltotal.application.dto.request.UpdateEmpresaRequest;
import com.controltotal.application.usecase.empresa.get.GetEmpresaByIdUseCase;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(
        name = "Empresas",
        description = "Administración de empresas del sistema"
)
@RestController
@RequestMapping("/api/v1/empresas")
@RequiredArgsConstructor
public class EmpresaController {

    private final CreateEmpresaUseCase createEmpresaUseCase;
    private final ListEmpresasUseCase listEmpresasUseCase;
    private final UpdateEmpresaUseCase updateEmpresaUseCase;
    private final GetEmpresaByIdUseCase getEmpresaByIdUseCase;

    @Operation(
            summary = "Crear empresa",
            description = "Registra una nueva empresa en el sistema."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "Empresa creada correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "Ya existe una empresa con el mismo RUT"
            )
    })
    @PostMapping
    public ResponseEntity<ApiResponse<EmpresaResponse>> create(
            @Valid @RequestBody CreateEmpresaRequest request) {

        EmpresaResponse response = createEmpresaUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success(
                        "Empresa creada correctamente",
                        response
                ));
    }

    @Operation(
            summary = "Listar empresas",
            description = "Obtiene todas las empresas registradas."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Empresas obtenidas correctamente"
            )
    })
    @GetMapping
    public ResponseEntity<ApiResponse<List<EmpresaResponse>>> list() {

        List<EmpresaResponse> response = listEmpresasUseCase.execute();

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Empresas obtenidas correctamente",
                        response
                )
        );
    }

    @Operation(
            summary = "Actualizar empresa",
            description = "Actualiza la información de una empresa."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Empresa actualizada correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Empresa no encontrada"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "Ya existe una empresa con el mismo RUT"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmpresaResponse>> update(

            @PathVariable UUID id,

            @Valid
            @RequestBody
            UpdateEmpresaRequest request

    ) {

        EmpresaResponse response =
                updateEmpresaUseCase.execute(id, request);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Empresa actualizada correctamente",
                        response
                )
        );

    }

    @Operation(
            summary = "Obtener empresa por id",
            description = "Obtiene la información de una empresa."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Empresa obtenida correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Empresa no encontrada"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmpresaResponse>> getById(
            @PathVariable UUID id
    ) {

        EmpresaResponse response =
                getEmpresaByIdUseCase.execute(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Empresa obtenida correctamente",
                        response
                )
        );

    }
}