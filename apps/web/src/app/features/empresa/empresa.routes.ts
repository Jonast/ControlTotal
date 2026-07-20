import { Routes } from '@angular/router';

export const EMPRESA_ROUTES: Routes = [

  {
    path: '',
    loadComponent: () =>
      import('./pages/empresa-list/empresa-list')
        .then(c => c.EmpresaListComponent)
  },

  {
    path: 'nuevo',
    loadComponent: () =>
      import('./pages/empresa-create/empresa-create')
        .then(c => c.EmpresaCreate)
  },

  {
    path: 'editar/:id',
    loadComponent: () =>
      import('./pages/empresa-create/empresa-create')
        .then(c => c.EmpresaCreate)
  }

];