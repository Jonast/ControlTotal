import { Routes } from '@angular/router';

export const SUCURSAL_ROUTES: Routes = [

  {
    path: '',
    loadComponent: () =>
      import('./pages/sucursal-list/sucursal-list')
        .then(c => c.SucursalListComponent)
  },

  {
    path: 'nuevo',
    loadComponent: () =>
      import('./pages/sucursal-create/sucursal-create')
        .then(c => c.SucursalCreateComponent)
  },

  {
    path: 'editar/:id',
    loadComponent: () =>
      import('./pages/sucursal-create/sucursal-create')
        .then(c => c.SucursalCreateComponent)
  }

];