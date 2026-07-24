package com.controltotal.application.usecase.sucursal.create;

import com.controltotal.application.dto.request.CreateSucursalRequest;
import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.application.mapper.SucursalApplicationMapper;
import com.controltotal.domain.model.Sucursal;
import com.controltotal.domain.repository.SucursalRepository;
import com.controltotal.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateSucursalUseCaseImpl implements CreateSucursalUseCase {

    private final SucursalRepository sucursalRepository;
    private final SucursalApplicationMapper sucursalApplicationMapper;

    @Override
    public SucursalResponse execute(CreateSucursalRequest request) {

        validarCodigo(request.codigo(), request.empresaId());

        Sucursal sucursal = sucursalApplicationMapper.toDomain(request);

        sucursal.setActivo(true);

        Sucursal sucursalGuardada = sucursalRepository.save(sucursal);

        return sucursalApplicationMapper.toResponseSucursal(sucursalGuardada);
    }

    private void validarCodigo(String codigo, java.util.UUID empresaId) {

        if (sucursalRepository.existsByCodigoAndEmpresaId(codigo, empresaId)) {
            throw new BusinessException(
                    "Ya existe una sucursal registrada con el código: " + codigo
            );
        }

    }

}