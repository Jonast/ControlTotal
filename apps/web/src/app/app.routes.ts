import { Routes } from '@angular/router';

import { Shell } from './layout/shell/shell';
import { Dashboard } from './features/dashboard/pages/dashboard/dashboard';

export const routes: Routes = [
  {
    path: '',
    component: Shell,
    children: [

      {
        path: '',
        component: Dashboard
      },

      {
        path: 'empresas',
        loadChildren: () =>
          import('./features/empresa/empresa.routes')
            .then(r => r.EMPRESA_ROUTES)
      },
      {
        path: 'sucursales',
        loadChildren: () =>
          import('./features/sucursal/sucursal.routes')
            .then(r => r.SUCURSAL_ROUTES)
      }

    ]
  }
];