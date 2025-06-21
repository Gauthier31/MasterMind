package masterMind;

import java.util.Scanner;

/**
 * @author Gauthier BOË-GUIROLA
 * @author Mathieu VASSAL
 */
public class Saisie {

	/** Saisie de l'utilisateur */
    public static Scanner entree = new Scanner(System.in);
    

	public static int saisieInt() {
		boolean correct = false;
		int value = -1;
		
		do {
			// si entree est correcte
			if(entree.hasNextInt()) {
				value = entree.nextInt();
				correct = true;
			}
            entree.nextLine();
			
		}while(!correct);		
		
		return value;
	}
	
	public static char saisieChar() {
		boolean correct = false;
		char value = '0';
		
		do {
			// si entree est correcte
			if(entree.hasNext()) {
				value = entree.next().charAt(0);
				correct = true;
			}
            entree.nextLine();
			
		}while(!correct);		
		
		return value;
	}

	public static int saisieIntIntervalle(int[] tab) {
		
		boolean correct = false;
		int value = -1;
		
		do {
			// si entree est correcte
			if(entree.hasNextInt()) {
				value = entree.nextInt();
				
				// Si compris dans le tableau
				for(int i = 0; i < tab.length; i++) {
					if(tab[i] == value) {
						correct = true;
						break;
					}
				}
			}
            entree.nextLine();
			
		}while(!correct);		
		
		return value;
	}
	
	public static char saisieCharIntervalle(char[] tab) {
		
		boolean correct = false;
		char value = '0';
		
		do {
			// si entree est correcte
			if(entree.hasNext()) {
				value = entree.next().toUpperCase().charAt(0);
					
				// Si compris dans le tableau
				for(int i = 0; i < tab.length; i++) {
					if(tab[i] == value) {
						correct = true;
					}
				}
			}
            entree.nextLine();
			
		}while(!correct);		
		
		return value;
	}
	
	public static void saisieIA(char valeur, int indice) {
		
	}
}
