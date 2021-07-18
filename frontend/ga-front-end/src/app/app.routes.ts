import {Routes} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PersonDetailComponent } from './components/person-detail/person-detail.component';
import { ServiceDetailComponent } from './components/service-detail/service-detail.component';

export const ROUTES: Routes = [
    { path:'home', component:HomeComponent },
    { path:'service-detail', component:ServiceDetailComponent },
    { path:'person-detail', component:PersonDetailComponent },
    { path:'login', component:LoginComponent},
    { path:'', pathMatch:'full', redirectTo:'home' },
    { path:'**', pathMatch:'full', redirectTo:'home' }
];