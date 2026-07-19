import { Component, Input } from '@angular/core';
import { MatButtonModule } from '@angular/material/button';

@Component({
  selector: 'app-page-header',
  standalone: true,
  imports: [
    MatButtonModule
  ],
  templateUrl: './page-header.html',
  styleUrl: './page-header.css'
})
export class PageHeader {

  @Input() title = '';

  @Input() subtitle = '';

  @Input() buttonText = '';

}