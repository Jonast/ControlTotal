package com.controltotal.application.usecase.empresa.update;

import com.controltotal.application.dto.request.UpdateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.application.mapper.EmpresaApplicationMapper;
import com.controltotal.domain.model.Empresa;
import com.controltotal.domain.repository.EmpresaRepository;
import com.controltotal.shared.exception.BusinessException;
import com.controltotal.shared.exception.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UpdateEmpresaUseCaseImpl implements UpdateEmpresaUseCase {

    private final EmpresaRepository empresaRepository;

    private final EmpresaApplicationMapper empresaApplicationMapper;

    @Override
    public EmpresaResponse execute(
            UUID id,
            UpdateEmpresaRequest request
    ) {

        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "No existe una empresa con id: " + id
                        )
                );

        validarRut(empresa, request);

        empresaApplicationMapper.updateDomain(
                empresa,
                request
        );

        Empresa empresaActualizada =
                empresaRepository.save(empresa);

        return empresaApplicationMapper.toResponseEmpresa(
                empresaActualizada
        );

    }

    private void validarRut(
            Empresa empresa,
            UpdateEmpresaRequest request
    ) {

        if (!empresa.getRut().equals(request.rut())
                && empresaRepository.existsByRut(request.rut())) {

            throw new BusinessException(
                    "Ya existe una empresa registrada con el RUT: "
                            + request.rut()
            );

        }

    }

}