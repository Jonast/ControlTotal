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

import { ActivatedRoute } from '@angular/router';
import { OnInit } from '@angular/core';

import { UpdateEmpresaRequest } from '../../models/update-empresa-request';

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
export class EmpresaCreate implements OnInit {

  private readonly route = inject(ActivatedRoute);
  isEdit = false;
  empresaId = '';


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

  if (this.isEdit) {

    this.actualizar();

    return;

  }

  this.crear();

}

private crear(): void {

  const request =
    this.form.getRawValue() as CreateEmpresaRequest;

  this.empresaApi.create(request)
    .subscribe({

      next: response => {

        this.notification.success(response.message);

        this.router.navigate(['/empresas']);

      },

      error: () =>

        this.notification.error(
          'Error al crear la empresa.'
        )

    });

}

private actualizar(): void {

  const request =
    this.form.getRawValue() as UpdateEmpresaRequest;

  this.empresaApi.update(
      this.empresaId,
      request
    )
    .subscribe({

      next: response => {

        this.notification.success(response.message);

        this.router.navigate(['/empresas']);

      },

      error: () =>

        this.notification.error(
          'Error al actualizar la empresa.'
        )

    });

}

  cancelar(): void {

    this.router.navigate(['/']);

  }

  ngOnInit(): void {

    const id = this.route.snapshot.paramMap.get('id');

    if (!id) {

      return;

    }

    this.isEdit = true;

    this.empresaId = id;

    this.cargarEmpresa();

  }

  private cargarEmpresa(): void {

    this.empresaApi.getById(this.empresaId)
      .subscribe({

        next: response => {

          this.form.patchValue({

            nombreComercial: response.data.nombreComercial,

            razonSocial: response.data.razonSocial,

            rut: response.data.rut,

            email: response.data.email,

            telefono: response.data.telefono,

            logo: response.data.logo

          });

        },

        error: error => console.error(error)

      });

  }

}