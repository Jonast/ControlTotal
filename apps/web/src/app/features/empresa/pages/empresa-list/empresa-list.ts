import { Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';

import { PageHeader } from '../../../../shared/ui/page-header/page-header';
import { PageToolbar } from '../../../../shared/ui/page-toolbar/page-toolbar';
import { DataTable } from '../../../../shared/ui/data-table/data-table';

import { EmpresaApi } from '../../api/empresa-api';
import { EmpresaResponse } from '../../models/empresa-response';

@Component({
  selector: 'app-empresa-list',
  standalone: true,
  imports: [
    PageHeader,
    PageToolbar,
    DataTable
  ],
  templateUrl: './empresa-list.html',
  styleUrl: './empresa-list.css'
})
export class EmpresaListComponent implements OnInit {

  private readonly empresaApi = inject(EmpresaApi);

  private readonly router = inject(Router);

  empresas: EmpresaResponse[] = [];

  empresasOriginal: EmpresaResponse[] = [];

  columns: string[] = [
    'nombreComercial',
    'rut',
    'email',
    'telefono',
    'activo'
  ];

  columnLabels: Record<string, string> = {

    nombreComercial: 'Nombre Comercial',

    rut: 'RUT',

    email: 'Correo',

    telefono: 'Teléfono',

    activo: 'Estado'

  };

  ngOnInit(): void {

    this.load();

  }

  load(): void {

    this.empresaApi.list().subscribe({

      next: response => {

        this.empresas = response.data;

        this.empresasOriginal = [...response.data];

      },

      error: error => console.error(error)

    });

  }

  onSearch(value: string): void {

    if (!value) {

      this.empresas = [...this.empresasOriginal];

      return;

    }

    const filter = value.toLowerCase();

    this.empresas = this.empresasOriginal.filter(e =>

      e.nombreComercial.toLowerCase().includes(filter)

      ||

      e.rut.toLowerCase().includes(filter)

      ||

      e.email.toLowerCase().includes(filter)

    );

  }

  onNew(): void {

    this.router.navigate(['empresas/nuevo']);

  }

 onEdit(empresa: EmpresaResponse): void {

  this.router.navigate([
    '/empresas/editar',
    empresa.id
  ]);

}

  onDelete(empresa: EmpresaResponse): void {

    console.log('Eliminar', empresa);

  }

}