import { HttpClient } from '@angular/common/http';
import { inject } from '@angular/core';

import { ApiConfig } from '../config/api.config';

export abstract class BaseApi {

    protected readonly http = inject(HttpClient);

    protected readonly api = ApiConfig.baseUrl;

}