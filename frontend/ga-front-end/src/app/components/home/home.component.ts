import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  services:any[] = [];
  countries:any[] = [
    {id:1, name:"El Salvador"},
    {id:2, name:"Guatemala"},
    {id:3, name:"Mexico"},
    {id:4, name:"Trinidad y Tobago"}
  ];

  constructor(private http:HttpClient) {
    http.get("https://restcountries.eu/rest/v2/lang/es")
        .subscribe((data:any) => {
          this.services = data;
        });
   }

  ngOnInit(): void {
  }

}
