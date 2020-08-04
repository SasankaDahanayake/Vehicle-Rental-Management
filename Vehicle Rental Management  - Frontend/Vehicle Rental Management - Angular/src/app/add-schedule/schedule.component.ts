import { Component, OnInit } from '@angular/core';
import{MatDialogRef} from '@angular/material';
import { ScheduleService } from 'src/app/services/schedule.service';
import { NgForm } from '@angular/forms'; 


@Component({
  selector: 'app-schedule',
  templateUrl: './schedule.component.html',
  styleUrls: ['./schedule.component.css']
})
export class ScheduleComponent implements OnInit {

  constructor(public dialogbox: MatDialogRef<ScheduleComponent>,
    private service:ScheduleService) { }

  ngOnInit() {

    this.resetForm(); 


  }

  resetForm(form?:NgForm){
    if(form!=null)
    form.resetForm();

    this.service.formData={

      customerName:'',
      customerNIC:'',
      pickupDate:'',
      dropoffDate:'',
      vehiclePlateNo:''

    }
  }

  onClose(){
  this.dialogbox.close();
    
  }

  onSubmit(form:NgForm){

    this.service.addSchedule(form.value).subscribe(res=>
      {
        this.resetForm(form);
        alert(res);

      })
  }

}
