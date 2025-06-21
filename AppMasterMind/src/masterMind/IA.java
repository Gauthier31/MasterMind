package masterMind;

import java.util.ArrayList;

/**
 * @author Gauthier BOÃ‹-GUIROLA
 * @author Mathieu VASSAL
 */
public class IA extends Map {


	public static ArrayList<char[]> combinaison = new ArrayList<>();
	
	public IA(int largeur, int longueur) {
		super(largeur, longueur);
	}

	/**
	 * Donne le nom des couleurs présente dans la ligne correcte
	 */
	public char[] nomCouleur() {
		
		int nbCouleurPlacee = 0;
		char[] couleur = new char[this.largeur];
		int nbCouleur;
		

		// on regarde qu'elles sont les couleurs dans la ligne
		for(int i = 0; i < TAB_COULEUR.length
						&& nbCouleurPlacee < this.largeur; i++) {
			
			// si la longeur est ilimité on rajoute
			// une ligne Ã chaque tour
			if(this.longueur <= 0) {
				this.addLigneArray(1); // initialise l'Arraylist
			}
			
			
			// On met a mÃªme couleur sur toute la ligne
			for(int j = 0; j < this.largeur; j++) {
				this.ligneMap.get(this.nbTour)[j] = TAB_COULEUR[i];
			}
			
			nbCouleur = analyseIA();
			for(int k = 0; k < nbCouleur; k++) {
				couleur[nbCouleurPlacee] = TAB_COULEUR[i];
				nbCouleurPlacee++;
			}
			
			analyse();
			this.nbTour++;
		}
		
		// On génÃ¨re la liste des combinaisons des couleurs
		//generateList(couleur);
		
		System.out.println(this.toString());
		
		return couleur;
	}
	
	
	public void saisieCouleur() {
	}
	
	/**
	 * Génére la liste des ligne possible avec 4 couleurs max
	 * EmpÃªche les doublons si jamais il y a plusieur fois la mÃªme couleur
	 */
	public ArrayList<char[]> generateList(char[] list) {	
		
		int taille = list.length;
		ArrayList<char[]> array = new ArrayList<>();
		
		for(int i = 0; i < list.length; i++) {
			
			/*
			if(!.equals()) {
				array.add(list);
			}
			*/
		}
		
		return array;
	}
	
	
	/**
	 * Regarde si deux ligne sont identique
	 * @return
	 */
	public boolean equals(char[] tab) {
		
		for(int i = 0; i < this.largeur; i++) {
			/*
			if(this.[i] != tab[i]) {
				return true;
			}
			*/
		}
		
		return false;
	}
}
