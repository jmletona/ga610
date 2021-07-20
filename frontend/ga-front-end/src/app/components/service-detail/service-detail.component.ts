import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-service-detail',
  templateUrl: './service-detail.component.html',
  styleUrls: ['./service-detail.component.css']
})
export class ServiceDetailComponent implements OnInit {

  peopleInService:any[] = [];
  private params:any = {};

  constructor(private activatedRoute: ActivatedRoute, private http:HttpClient) {
  }

  ngOnInit(): void {
    this.params = {
      country: this.activatedRoute.snapshot.params.countryId,
      service: this.activatedRoute.snapshot.params.serviceId
    };

    this.http.get("http://localhost:9090/country/"+this.params.country+"/service/"+this.params.service)
        .subscribe((data:any) => {
          console.log(data)
          this.peopleInService = data.data.persons;
        });
  }

}
