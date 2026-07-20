import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { BaseApi } from '../../../core/http/base-api';
import { ApiResponse } from '../../../core/http/api-response';

import { CreateEmpresaRequest } from '../models/create-empresa-request';
import { EmpresaResponse } from '../models/empresa-response';
import { UpdateEmpresaRequest } from '../models/update-empresa-request';

@Injectable({
  providedIn: 'root'
})
export class EmpresaApi extends BaseApi {

  private readonly endpoint = `${this.api}/empresas`;

  create(
    request: CreateEmpresaRequest
  ): Observable<ApiResponse<EmpresaResponse>> {

    return this.http.post<ApiResponse<EmpresaResponse>>(
      this.endpoint,
      request
    );

  }

  list(): Observable<ApiResponse<EmpresaResponse[]>> {

    return this.http.get<ApiResponse<EmpresaResponse[]>>(
      this.endpoint
    );

  }

  getById(id: string): Observable<ApiResponse<EmpresaResponse>> {

  return this.http.get<ApiResponse<EmpresaResponse>>(
    `${this.endpoint}/${id}`
  );

}

update(
  id: string,
  request: UpdateEmpresaRequest
): Observable<ApiResponse<EmpresaResponse>> {

  return this.http.put<ApiResponse<EmpresaResponse>>(
    `${this.endpoint}/${id}`,
    request
  );

}

}