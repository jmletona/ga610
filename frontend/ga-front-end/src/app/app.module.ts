import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { Router, RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { HomeComponent } from './components/home/home.component';
import { AppRoutingModule } from './app-routing.module';
import { LoginComponent } from './components/login/login.component';

// Import your library
import { SlickCarouselModule } from 'ngx-slick-carousel';

import { ROUTES } from './app.routes';
import { PersonDetailComponent } from './components/person-detail/person-detail.component';
import { ServiceDetailComponent } from './components/service-detail/service-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    PersonDetailComponent,
    ServiceDetailComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    SlickCarouselModule,
    RouterModule.forRoot(ROUTES, {useHash:false})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
