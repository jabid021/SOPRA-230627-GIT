
btnAjouter.onclick = ajoutTableau;

inputPrenom.onkeyup= function(event)
{
  if(event.key=="Enter" && inputPrenom.value!="")
  {
    ajoutTableau();
  }

  let prenom = inputPrenom.value;
  if(prenom=="")
  {
    bloquerFormPrenom();
  }
  else
  {
    btnAjouter.disabled=false;
    loginStatut.style.backgroundColor="green";
  }
};


function bloquerFormPrenom()
{
  btnAjouter.disabled=true;
  loginStatut.style.backgroundColor="red";
}

function ajoutTableau()
{
  let prenom = inputPrenom.value;
  corpTableau.innerHTML+=`<tr><td>${prenom}</td></tr>`;
  inputPrenom.value="";
  bloquerFormPrenom();
}
