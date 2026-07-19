package com.controltotal.application.usecase.empresa.list;

import com.controltotal.application.dto.response.EmpresaResponse;
import java.util.List;

public interface ListEmpresasUseCase {
    List<EmpresaResponse> execute();
}
