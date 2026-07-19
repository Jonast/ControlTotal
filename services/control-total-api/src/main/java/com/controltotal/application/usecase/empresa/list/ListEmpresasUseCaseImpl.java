package com.controltotal.application.usecase.empresa.list;

import com.controltotal.application.dto.response.EmpresaResponse;
import com.controltotal.application.mapper.EmpresaApplicationMapper;
import com.controltotal.domain.repository.EmpresaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ListEmpresasUseCaseImpl implements ListEmpresasUseCase {

    private final EmpresaRepository empresaRepository;
    private final EmpresaApplicationMapper empresaApplicationMapper;

    @Override
    public List<EmpresaResponse> execute() {

        return empresaRepository.findAll()
                .stream()
                .map(empresaApplicationMapper::toResponseEmpresa)
                .toList();
    }
}
