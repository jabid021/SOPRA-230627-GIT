//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX=0;
var posY=0;
var ketchup=false;

var pokemon="pikachu";
var direction="Down";

imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

function ajouterNom(){
  pokemon=inputName.value;
  console.log(pokemon);
  if (pokemon=="") {
    btnStart.disabled=true;
  }
  else {
  btnStart.disabled=false;
  console.log(pokemon);
  btnStart.onclick=pikachu.setAttribute("title",pokemon);
  btnStart.onclick=afficheGrass;
}
}
function playAudio(){
  document.getElementById("music");
  music.volume=0.1;
  music.play();
}
function afficheGrass(){
  formStart.style.display="none";
  grass.style.display="block";
  document.body.onkeydown=deplacement;
  playAudio();

}

function deplacement(event)
{

  if(event.key=="ArrowDown" || event.key=="s" )
  {

    direction="Down";
    if (posY <= 630) { // si la position Y dépasse la limite inférieure de la div grass
      posY += 30;
    }
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {

    direction="Right";
    if (posX <= 630) {
      posX += 30;
    }
  }
  else if(event.key=="ArrowLeft" || event.key=="q")
  {

    direction="Left";
    if (posX >= 30) {
      posX -= 30;
    }
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {

    direction="Up";
    if (posY >= 30) {
      posY -= 30;
    }
  }
  if(posX==300 && posY==300){
    ketchup=true;
  }

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
if(ketchup==false){
  imgPikachu.setAttribute("src","assets/img/pikachu"+direction+".png");
}
else{
  imgPikachu.setAttribute("src","assets/img/ketchup.png");
}

}


inputName.onkeydown=ajouterNom;
