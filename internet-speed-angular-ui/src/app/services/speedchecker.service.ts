import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class SpeedcheckerService {
  private host = 'http://localhost:8080/api/speed';
  private testEndpoint = '/test'; // returns test data
  private speedEndpoint = '';
  private apiUrl = this.host + this.testEndpoint;

  constructor(private httpClient: HttpClient) {}

  fetchInternetSpeed(): Observable<any> {
    return this.httpClient.get<any>(this.apiUrl);
  }
}
