import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { AdmissionService } from '../../services/admission.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admission-form',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './admission-form.component.html',
  styleUrl: './admission-form.component.css'
})
export class AdmissionFormComponent {

  admissionForm!: FormGroup;
  selectedAadharFile: File | null = null;

  constructor(
    private router: Router,
    private service: AdmissionService,
    private fb: FormBuilder
  ) {
    this.admissionForm = this.fb.group({
      name: ['', [Validators.required, Validators.minLength(3)]],
      emailID: ['', [Validators.required, Validators.email]],
      mobileNo: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
      gender: ['', Validators.required],
      roomType: ['', Validators.required],
      joiningDate: ['', Validators.required],
      monthlyPkg: ['', Validators.required],
      advancePayment: ['', Validators.required],
      roomNo: ['', Validators.required],
      address: ['', [Validators.required, Validators.minLength(10)]]
    });
  }

  onFileSelected(event: any) {
    const file = event.target.files[0];
    if (file) {
      this.selectedAadharFile = file;
    }
  }

  onSubmit() {
    if (this.admissionForm.invalid) {
      this.admissionForm.markAllAsTouched();
      return;
    }

    const formValue = this.admissionForm.value;
    const formDataToSend = new FormData();

    formDataToSend.append('name', formValue.name);
    formDataToSend.append('emailID', formValue.emailID);
    formDataToSend.append('mobileNo', formValue.mobileNo);
    formDataToSend.append('gender', formValue.gender);
    formDataToSend.append('roomType', formValue.roomType);
    formDataToSend.append('joiningDate', formValue.joiningDate);
    formDataToSend.append('monthlyPkg', formValue.monthlyPkg);
    formDataToSend.append('advancePayment', formValue.advancePayment);
    formDataToSend.append('roomNo', formValue.roomNo);
    formDataToSend.append('address', formValue.address);

    if (this.selectedAadharFile) {
      formDataToSend.append('aadharCard', this.selectedAadharFile);
    }

    this.service.saveAdmission(formDataToSend).subscribe({
      next: (response) => {
        alert('Thank You for submitting your admission form!');
        this.admissionForm.reset();
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