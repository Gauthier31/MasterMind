package masterMind;

import java.util.ArrayList;

/**
 * @author Gauthier BOÃ‹-GUIROLA
 * @author Mathieu VASSAL
 */
public class MasterMind {

	
	public int nbTour;
	
	public static final char[] TAB_COULEUR = {'J', 'B', 'G', 'R', 'V', 'N', 'M', 'O'};  
	
	/**
	 * Constructeur de MasterMind
	 */
	public MasterMind() {
		super();

		this.nbTour = 0;
	}
	
	public void afficheTab(char[] tab) {
		
		String txt = "[";
		for(int i = 0; i < tab.length; i++) {
			txt += tab[i] + ", ";
		}
		System.out.println(txt + "]");
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.print(Affichage.CHOIX_1);
		
		int[] choix1 = {1, 2};
		int reponse1 = Saisie.saisieIntIntervalle(choix1);
		
		// int reponse1 = 2;

		
		System.out.print("\n" + Affichage.PANCARTE_INITIALISATION);
		
		System.out.print("Veuillez saisir la largeur du terrain : ");
		int largeur = Saisie.saisieInt();
		System.out.print("Veuillez saisir la longueur du terrain\n"
						+ "                    (<= 0 si illimité) : ");
		int longueur = Saisie.saisieInt();
		
		/*
		int largeur = 4;
		int longueur = -1;
		*/
		
		if(reponse1 == 1) {
			
			Map masterMind = new Joueur(largeur, longueur);
			
			masterMind.joue();
		} else {
			Map masterMind = new IA(largeur, longueur);
			
			masterMind.joueIA();
		}	
		
		System.out.println("Programme terminé");
	}


}
