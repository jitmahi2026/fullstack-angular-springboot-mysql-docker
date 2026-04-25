import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AdmissionService } from '../../services/admission.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-admission-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './admission-form.component.html',
  styleUrl: './admission-form.component.css'
})
export class AdmissionFormComponent {

  formData: any = {};

  constructor(private router: Router,private service: AdmissionService) { }
  
  onSubmit() {
    console.log('Form submitted:', this.formData);
    this.service.saveAdmission(this.formData).subscribe({
      next: (response) => {
        console.log('Admission saved:', response);
        alert('Admission submitted successfully!');
        this.router.navigate(['/']);
        
      },
      error: (error) => {
        console.error('Error saving admission:', error);
        alert('Error submitting admission.');
      }
    });
  }

  cancelAdmissionForm() {
    this.router.navigate(['/']);
  }
}
