package com.controltotal.application.usecase.sucursal.update;

import com.controltotal.application.dto.request.UpdateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.application.mapper.SucursalApplicationMapper;
import com.controltotal.domain.model.Sucursal;
import com.controltotal.domain.repository.SucursalRepository;
import com.controltotal.shared.exception.BusinessException;
import com.controltotal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateSucursalUseCaseImpl implements UpdateSucursalUseCase {

    private final SucursalRepository sucursalRepository;

    private final SucursalApplicationMapper sucursalApplicationMapper;

    @Override
    public SucursalResponse execute(
            UUID id,
            UpdateSucursalRequest request
    ) {

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe una sucursal con id: " + id
                        )
                );

        validarCodigo(sucursal, request);

        sucursalApplicationMapper.updateDomain(
                sucursal,
                request
        );

        Sucursal sucursalActualizada =
                sucursalRepository.save(sucursal);

        return sucursalApplicationMapper.toResponseSucursal(
                sucursalActualizada
        );

    }

    private void validarCodigo(
            Sucursal sucursal,
            UpdateSucursalRequest request
    ) {

        if ((!sucursal.getCodigo().equals(request.codigo())
                || !sucursal.getEmpresaId().equals(request.empresaId()))
                && sucursalRepository.existsByCodigoAndEmpresaId(
                request.codigo(),
                request.empresaId()
        )) {

            throw new BusinessException(
                    "Ya existe una sucursal registrada con el código: "
                            + request.codigo()
            );

        }

    }

}