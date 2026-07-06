package com.controltotal.application.usecase.empresa.create;

import com.controltotal.application.dto.request.CreateEmpresaRequest;
import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.application.mapper.EmpresaApplicationMapper;
import com.controltotal.domain.model.Empresa;
import com.controltotal.domain.repository.EmpresaRepository;
import com.controltotal.shared.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateEmpresaUseCaseImpl implements CreateEmpresaUseCase {

    private final EmpresaRepository empresaRepository;
    private final EmpresaApplicationMapper empresaApplicationMapper;

    @Override
    public EmpresaResponse execute(CreateEmpresaRequest request) {

        validarRut(request.rut());

        Empresa empresa = empresaApplicationMapper.toDomain(request);

        empresa.setActivo(true);

        Empresa empresaGuardada = empresaRepository.save(empresa);

        return empresaApplicationMapper.toResponseEmpresa(empresaGuardada);
    }

    private void validarRut(String rut) {

        if (empresaRepository.existsByRut(rut)) {
            throw new BusinessException(
                    "Ya existe una empresa registrada con el RUT: " + rut
            );
        }

    }

}