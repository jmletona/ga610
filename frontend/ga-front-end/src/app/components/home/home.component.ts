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
  selectedCountry:string = "sv";

  constructor(private http:HttpClient) {
    http.get("http://localhost:9090/country/sv")
        .subscribe((data:any) => {
          console.log(data)
          this.services = data.data.services;
          this.countries = data.data.countryList;
        });
   }

  ngOnInit(): void {
  }

  getSelectedCountry(): void {
    let country:any = document.getElementById("country");
    this.selectedCountry = country.value
  }

  searchServices(event): void {
    console.log(this.selectedCountry);
    this.http.get("http://localhost:9090/country/"+this.selectedCountry)
        .subscribe((data:any) => {
          this.services = data.data.services;
        });
  }

}
