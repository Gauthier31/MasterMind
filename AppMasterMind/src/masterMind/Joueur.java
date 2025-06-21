package masterMind;

public class Joueur extends Map {

	public Joueur(int largeur, int longueur) {
		super(largeur, longueur);
	}

	@Override
	public char[] nomCouleur() {
		return null;
	}
	
	public void saisieCouleur() {
		// On regarde dans 
		for(int i = 0; i < this.largeur; i++) {
			System.out.print("Veuillez saisir La couleur dans la case " 
								+ (i + 1) + " : ");
			char val = Saisie.saisieCharIntervalle(TAB_COULEUR);
			this.ligneMap.get(this.nbTour)[i] = val;
		}
	}
}
