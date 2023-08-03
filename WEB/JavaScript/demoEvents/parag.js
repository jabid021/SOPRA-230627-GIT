paragPrinci.onmouseover = function()
{
  document.querySelector("#spoil span").style.display="block";
};

paragPrinci.onmouseout = function()
{
    document.querySelector("#spoil span").style.display="none";
};

couleurTexte.onchange = function()
{
  couleur = couleurTexte.value;
  paragPrinci.style.color=couleur;

};


resetCouleur.onclick = function()
{
  paragPrinci.style.color="black";
  couleurTexte.value="#000000";
}
