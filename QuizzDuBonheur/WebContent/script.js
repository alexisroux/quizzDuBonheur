/*
 * fonction validator : permet de comparer les réponses du joueur et de compter les points 
*/

function validator(){
	//on selectionne toute la zone de réponse pour chaque question
	var tabElement = document.getElementsByClassName("bonne_rep");
	
	var nbReponsesOk = 0;
	
	for(var j=0;j<tabElement.length;j++){
		if(tabElement[j].checked){
			nbReponsesOk ++;
		}
	}
	//affichage du résultat
	if(nbReponsesOk <=10){
		alert("AHAHAHAH la honte ! Vous avez : "+nbReponsesOk+"/20, vous êtes nul !");
	} else if (nbReponsesOk > 10){
		alert("Bravo ! Vous avez : "+nbReponsesOk+"/20, vous déchirez !");
	}
	return nbReponsesOk;
	
}
