import { Component, Input } from '@angular/core';
import { MatCardModule } from '@angular/material/card';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-kpi-card',
  standalone: true,
  imports: [
    MatCardModule,
    MatIconModule
  ],
  templateUrl: './kpi-card.html',
  styleUrls: ['./kpi-card.css']
})
export class KpiCard {

  @Input() title!: string;

  @Input() value!: string;

  @Input() icon!: string;

}