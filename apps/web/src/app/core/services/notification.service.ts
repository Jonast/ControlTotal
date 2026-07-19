import { Injectable, inject } from '@angular/core';

import { MatSnackBar } from '@angular/material/snack-bar';

import { Notification } from '../../shared/ui/notification/notification';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  private readonly snackBar = inject(MatSnackBar);

  success(message: string): void {

    this.open(message, 'success');

  }

  error(message: string): void {

    this.open(message, 'error');

  }

  warning(message: string): void {

    this.open(message, 'warning');

  }

  info(message: string): void {

    this.open(message, 'info');

  }

  private open(
    message: string,
    type: 'success' | 'error' | 'warning' | 'info'
  ): void {

    this.snackBar.openFromComponent(Notification, {

      duration: 3000,

      horizontalPosition: 'end',

      verticalPosition: 'top',

      data: {

        message,

        type

      }

    });

  }

}