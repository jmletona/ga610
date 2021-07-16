import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Worker } from '../Worker';

@Injectable({
  providedIn: 'root',
})
export class WorkerService {
  private apiUrl = 'http://localhost:9090/persons';
  constructor(private http: HttpClient) {}

  getWorkers(): Observable<Worker[]> {
    return this.http.get<Worker[]>(this.apiUrl);
  }
}
