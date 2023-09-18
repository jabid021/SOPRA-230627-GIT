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

export class Produit {
    id: number;
    libelle: string;
    prixAchat: number;
    prixVente: number;
    reference: string;
    modele: string;
    stock: number;
    fournisseur: Fournisseur;

    constructor(
        id?: number,
        libelle?: string,
        prixAchat?: number,
        prixVente?: number,
        reference?: string,
        modele?: string,
        stock?: number,
        fournisseur?: Fournisseur
    ) {
        this.id = id
        this.libelle = libelle
        this.prixAchat = prixAchat
        this.prixVente = prixVente
        this.reference = reference
        this.modele = modele
        this.stock = stock
        this.fournisseur = fournisseur;
    }
}

export class Utilisateur {
    id: number;
    username: string;
    password: string;
    nom: string;
    prenom: string;
    disabled: boolean;
    roles: Array<string> = new Array<string>;

    constructor(
        id?: number,
        username?: string,
        password?: string,
        nom?: string,
        prenom?: string,
        disabled?: boolean,
        ...roles: string[]
    ) {
        this.id = id
        this.username = username
        this.password = password
        this.nom = nom
        this.prenom = prenom
        this.disabled = disabled
        this.roles = roles;
    }
}