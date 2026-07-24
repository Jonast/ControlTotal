package com.controltotal.application.usecase.sucursal.list;

import com.controltotal.application.dto.response.SucursalResponse;
import com.controltotal.application.mapper.SucursalApplicationMapper;
import com.controltotal.domain.repository.SucursalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListSucursalesUseCaseImpl implements ListSucursalUseCase {

    private final SucursalRepository sucursalRepository;

    private final SucursalApplicationMapper sucursalApplicationMapper;

    @Override
    public List<SucursalResponse> execute() {

        return sucursalRepository.findAll()
                .stream()
                .map(sucursalApplicationMapper::toResponseSucursal)
                .toList();

    }

}