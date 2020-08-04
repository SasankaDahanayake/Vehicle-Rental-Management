import { Injectable } from '@angular/core';

import{ HttpClient } from '@angular/common/http';
import{ Bike } from 'src/app/models/bike-model';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BikeService {

  constructor( private http:HttpClient ) { }

  readonly APIUrl = "http://localhost:8080";
  getBikeList(): Observable<Bike[]>{
    return this.http.get<Bike[]>(this.APIUrl + '/getAllBikes');
  }
}
