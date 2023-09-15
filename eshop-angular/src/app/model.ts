export class Fournisseur {
    id: number;
    nom: string;
    adresse: string;
    responsable: string;

    constructor(
        id?: number,
        nom?: string,
        adresse?: string,
        responsable?: string
    ) {
        this.id = id
        this.nom = nom
        this.adresse = adresse
        this.responsable = responsable
    }
}