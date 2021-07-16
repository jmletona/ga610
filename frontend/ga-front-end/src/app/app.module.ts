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

import { ROUTES } from './app.routes';
import { WorkersComponent } from './components/workers/workers.component';
import { WorkerComponent } from './components/worker/worker.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    LoginComponent,
    WorkersComponent,
    WorkerComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(ROUTES, { useHash: false }),
    AppRoutingModule,
    HttpClientModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
