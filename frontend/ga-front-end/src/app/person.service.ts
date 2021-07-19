import { getSyntheticPropertyName } from '@angular/compiler/src/render3/util';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Person } from './person';
import { HttpClient, HttpClientModule } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class PersonService {
  private apiServerURL = '';

  constructor(private http: HttpClient) {}

  public getPersons(): Observable<Person> {
    return this.http.get<Person>(`${this.apiServerURL}/person/all`);
  }
}
