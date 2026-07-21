package com.controltotal.application.usecase.empresa.delete;

import com.controltotal.domain.repository.EmpresaRepository;
import com.controltotal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DeleteEmpresaUseCaseImpl implements DeleteEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    @Override
    public void execute(UUID id) {

        empresaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Empresa no encontrada con id: " + id
                        )
                );

        empresaRepository.deleteById(id);

    }

}