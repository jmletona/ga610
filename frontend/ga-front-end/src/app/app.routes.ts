import {Routes} from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { PersonDetailComponent } from './components/person-detail/person-detail.component';
import { ServiceDetailComponent } from './components/service-detail/service-detail.component';
import { PersonComponent } from './components/person/person.component';
import { PersonListComponent } from './components/person-list/person-list.component';
import { PersonViewComponent } from './components/person-view/person-view.component';

export const ROUTES: Routes = [
    { path:'home', component:HomeComponent },
    { path:'service-detail/:countryId/service/:serviceId', component:ServiceDetailComponent },
    { path:'person-detail/:personId', component:PersonDetailComponent },
    { path:'person', component: PersonComponent},
    { path:'person-list', component: PersonListComponent},
    { path:'person-view/:idPerson', component: PersonViewComponent},
    { path:'login', component:LoginComponent},
    { path:'', pathMatch:'full', redirectTo:'home' },
    { path:'**', pathMatch:'full', redirectTo:'home' }
];
