import { Component, HostListener, Input } from '@angular/core';

@Component({
  selector: 'asc-bold',
  templateUrl: './asc-bold.component.html',
  styleUrls: ['./asc-bold.component.css']
})
export class AscBoldComponent {

  @Input("titre")
  title!: string;

  cpt: number = 0;

  @HostListener("click")
  comptage() {
    this.cpt++;

    console.log(this.cpt);
  }


}
