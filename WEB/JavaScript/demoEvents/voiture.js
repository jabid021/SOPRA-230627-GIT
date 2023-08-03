
var posX = 30;
var posY = 35;
var couleurVoiture="red";
var deplacement = 30;

startCar.onclick= function()
{
document.body.onkeydown = bougerVoiture;
startCar.disabled=true;
}


voiture.onclick=function()
{
    couleurVoiture = (couleurVoiture=="red") ? "blue": "red";
    imgCar.setAttribute("src",`${couleurVoiture}.gif`);
}


 function bougerVoiture(event)
{
  if(event.key=="z" || event.key=="ArrowUp")
  {
    posY+=deplacement;
    voiture.style.bottom=`${posY}px`;
    voiture.style.transform="rotate(90deg)";
  }
  else if(event.key=="s" || event.key=="ArrowDown")
  {
    posY-=deplacement;
    voiture.style.bottom=`${posY}px`;
    voiture.style.transform="rotate(-90deg)";
  }
  else  if(event.key=="q" || event.key=="ArrowLeft")
  {
    posX+=deplacement;
    voiture.style.right=`${posX}px`;
    voiture.style.transform="scaleX(1)";
  }
  else if(event.key=="d" || event.key=="ArrowRight")
  {
    posX-=deplacement;
    voiture.style.right=`${posX}px`;
    voiture.style.transform="scaleX(-1)";
  }
}
