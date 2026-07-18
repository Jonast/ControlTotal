import { Component, inject } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MAT_SNACK_BAR_DATA } from '@angular/material/snack-bar';

@Component({
  selector: 'app-notification',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './notification.html',
  styleUrl: './notification.css'
})
export class Notification {

  readonly data = inject(MAT_SNACK_BAR_DATA) as {

    message: string;

    type: 'success' | 'error' | 'warning' | 'info';

  };

}