import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AdmissionService {

  private apiUrl = 'http://localhost:8081/customer/v1/customerform';

  constructor(private http: HttpClient) { }

   saveAdmission(data: any): Observable<any> {
     return this.http.post(this.apiUrl, data);
   }
}
