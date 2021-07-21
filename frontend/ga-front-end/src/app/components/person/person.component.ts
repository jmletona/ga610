import { Component, OnInit } from '@angular/core';
import { Person } from '../../models/person';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-person',
  templateUrl: './person.component.html',
  styleUrls: ['./person.component.css']
})
export class PersonComponent implements OnInit {

  personModel:Person;

  constructor(private httpClient:HttpClient) {
    this.personModel = new Person("","","","","",0);
  }

  ngOnInit(): void {
  }

  sendForm(): void{
    console.log(this.personModel)
  }

}
