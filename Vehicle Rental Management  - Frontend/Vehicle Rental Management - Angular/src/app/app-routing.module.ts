import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ScheduleComponent } from './add-schedule/schedule.component';
import { Schedule } from './models/schedule-model';
import { AppComponent } from './app.component'

const routes: Routes = [
  { path: 'add-schedule', component : ScheduleComponent }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
