import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

import { Header } from '../components/header/header';
import { Sidebar } from '../components/sidebar/sidebar';
import { Footer } from '../components/footer/footer';

@Component({
  selector: 'app-shell',
  standalone: true,
  imports: [
    RouterOutlet,
    Header,
    Sidebar,
    Footer
  ],
  templateUrl: './shell.html',
  styleUrl: './shell.css',
})
export class Shell {

  sidebarCollapsed = false;

  toggleSidebar(): void {

    this.sidebarCollapsed = !this.sidebarCollapsed;

  }

}