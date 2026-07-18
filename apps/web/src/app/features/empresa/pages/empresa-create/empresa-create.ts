import { Component, inject } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { Router } from '@angular/router';

import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { NotificationService } from '../../../../core/services/notification.service';
import { PageHeader } from '../../../../shared/ui/page-header/page-header';

import { EmpresaApi } from '../../api/empresa-api';
import { CreateEmpresaRequest } from '../../models/create-empresa-request';

@Component({
  selector: 'app-empresa-create',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    PageHeader
  ],
  templateUrl: './empresa-create.html',
  styleUrl: './empresa-create.css'
})
export class EmpresaCreate {

  private readonly fb = inject(FormBuilder);
  private readonly empresaApi = inject(EmpresaApi);
  private readonly notification = inject(NotificationService);
  private readonly router = inject(Router);

  readonly form = this.fb.group({

    nombreComercial: ['', Validators.required],

    razonSocial: ['', Validators.required],

    rut: ['', Validators.required],

    email: ['', [Validators.required, Validators.email]],

    telefono: [''],

    logo: ['']

  });

  guardar(): void {

    if (this.form.invalid) {

      this.form.markAllAsTouched();

      return;

    }

    const request = this.form.getRawValue() as CreateEmpresaRequest;

    this.empresaApi.create(request).subscribe({

next: (response) => {

    this.notification.success(

        response.message

    );

    setTimeout(() => {

        this.router.navigate(['/']);

    }, 3000);

},

      error: (error) => {

        console.error(error);

        this.notification.error(

          'Error al crear la empresa.',

          'Cerrar',

          {
            duration: 4000,
            horizontalPosition: 'end',
            verticalPosition: 'top'
          }

        );

      }

    });

  }

  cancelar(): void {

    this.router.navigate(['/']);

  }

}