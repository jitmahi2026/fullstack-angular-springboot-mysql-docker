import { Routes } from '@angular/router';
import { HomeComponent } from './component/home/home.component';
import { AdmissionFormComponent } from './component/admission-form/admission-form.component';
import { AboutComponent } from './component/about/about.component';
import { ContactComponent } from './component/contact/contact.component';
import { ServicesComponent } from './component/services/services.component';
import { SuportComponent } from './component/suport/suport.component';

export const routes: Routes = [
    { path: '', component: HomeComponent },
  { path: 'admission', component: AdmissionFormComponent },
  {path: 'about', component: AboutComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'services', component: ServicesComponent},
  {path: 'suport', component: SuportComponent},
];
