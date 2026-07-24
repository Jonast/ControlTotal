import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { BaseApi } from '../../../core/http/base-api';
import { ApiResponse } from '../../../core/http/api-response';

import { CreateSucursalRequest } from '../models/create-sucursal-request'
import { SucursalResponse } from '../models/sucursal-response';
import { UpdateSucursalRequest } from '../models/update-sucursal-request';

@Injectable({
  providedIn: 'root'
})
export class SucursalApi extends BaseApi {

  private readonly endpoint = `${this.api}/sucursales`;

  create(
    request: CreateSucursalRequest
  ): Observable<ApiResponse<SucursalResponse>> {

    return this.http.post<ApiResponse<SucursalResponse>>(
      this.endpoint,
      request
    );

  }

  list(): Observable<ApiResponse<SucursalResponse[]>> {

    return this.http.get<ApiResponse<SucursalResponse[]>>(
      this.endpoint
    );

  }

  getById(id: string): Observable<ApiResponse<SucursalResponse>> {

    return this.http.get<ApiResponse<SucursalResponse>>(
      `${this.endpoint}/${id}`
    );

  }

  update(
    id: string,
    request: UpdateSucursalRequest
  ): Observable<ApiResponse<SucursalResponse>> {

    return this.http.put<ApiResponse<SucursalResponse>>(
      `${this.endpoint}/${id}`,
      request
    );

  }

  delete(id: string): Observable<ApiResponse<void>> {

    return this.http.delete<ApiResponse<void>>(
      `${this.endpoint}/${id}`
    );

  }

}