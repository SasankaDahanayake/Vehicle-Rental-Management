import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Schedule } from 'src/app/models/schedule-model';
import { Observable } from 'rxjs';
import { FormGroup, FormControl } from '@angular/forms'

@Injectable({
  providedIn: 'root'
})
export class ScheduleService {

  constructor(private http:HttpClient) { }

  // // form: FormGroup = new FormGroup({
  // //   $key: new FormControl(null),
  // //   customerName:new FormControl(''),
  // //   customerNIC:new FormControl(''),
  // //   pickupDate:new FormControl(''),
  // //   dropoffDate:new FormControl(''),
  // //   vehiclePlateNo:new FormControl('')

  // })

  formData: Schedule

  readonly APIUrl = "http://localhost:8080";

  getScheduleList(): Observable<Schedule[]>{

    return this.http.get<Schedule[]>(this.APIUrl+'/addSchedule')

  }

  addSchedule(schedule:Schedule){
    return this.http.post(this.APIUrl+'/addSchedule', schedule) 
  }
}
