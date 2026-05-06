import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class AdmissionService {

  // private apiUrl = 'http://localhost:8081/customer/v1/customerform';
    // private apiUrl = '/api/customer/v1/customerform';
      private apiUrl = `${environment.apiUrl}customer/v1/customerform`;
  constructor(private http: HttpClient) { }

   saveAdmission(data: any): Observable<any> {
     return this.http.post(this.apiUrl, data);
   }
}
