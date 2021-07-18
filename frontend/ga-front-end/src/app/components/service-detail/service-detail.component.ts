import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-service-detail',
  templateUrl: './service-detail.component.html',
  styleUrls: ['./service-detail.component.css']
})
export class ServiceDetailComponent implements OnInit {

  peopleInService:any[] = [
    {id:1, name:"José", rating:4},
    {id:2, name:"Manuel", rating:3},
    {id:3, name:"Ricardo", rating:4},
    {id:4, name:"Matias", rating:5},
    {id:5, name:"Alberto", rating:2}
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
