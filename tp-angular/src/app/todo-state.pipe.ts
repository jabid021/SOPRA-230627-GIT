import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'todoState'
})
export class TodoStatePipe implements PipeTransform {

  transform(value: boolean, arg0?: string): string {
    if(arg0 == "desc") {
      return value?"Terminé":"Non terminé";
    }

    return value?"hsl(153 48% 49%)":"hsl(341 79% 53%)";
  }

}
