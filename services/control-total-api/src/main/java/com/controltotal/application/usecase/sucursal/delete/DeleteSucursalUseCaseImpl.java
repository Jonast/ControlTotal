package com.controltotal.application.usecase.sucursal.delete;

import com.controltotal.domain.repository.SucursalRepository;
import com.controltotal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteSucursalUseCaseImpl implements DeleteSucursalUseCase {

    private final SucursalRepository sucursalRepository;

    @Override
    public void execute(UUID id) {

        sucursalRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Sucursal no encontrada con id: " + id
                        )
                );

        sucursalRepository.deleteById(id);

    }

}