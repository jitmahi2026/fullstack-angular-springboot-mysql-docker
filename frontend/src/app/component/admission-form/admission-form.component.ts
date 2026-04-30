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
  selectedAadharFile: File | null = null;

  constructor(private router: Router,private service: AdmissionService) { }
  
  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedAadharFile = file;
    }
  }

  onSubmit() {

    const formDataToSend = new FormData();

    formDataToSend.append('name', this.formData.name);
    formDataToSend.append('emailID', this.formData.emailID);
    formDataToSend.append('mobileNo', this.formData.mobileNo);
    formDataToSend.append('gender', this.formData.gender);
    formDataToSend.append('roomType', this.formData.roomType);
    formDataToSend.append('joiningDate', this.formData.joiningDate);
    formDataToSend.append('monthlyPkg', this.formData.monthlyPkg);
    formDataToSend.append('advancePayment', this.formData.advancePayment);
    formDataToSend.append('roomNo', this.formData.roomNo);
    formDataToSend.append('address', this.formData.address || '');

    if (this.selectedAadharFile) {
      formDataToSend.append('aadharCard', this.selectedAadharFile);
    }

    console.log('Form submitted:', this.formData);
    this.service.saveAdmission(formDataToSend).subscribe({
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
