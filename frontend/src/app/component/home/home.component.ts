import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  menuOpen = false;
 

  constructor(private router: Router) {
    
  }
  

  toggleMenu() {
    this.menuOpen = !this.menuOpen;
  }

  onRegister(event: Event) {
    event.preventDefault();
    alert('Register form submitted!');
  }

  openAdmissionFrom() {
    this.router.navigate(['/admission']);
  }

  
}
