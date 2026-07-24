package com.controltotal.application.usecase.sucursal.get;

import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.application.mapper.SucursalApplicationMapper;
import com.controltotal.domain.model.Sucursal;
import com.controltotal.domain.repository.SucursalRepository;
import com.controltotal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSucursalByIdUseCaseImpl implements GetSucursalByIdUseCase {

    private final SucursalRepository sucursalRepository;

    private final SucursalApplicationMapper sucursalApplicationMapper;

    @Override
    public SucursalResponse execute(UUID id) {

        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sucursal no encontrada con id: " + id
                        )
                );

        return sucursalApplicationMapper.toResponseSucursal(sucursal);

    }

}