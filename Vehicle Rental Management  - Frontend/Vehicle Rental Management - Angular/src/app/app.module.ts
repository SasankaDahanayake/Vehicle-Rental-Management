import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { MatTableModule, MatIconModule, MatButtonModule, MatFormFieldModule } from '@angular/material';
import{ MatSortModule} from '@angular/material';
import{ MatDialogModule} from '@angular/material';
import {FormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material/select';
import { ReactiveFormsModule } from '@angular/forms';
import {MatGridListModule} from '@angular/material/grid-list';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { CarComponent } from './show-car/car.component';
//import { ShowCarComponent } from './car/show-car/show-car.component';
import { BikeComponent } from './show-bike/bike.component';
//import { ShowBikeComponent } from './bike/show-bike/show-bike.component';
import { ScheduleComponent } from './add-schedule/schedule.component';
//import { AddScheduleComponent } from './schedule/add-schedule/add-schedule.component';

import {CarService} from 'src/app/services/car.service';
import {BikeService} from 'src/app/services/bike.service';

@NgModule({
  declarations: [
    AppComponent,
    CarComponent,
    //ShowCarComponent,
    BikeComponent,
    //ShowBikeComponent,
    ScheduleComponent,
    //AddScheduleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule, MatTableModule, MatIconModule, MatButtonModule,
    HttpClientModule,
    MatSortModule,
    MatDialogModule,
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    ReactiveFormsModule,
    MatGridListModule
  ],
  providers: [CarService, BikeService],
  bootstrap: [AppComponent],
  entryComponents : [ScheduleComponent]
})
export class AppModule { }
