import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-person-list',
  templateUrl: './person-list.component.html',
  styleUrls: ['./person-list.component.css']
})
export class PersonListComponent implements OnInit {

  people:any[] = [];

  constructor(private httpClient:HttpClient) {
    httpClient.get("http://localhost:9090/persons")
              .subscribe((data:any)=>{
                this.people = data.data;
              });
   }

  ngOnInit(): void {
  }

  onView(id:number):void{
    console.log(id);
  }
}
