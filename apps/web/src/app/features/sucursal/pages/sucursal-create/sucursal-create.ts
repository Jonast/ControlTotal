import { Component, OnInit, inject } from '@angular/core';
import {
  FormBuilder,
  ReactiveFormsModule,
  Validators
} from '@angular/forms';

import { ActivatedRoute, Router } from '@angular/router';

import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';

import { NotificationService } from '../../../../core/services/notification.service';
import { PageHeader } from '../../../../shared/ui/page-header/page-header';

import { EmpresaApi } from '../../../empresa/api/empresa-api';
import { EmpresaResponse } from '../../../empresa/models/empresa-response';

import { SucursalApi } from '../../api/sucursal-api';
import { CreateSucursalRequest } from '../../models/create-sucursal-request';
import { UpdateSucursalRequest } from '../../models/update-sucursal-request';

@Component({
  selector: 'app-sucursal-create',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    MatCardModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    PageHeader
  ],
  templateUrl: './sucursal-create.html',
  styleUrl: './sucursal-create.css'
})
export class SucursalCreateComponent implements OnInit {

  private readonly fb = inject(FormBuilder);

  private readonly sucursalApi = inject(SucursalApi);

  private readonly empresaApi = inject(EmpresaApi);

  private readonly notification = inject(NotificationService);

  private readonly router = inject(Router);

  private readonly route = inject(ActivatedRoute);

  empresas: EmpresaResponse[] = [];

  isEdit = false;

  sucursalId = '';

  readonly form = this.fb.nonNullable.group({

    empresaId: ['', Validators.required],

    codigo: ['', Validators.required],

    nombre: ['', Validators.required],

    direccion: ['', Validators.required],

    comuna: ['', Validators.required],

    telefono: [''],

    email: ['', [Validators.required, Validators.email]]

  });

  ngOnInit(): void {

    this.cargarEmpresas();

    const id = this.route.snapshot.paramMap.get('id');

    if (!id) {
      return;
    }

    this.isEdit = true;

    this.sucursalId = id;

    this.cargarSucursal();

  }

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

    const request = this.form.getRawValue() as CreateSucursalRequest;

    this.sucursalApi.create(request).subscribe({

      next: response => {

        this.notification.success(response.message);

        this.router.navigate(['/sucursales']);

      },

      error: () => {

        this.notification.error('Error al crear la sucursal.');

      }

    });

  }

  private actualizar(): void {

    const request: UpdateSucursalRequest = {

      ...this.form.getRawValue(),

      activo: true

    };

    this.sucursalApi.update(this.sucursalId, request).subscribe({

      next: response => {

        this.notification.success(response.message);

        this.router.navigate(['/sucursales']);

      },

      error: () => {

        this.notification.error('Error al actualizar la sucursal.');

      }

    });

  }

  cancelar(): void {

    this.router.navigate(['/sucursales']);

  }

  private cargarEmpresas(): void {

    this.empresaApi.list().subscribe({

      next: response => {

        this.empresas = response.data;

      },

      error: error => {

        console.error(error);

      }

    });

  }

  private cargarSucursal(): void {

    this.sucursalApi.getById(this.sucursalId).subscribe({

      next: response => {

        this.form.patchValue({

          empresaId: response.data.empresaId,

          codigo: response.data.codigo,

          nombre: response.data.nombre,

          direccion: response.data.direccion,

          comuna: response.data.comuna,

          telefono: response.data.telefono,

          email: response.data.email

        });

      },

      error: error => {

        console.error(error);

      }

    });

  }

  getEmpresaSeleccionada(): string {

    const empresa = this.empresas.find(

      e => e.id === this.form.controls.empresaId.value

    );

    return empresa?.nombreComercial ?? '';

  }

}