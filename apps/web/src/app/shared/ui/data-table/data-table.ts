import {
  Component,
  Input,
  Output,
  EventEmitter,
  OnChanges,
  SimpleChanges
} from '@angular/core';

import { CommonModule } from '@angular/common';

import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';

@Component({
  selector: 'app-data-table',
  standalone: true,
  imports: [
    CommonModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule
  ],
  templateUrl: './data-table.html',
  styleUrl: './data-table.css'
})
export class DataTable implements OnChanges {

  @Input()
  columns: string[] = [];

  @Input()
  columnLabels: Record<string, string> = {};

  @Input()
  data: any[] = [];

  @Input()
  showActions = true;

  @Output()
  edit = new EventEmitter<any>();

  @Output()
  remove = new EventEmitter<any>();

  displayedColumns: string[] = [];

  ngOnChanges(changes: SimpleChanges): void {

    this.displayedColumns = this.showActions
      ? [...this.columns, 'actions']
      : [...this.columns];

  }

}