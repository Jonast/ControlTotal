import { Component } from '@angular/core';
import { KpiCard } from '../../../../shared/components/kpi-card/kpi-card';
import { PageHeader } from '../../../../shared/ui/page-header/page-header';

@Component({
  selector: 'app-dashboard',
  standalone: true,
  imports: [
    KpiCard,
    PageHeader
  ],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css'
})
export class Dashboard {}