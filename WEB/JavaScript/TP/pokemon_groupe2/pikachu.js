//1) saisir le nom du pokemon et valider avec le bouton (le nom ne doit pas etre vide !)
//2) Masquer la div formStart, Afficher la div grass, mettre le nom du pokemon en title sur la div pikachu
//3) Gerer les deplacements, pouvoir bouger dans toutes les directions (haut,bas,gauche,droite) => les fleches et / ou zqsd
//4) Modifier la position de la div pikachu en fonction de la direction (+-30px par deplacement) et changer l'image
//5) Verifier que pikachu ne sort pas de la div grass

var posX;
var posY;
var pokemon="pikachu";
var direction="Down";
var name;
var step = 30;
var posXPierre;
var posYPierre;

const image2 = document.getElementById("image2");
const image3 = document.getElementById("image3");
const image4 = document.getElementById("image4");
let posX2 = -image2.clientWidth+100; // Position initiale en dehors du cadre
let posY2 = -image2.clientHeight+150; // Position initiale en dehors du cadre
let posX3 = window.innerWidth - image2.clientWidth-150; // Position initiale à droite de l'écran
let posY3 = Math.random() * (window.innerHeight - image2.clientHeight)-300; // Position verticale aléatoire dans la fenêtre
let posX4 = window.innerWidth - image2.clientWidth-200; // Position initiale à droite de l'écran
let posY4 = Math.random() * (window.innerHeight - image2.clientHeight)-300; // Position verticale aléatoire dans la fenêtre

//imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");

image2.style.left = posX2 + "px";
image2.style.top = posY2 + "px";

image3.style.left = posX3 + "px";
image3.style.top = posY3 + "px";

image4.style.left = posX4 + "px";
image4.style.top = posY4 + "px";

let isAlternateImage3 = false;
let isAlternateImage4 = false;

btnStart.onclick = lancerAventure;
document.body.onkeydown = deplacement;
var startSound = document.getElementById("startSound");
var evolveSound = document.getElementById("evolveSound");
var thunder = document.getElementById("imgThunder");

inputName.onkeyup= function(event)
{
  if(event.key=="Enter" && inputName.value!="")
  {
    lancerAventure();
  }

  name = inputName.value;
  if(name=="")
  {
    bloquerButton();
  }
  else
  {
    btnStart.disabled=false;
  }
};


function bloquerButton()
{
  btnStart.disabled=true;
}

function lancerAventure()
{
  startSound.play();
  imgPikachu.title = name;
  formStart.style.display="none";
  grass.style.display="block";
  posX=0;
  posY=0;
  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+"Down.png");
  aleaThunder(670, 0, 30);
  image2.style.display="block";
  image3.style.display="block";
  image4.style.display="block";
  deplacerImageRandom();
}

function deplacement(event)
{
  if(event.key=="ArrowDown" || event.key=="s" )
  {
    posY+=step;
    direction="Down";
  }
  else if(event.key=="ArrowRight" || event.key=="d" )
  {
    posX+=step;
    direction="Right";
  }

  else if(event.key=="ArrowLeft" || event.key=="q")
  {
    posX-=step;
    direction="Left";
  }

  else if(event.key=="ArrowUp" || event.key=="z")
  {
    posY-=step;
    direction="Up";
  }

  // Vérification pour s'assurer que l'image reste dans le cadre
  posX = Math.max(0, Math.min(posX, grass.clientWidth - imgPikachu.clientWidth));
  posY = Math.max(0, Math.min(posY, grass.clientHeight - imgPikachu.clientHeight));

  pikachu.style.top=posY+"px";
  pikachu.style.left=posX+"px";
  imgPikachu.setAttribute("src","assets/img/"+pokemon+direction+".png");


  if(posX == posXPierre && posY == posYPierre){
    evolve();
  }
}

function aleaThunder(max, min, pas) {
  const deltaX2 = Math.floor(Math.random() * ((max - min)/pas + 1))*pas + min;
  const deltaY2 = Math.floor(Math.random() * ((max - min)/pas + 1))*pas + min;

  imgThunder.style.left = deltaX2 + "px";
  imgThunder.style.top = deltaY2 + "px";
  posXPierre=deltaX2;
  posYPierre=deltaY2
}

function evolve(){
  thunder.style.display="none";
  pokemon="raichu";
  imgPikachu.setAttribute("src", "assets/img/raichuDown.png");
  imgPikachu.style.width = 60 + "px";
  imgPikachu.style.height = 60 + "px";
  evolveSound.play();
}

// Fonction pour gérer l'alternance des images de l'image 3
function alternerImage3() {
  if (isAlternateImage3) {
    image3.src = "assets/img/babimanta_front2.png";
  } else {
    image3.src = "assets/img/babimanta_front1.png";
  }
  isAlternateImage3 = !isAlternateImage3;
}

// Fonction pour gérer l'alternance des images de l'image 3
function alternerImage4() {
  if (isAlternateImage4) {
    image4.src = "assets/img/arakdo_front2.png";
  } else {
    image4.src = "assets/img/arakdo_front1.png";
  }
  isAlternateImage4 = !isAlternateImage4;
}

// Fonction pour déplacer la deuxième image de manière aléatoire
function deplacerImageRandom() {
  const deltaX2 = Math.random() < 0.5 ? -step : step;
  const deltaY2 = Math.random() < 0.5 ? -step : step;

  const newPosX2 = posX2 + deltaX2;
  const newPosY2 = posY2 + deltaY2;

  // Vérification pour s'assurer que l'image 2 ne rentre pas dans le cadre
  if (
    newPosX2 < 0 ||
    newPosY2 < 0 ||
    newPosX2 + image2.clientWidth > (window.innerWidth * 20 / 100) ||
    newPosY2 + image2.clientHeight > window.innerHeight ||
    (newPosX2 > posX && newPosX2 < posX + imgPikachu.clientWidth && newPosY2 > posY && newPosY2 < posY + imgPikachu.clientHeight)
  ) {
    // Ne met pas à jour les coordonnées si le déplacement conduit à une position non souhaitée
  } else {
    posX2 = newPosX2;
    posY2 = newPosY2;
  }

  image2.style.left = posX2 + "px";
  image2.style.top = posY2 + "px";
  alternerImage3();
  alternerImage4();

  // Déplacer les images 2 et 3 toutes les 500 ms
  setTimeout(deplacerImageRandom, 250);
}
