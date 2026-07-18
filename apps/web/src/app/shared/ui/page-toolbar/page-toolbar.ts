import { Component, EventEmitter, Input, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { MatButtonModule } from '@angular/material/button';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from '@angular/material/icon';
import { MatInputModule } from '@angular/material/input';

@Component({
  selector: 'app-page-toolbar',
  standalone: true,
  imports: [
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatIconModule
  ],
  templateUrl: './page-toolbar.html',
  styleUrl: './page-toolbar.css'
})
export class PageToolbar {

  @Input() placeholder = 'Buscar';

  @Input() buttonText = '';

  @Output() search = new EventEmitter<string>();

  @Output() buttonClick = new EventEmitter<void>();

  value = '';

  onSearch() {
    this.search.emit(this.value);
  }

  onButtonClick() {
    this.buttonClick.emit();
  }

}