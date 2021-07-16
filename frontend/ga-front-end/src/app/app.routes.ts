import {Routes} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';

export const ROUTES: Routes = [
    { path:'home', component:HomeComponent },
    { path:'login', component:LoginComponent},
    { path:'', pathMatch:'full', redirectTo:'home' },
    { path:'**', pathMatch:'full', redirectTo:'home' }
];