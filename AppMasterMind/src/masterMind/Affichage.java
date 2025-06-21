package masterMind;

/**
 * @author Gauthier BOÃ‹-GUIROLA
 * @author Mathieu VASSAL
 */
public class Affichage {

	public static final String COULEUR = 
			"Couleur :\n"
			+ "J -> jaune | B -> bleu | G -> gris   | R -> rouge  |"
		+ "\nV -> vert  | N -> noir | M -> marron | O -> Orange |\n";
	
	public static final String PANCARTE_TITRE = 
			"""
				--------------------------------------------------
				|                   MasterMind                   |
				--------------------------------------------------\n\n """;
	
	public static final String PANCARTE_INITIALISATION = 
			"""
				--------------------------------------------------
				|                 Initialisation                 |
				--------------------------------------------------\n\n """;
	
	public static final String PANCARTE_TERRAIN = 
			"""
				--------------------------------------------------
				|                     Terrain                    |
				--------------------------------------------------\n""";
	
	public static final String CHOIX_1 = 
			PANCARTE_TITRE + 
			"""
					1) Jouer tous seul
					2) Ordinateur tous seul
					 
					Veuillez saisir votre choix: """;
	
	public static final String GAGNER = 
			"""
				-------------------- YOU WIN ---------------------""";
	
	public static final String PERDU = 
			"""
				-------------------- GAME OVER -------------------""";
}
