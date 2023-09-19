import { Component, OnInit } from '@angular/core';
import { FournisseurService } from './fournisseur.service';
import { Fournisseur } from '../model';
import { FournisseurHttpService } from './fournisseur-http.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-fournisseur',
  templateUrl: './fournisseur.component.html',
  styleUrls: ['./fournisseur.component.scss']
})
export class FournisseurComponent implements OnInit {

  fournisseurForm: FormGroup;
  showForm: boolean = false;
  
  constructor(private fournisseurHttpService: FournisseurHttpService, private formBuilder: FormBuilder) {

  }
  ngOnInit(): void {
    this.fournisseurForm = this.formBuilder.group({
      id: this.formBuilder.control(0),
      nom: this.formBuilder.control('', Validators.required),
      adresse: this.formBuilder.control('', [Validators.required, Validators.email]),
      responsable: this.formBuilder.control('')
    });
  }

  list(): Array<Fournisseur> {
    return this.fournisseurHttpService.findAll();
  }

  add() {
    this.fournisseurForm.reset();
    this.showForm = true;
  }

  edit(id: number) {
    this.fournisseurHttpService.findById(id).subscribe(response => {
      this.fournisseurForm.patchValue(response);
      this.showForm = true;
    });
  }

  remove(id: number) {
    this.fournisseurHttpService.deleteById(id);
  }

  save() {
    this.fournisseurHttpService.save(this.fournisseurForm.value);
    this.cancel();
  }

  cancel() {
    this.showForm = false;
    this.fournisseurForm.reset();
  }

}
