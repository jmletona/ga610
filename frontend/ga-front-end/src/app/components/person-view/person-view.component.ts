import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-person-view',
  templateUrl: './person-view.component.html',
  styleUrls: ['./person-view.component.css']
})
export class PersonViewComponent implements OnInit {

  person:any = {};

  constructor(private activatedRoute: ActivatedRoute, private httpClient:HttpClient) {
    
   }

  ngOnInit(): void {
    let param:number = this.activatedRoute.snapshot.params.idPerson;

    this.httpClient.get("http://localhost:9090/persons/"+param)
              .subscribe((data:any)=>{
                this.person = data.data;
              });
  }

}
