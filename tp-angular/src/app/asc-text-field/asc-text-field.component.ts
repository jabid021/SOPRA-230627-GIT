import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'asc-text-field',
  templateUrl: './asc-text-field.component.html',
  styleUrls: ['./asc-text-field.component.css']
})
export class AscTextFieldComponent {

  @Input()
  libelle!:string; 

  @Input()
  valeur!: string;


}
