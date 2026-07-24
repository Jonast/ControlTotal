package com.controltotal.infrastructure.controller;

import com.controltotal.application.dto.request.CreateSucursalRequest;
import com.controltotal.application.dto.request.UpdateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.application.usecase.sucursal.create.CreateSucursalUseCase;
import com.controltotal.application.usecase.sucursal.delete.DeleteSucursalUseCase;
import com.controltotal.application.usecase.sucursal.get.GetSucursalByIdUseCase;
import com.controltotal.application.usecase.sucursal.list.ListSucursalUseCase;
import com.controltotal.application.usecase.sucursal.update.UpdateSucursalUseCase;
import com.controltotal.shared.response.ApiResponse;
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
        name = "Sucursales",
        description = "Administración de sucursales del sistema"
)
@RestController
@RequestMapping("/api/v1/sucursales")
@RequiredArgsConstructor
public class SucursalController {

    private final CreateSucursalUseCase createSucursalUseCase;
    private final ListSucursalUseCase listSucursalUseCase;
    private final UpdateSucursalUseCase updateSucursalUseCase;
    private final GetSucursalByIdUseCase getSucursalByIdUseCase;
    private final DeleteSucursalUseCase deleteSucursalUseCase;

    @Operation(
            summary = "Crear sucursal",
            description = "Registra una nueva sucursal en el sistema."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "Sucursal creada correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "400",
                    description = "Datos de entrada inválidos"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "Ya existe una sucursal con el mismo código para la empresa"
            )
    })
    @PostMapping
    public ResponseEntity<ApiResponse<SucursalResponse>> create(
            @Valid
            @RequestBody
            CreateSucursalRequest request
    ) {

        SucursalResponse response =
                createSucursalUseCase.execute(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Sucursal creada correctamente",
                                response
                        )
                );

    }

    @Operation(
            summary = "Listar sucursales",
            description = "Obtiene todas las sucursales registradas."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Sucursales obtenidas correctamente"
            )
    })
    @GetMapping
    public ResponseEntity<ApiResponse<List<SucursalResponse>>> list() {

        List<SucursalResponse> response =
                listSucursalUseCase.execute();

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Sucursales obtenidas correctamente",
                        response
                )
        );

    }

    @Operation(
            summary = "Actualizar sucursal",
            description = "Actualiza la información de una sucursal."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Sucursal actualizada correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Sucursal no encontrada"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "409",
                    description = "Ya existe una sucursal con el mismo código para la empresa"
            )
    })
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SucursalResponse>> update(

            @PathVariable
            UUID id,

            @Valid
            @RequestBody
            UpdateSucursalRequest request

    ) {

        SucursalResponse response =
                updateSucursalUseCase.execute(id, request);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Sucursal actualizada correctamente",
                        response
                )
        );

    }

    @Operation(
            summary = "Obtener sucursal por id",
            description = "Obtiene la información de una sucursal."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Sucursal obtenida correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Sucursal no encontrada"
            )
    })
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SucursalResponse>> getById(
            @PathVariable UUID id
    ) {

        SucursalResponse response =
                getSucursalByIdUseCase.execute(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Sucursal obtenida correctamente",
                        response
                )
        );

    }

    @Operation(
            summary = "Eliminar sucursal",
            description = "Elimina una sucursal del sistema."
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
                    description = "Sucursal eliminada correctamente"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "404",
                    description = "Sucursal no encontrada"
            )
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(
            @PathVariable UUID id
    ) {

        deleteSucursalUseCase.execute(id);

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Sucursal eliminada correctamente",
                        null
                )
        );

    }

}