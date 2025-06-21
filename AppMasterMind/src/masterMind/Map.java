/**
 * 
 */
package masterMind;

import java.util.ArrayList;

/**
 * @author Gauthier BOÃ‹-GUIROLA
 * @author Mathieu VASSAL
 */
public abstract class Map extends MasterMind{

	public int largeur;
	public int longueur;
	
	/* Liste des combinaison */
	public static ArrayList<char[]> ligneMap = new ArrayList<>();
	public char[] correct;
	public ArrayList<String> resultat = new ArrayList<>();
	
	
	/**
	 * Constructeur avec des limites de terrains
	 */
	public Map(int largeur, int longueur) {
		super();
		
		this.largeur = largeur;
		this.correct = initialiseCorrecte(largeur);
		this.longueur = longueur;
		
		if(longueur > 0) {
			this.addLigneArray(longueur); // initialise l'Arraylist
		}
	}
	
	
	/**
	 * Initialise aléatoirement le tableau
	 * @param largeur taille de la largeur du terrain
	 * @return le taleau initialise
	 */
	public char[] initialiseCorrecte(int largeur) {
		
		char[] tab = new char[largeur];
		int indice;
		
		for(int i = 0; i < largeur; i++) {
			indice = (int) (Math.random() * TAB_COULEUR.length);
			tab[i] =  TAB_COULEUR[indice];
		}
		
		return tab;
	}
	
	/**
	 * Initialise la largeur du terrain 
	 * en y ajoutant une ligne en fonction de la longueur du terrain
	 * @param longueur taille de la longueur du terrain
	 */
	public void addLigneArray(int longueur) {
		for(int i = 0; i < longueur; i++) {
			this.ligneMap.add(new char[this.largeur]);
			this.resultat.add("");
		}
	}
	

	/**
	 * Donne une combinaison du tableau aléatoirement
	 * @param tab
	 * @param largeur
	 * @return
	 */
	public char[] tabAleatoire(char[] tab, int largeur) {
		
		char[] newTab = new char[largeur];
		int indice;
		
		for(int i = 0; i < largeur; i++) {
			indice = (int) (Math.random() * tab.length);
			newTab[i] = tab[indice];
			tab = reduceSizeTab(tab, indice);
		}
		
		return newTab; 
	}
	
	/**
	 * Réduit la taille du tableau de 1 en partant du début
	 * @param tab
	 * @param indice
	 * @return
	 */
	public char[] reduceSizeTab(char[] tab, int indice) {
		
		char[] newTab = new char[tab.length - 1];
		int i;
		int id = 0;
		
		for(i = 0; i < tab.length - 1; i++) {
			if(i == indice) {
				id++;
			}
			newTab[i] = tab[id];
			id++;
		}
		
		return newTab;
	}

	
	
	/**
	 * Lance le jeu et ne s'arrete que si le jour gagne ou perd
	 */
	public void joue() {
		
		boolean win = false;
		
		// Pour chaque ligne
		do {
			// si la longeur est ilimité on rajoute
			// une ligne Ã  chaque tour
			if(this.longueur <= 0) {
				this.addLigneArray(1); // initialise l'Arraylist
			}

			System.out.println(this.toString());

			System.out.print("Tour " + this.nbTour + " : ");
			System.out.println(Affichage.COULEUR);
			
			saisieCouleur();
			
			if(analyse()) {
				win = true;
			}
			
			this.nbTour++;
		}while((this.longueur <= 0 || this.nbTour < this.longueur) && !win);
		
		System.out.println(this.toString());
		
		// On affiche le résultat du jeu
		if(win) {
			System.out.println(Affichage.GAGNER);
		}else {
			System.out.println(Affichage.PERDU);
		}
	}

	/**
	 * Lance le jeu pour l'IA
	 */
	public void joueIA() {
		
		boolean win = false;
		char[] tab;
		 ArrayList<char[]> listCombinaison = new ArrayList<>();

		char[] couleur = this.nomCouleur();
		
		// Pour chaque ligne
		do {
			// si la longeur est ilimité on rajoute
			// une ligne Ã  chaque tour
			if(this.longueur <= 0) {
				this.addLigneArray(1); // initialise l'Arraylist
			}
			
			tab = tabAleatoire(couleur, this.largeur);
			
			
			// On ajoute un tableau aléatoirement
			this.ligneMap.set(this.nbTour, tab);

			
			if(analyse()) {
				win = true;
			}
			
			this.nbTour++;
		}while((this.longueur <= 0 || this.nbTour < this.longueur) && !win);
		
		System.out.println(this.toString());
		
		// On affiche le résultat du jeu
		if(win) {
			System.out.println(Affichage.GAGNER);
			System.out.println("En " + this.nbTour + " coups");
		}else {
			System.out.println(Affichage.PERDU);
		}
	}
	
	
	/**
	 * Analyse la derniÃ¨re ligne saisie par l'utilisateur
	 * Envoie au tableau resultat un texte indiquant l'avancé du joueur
	 * dans le jeu
	 * @return true si ligne correspond complétement, false sinon
	 */
	public boolean analyse() {

		int nbBienPlacee = 0;
		int nbMalPlacee = 0;
		
		//char[] sav = this.correct;
		char[] sav = new char[this.largeur];
		for(int l = 0; l < this.largeur; l++) {
			sav[l] = this.correct[l];
		}
		
		// Parcour la ligne du terrain
		for(int k = 0; k < this.largeur; k++) {
					
			// Si est bien placé
			if(this.ligneMap.get(this.nbTour)[k] == correct[k]) {
				nbBienPlacee++;
				sav[k] = 0;	// on le met a 0 pour qu'il ne compte plus
			}
		}
		
		// Parcour la ligne du terrain
		for(int i = 0; i < this.largeur; i++) {
			
			// sinon on regarde si elle est présente dans le terrain
			for(int j = 0; j < this.largeur; j++) {
				if(i != j && this.ligneMap.get(this.nbTour)[i] == sav[j]) {
					nbMalPlacee++;
					sav[j] = 0;	// on le met a 0 pour qu'il ne compte plus
					break;
				}
			}
		}
		
		this.resultat.set(nbTour, nbBienPlacee + " bien placée(s) et " + nbMalPlacee + " mal placée(s)");
		
		return nbBienPlacee == this.largeur;
	}
	
	/**
	 * Analyse la derniÃ¨re ligne saisie par l'IA
	 * @return retourne le nombre de couleur présente sur la ligne
	 * 			saisie par l'utilisateur
	 */
	public int analyseIA() {

		int nbBienPlacee = 0;
		int nbMalPlacee = 0;
		
		//char[] sav = this.ligneMap.get(nbTour);
		char[] sav = new char[this.largeur];
		for(int l = 0; l < this.largeur; l++) {
			sav[l] = this.correct[l];
		}
		
		// Parcour la ligne du terrain
		for(int k = 0; k < this.largeur; k++) {
					
			// Si est bien placé
			if(this.ligneMap.get(this.nbTour)[k] == correct[k]) {
				nbBienPlacee++;
				sav[k] = 0;	// on le met a 0 pour qu'il ne compte plus
			}
		}
		
		// Parcour la ligne du terrain
		for(int i = 0; i < this.largeur; i++) {
			
			// sinon on regarde si elle est présente dans le terrain
			for(int j = 0; j < this.largeur; j++) {
				if(i != j && this.ligneMap.get(this.nbTour)[i] == sav[j]) {
					nbMalPlacee++;
					sav[j] = 0;	// on le met a 0 pour qu'il ne compte plus
					break;
				}
			}
		}
		
		return nbBienPlacee + nbMalPlacee;
	}
	
	
	/**
	 * Affiche le terrain en format toString
	 */
	public String toString() {
		String txt = Affichage.PANCARTE_TERRAIN;
		char[] ligne;
		
		final String BARRE = "\n" + "----".repeat(this.largeur) + "-\n";

		// On affiche la version correcte pour les testes
		txt += BARRE;
		for(int k = 0; k < this.largeur; k++) {
			txt += "| " + correct[k] + " ";
		}
		txt += "| Ligne correcte" + BARRE;
		

		txt += BARRE;
		for(int i = 0; i < this.ligneMap.size(); i++) {
			ligne = this.ligneMap.get(i);
			for(int j = 0; j < this.largeur; j++) {
				txt += "| " + ligne[j] + " ";
			}
			
			// Affiche le résultat de la ligne
			txt += "| " + this.resultat.get(i);
			
			txt += BARRE;
		}
		
		return txt;
	}


	public abstract char[] nomCouleur();
	
	public abstract void saisieCouleur();
}
