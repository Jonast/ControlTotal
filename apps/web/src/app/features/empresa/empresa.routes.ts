import { Routes } from '@angular/router';

export const EMPRESA_ROUTES: Routes = [

  {
    path: '',
    redirectTo: 'nuevo',
    pathMatch: 'full'
  },

  {
    path: 'nuevo',
    loadComponent: () =>
      import('./pages/empresa-create/empresa-create')
        .then(c => c.EmpresaCreate)
  }

];