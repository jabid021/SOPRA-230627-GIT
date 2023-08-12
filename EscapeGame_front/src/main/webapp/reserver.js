
var prixSalle;
var salleSelect;
var mesParticipants;
var options = "<option value=''>Choisir un participant existant</option>";
for (let index in mesParticipants) {
	let p = mesParticipants[index];

	options += `<option value='${index}'>${p.prenom} ${p.nom}</option>`;
}
nombreParticipant.onchange = function() {
	var nbParticipants = nombreParticipant.value;
	showFormParticipants(nbParticipants);
}

checkSelf.onchange = isCheckSelf;


function isCheckSelf() {
	if (checkSelf.checked == true) {
		nom1.value = mesParticipants[0].nom;
		prenom1.value = mesParticipants[0].prenom;
		selectParticipant1.value = "0";
	}
	else {
		nom1.value = "";
		prenom1.value = "";
		selectParticipant1.value = "";
	}
}
function showFormParticipants(nbParticipants) {

	var tableau = `<input type='hidden' name='salle' value='${salleSelect}'><input type='hidden' name='nbParticipants' value='${nbParticipants}'> <table class='table table-striped'><tr><th><input type="text" name="equipe" placeholder="nom equipe"required></th><th>Nom</th><th>Prenom</th><th>Choisir un de vos participants</th></tr>`;
	for (let i = 1; i <= nbParticipants; i++) {
		tableau += `<tr>
          <td>Participant ${i}</td>
          <td><input type="hidden" name="id-${i}" value="${mesParticipants[i].id}"><input required placeholder="Nom du participant ${i}" type="text" name="nom-${i}" id="nom${i}"></td>
          <td><input required placeholder="Prenom du participant ${i}" type="text" name="prenom-${i}" id="prenom${i}"></td>
          <td><select id="selectParticipant${i}" onChange='assignParticipant(${i})'>${options}</select></td>
        </tr>`;
	}
	tableau += `</table><input class="btn btn-success" type='submit' value='Reserver (${prixSalle * nbParticipants}€)'>`;
	formulaireResaParticipant.innerHTML = tableau;
	isCheckSelf();
}

function formParticipants(salle, min, max, prix) {
	prixSalle = prix;
	salleSelect = salle;
	formReservation.style.display = "block";
	nombreParticipant.innerHTML = "";
	for (let i = min; i <= max; i++) {
		nombreParticipant.innerHTML += `<option value=${i}>${i} participants</option>`;
	}
	showFormParticipants(min);
}

function assignParticipant(idLigne) {
	indexParticipant = document.getElementById(`selectParticipant${idLigne}`).value;
	if (indexParticipant == "") {
		document.getElementById(`nom${idLigne}`).value = "";
		document.getElementById(`prenom${idLigne}`).value = "";
	}
	else {
		document.getElementById(`nom${idLigne}`).value = mesParticipants[indexParticipant].nom;
		document.getElementById(`prenom${idLigne}`).value = mesParticipants[indexParticipant].prenom;
	}

}
