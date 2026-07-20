package com.controltotal.application.usecase.empresa.get;

import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.application.mapper.EmpresaApplicationMapper;
import com.controltotal.application.usecase.empresa.get.GetEmpresaByIdUseCase;
import com.controltotal.domain.model.Empresa;
import com.controltotal.domain.repository.EmpresaRepository;
import com.controltotal.shared.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetEmpresaByIdUseCaseImpl implements GetEmpresaByIdUseCase {

    private final EmpresaRepository empresaRepository;

    private final EmpresaApplicationMapper empresaApplicationMapper;

    @Override
    public EmpresaResponse execute(UUID id) {

        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Empresa no encontrada con id: " + id
                        )
                );

        return empresaApplicationMapper.toResponseEmpresa(empresa);

    }

}
