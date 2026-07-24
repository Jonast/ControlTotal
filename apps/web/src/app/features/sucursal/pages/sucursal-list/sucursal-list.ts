import { ChangeDetectorRef, Component, OnInit, inject } from '@angular/core';
import { Router } from '@angular/router';

import { PageHeader } from '../../../../shared/ui/page-header/page-header';
import { PageToolbar } from '../../../../shared/ui/page-toolbar/page-toolbar';
import { DataTable } from '../../../../shared/ui/data-table/data-table';

import { SucursalApi } from '../../api/sucursal-api';
import { SucursalResponse } from '../../models/sucursal-response';

@Component({
  selector: 'app-sucursal-list',
  standalone: true,
  imports: [
    PageHeader,
    PageToolbar,
    DataTable
  ],
  templateUrl: './sucursal-list.html',
  styleUrl: './sucursal-list.css'
})
export class SucursalListComponent implements OnInit {

  private readonly sucursalApi = inject(SucursalApi);

  private readonly router = inject(Router);

  private readonly cdr = inject(ChangeDetectorRef);

  sucursales: SucursalResponse[] = [];

  sucursalesOriginal: SucursalResponse[] = [];

  columns: string[] = [
    'codigo',
    'nombre',
    'comuna',
    'telefono',
    'activo'
  ];

  columnLabels: Record<string, string> = {
    codigo: 'Código',
    nombre: 'Nombre',
    comuna: 'Comuna',
    telefono: 'Teléfono',
    activo: 'Estado'
  };

  ngOnInit(): void {
    this.load();
  }

  load(): void {

    this.sucursalApi.list().subscribe({

      next: response => {

        this.sucursales = [...response.data];
        this.sucursalesOriginal = [...response.data];

        this.cdr.detectChanges();

      },

      error: error => console.error(error)

    });

  }

  onSearch(value: string): void {

    if (!value) {

      this.sucursales = [...this.sucursalesOriginal];

      return;

    }

    value = value.toLowerCase();

    this.sucursales = this.sucursalesOriginal.filter(s =>

      s.codigo.toLowerCase().includes(value)
      ||
      s.nombre.toLowerCase().includes(value)
      ||
      s.comuna.toLowerCase().includes(value)

    );

  }

  onNew(): void {

    this.router.navigate(['/sucursales/nuevo']);

  }

  onEdit(sucursal: SucursalResponse): void {

    this.router.navigate([
      '/sucursales/editar',
      sucursal.id
    ]);

  }

  onDelete(sucursal: SucursalResponse): void {

    const confirmar = window.confirm(
      `¿Eliminar la sucursal "${sucursal.nombre}"?`
    );

    if (!confirmar) {

      return;

    }

    this.sucursalApi.delete(sucursal.id)
      .subscribe({

        next: () => this.load(),

        error: () =>

          window.alert('No fue posible eliminar la sucursal.')

      });

  }

}