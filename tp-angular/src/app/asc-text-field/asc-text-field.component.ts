import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrls: ['./asc-text-field.component.css']
})
export class AscTextFieldComponent implements OnInit {

  @Input()
  libelle!:string; 

  @Input()
  valeur!: string;

  @Output()
  inputChange = new EventEmitter<string>();

  constructor() {
   
  }
  ngOnInit(): void {
    console.log(this.libelle); 
  }

  refresh(value: any) {
    this.inputChange.emit(value);
  }
}
