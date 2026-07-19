import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { BaseApi } from '../../../core/http/base-api';
import { ApiResponse } from '../../../core/http/api-response';

import { CreateEmpresaRequest } from '../models/create-empresa-request';
import { EmpresaResponse } from '../models/empresa-response';

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

}