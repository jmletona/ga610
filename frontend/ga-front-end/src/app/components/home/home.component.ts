import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  services:any[] = [];
  countries:any[] = [];

  constructor(private http:HttpClient) {
    http.get("http://localhost:9090/country/get/1")
        .subscribe((data:any) => {
          this.services = data;
        });

    http.get("http://localhost:9090/country/all")
        .subscribe((data:any) => {
          this.countries = data;
        });
   }

  ngOnInit(): void {
  }

}
