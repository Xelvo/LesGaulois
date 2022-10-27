package personnages;

public class Gaulois {
	private String nom;
	private int force, nb_trophees;
	private int effetPotion = 1;
	private Equipement trophees[] = new Equipement[100];
	
	public Gaulois(String nom, int force) {
		super();
		this.nom = nom;
		this.force = force;
	}
	
	public int getForce() {
		return force;
	}

	public void setForce(int force) {
		this.force = force;
	}
	
	public int getEffetPotion() {
		return effetPotion;
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

//	private String prendreParole() {
//		String coucou = "Le gaulois " + nom + " : ";
//		System.out.print(coucou);
//		return coucou;
//		
//	}
	
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";

		
	}

//	public void frapper(Romain romain) {
//		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
//		romain.recevoirCoup((force / 3) * effetPotion);
//	}

	@Override
	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
		
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix", 8);
		Romain minus = new Romain("Minus", 6);
		Druide panoramix = new Druide("Panoramix",5,10);
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.frapper(minus);
		panoramix.preparerPotion();
		asterix.boirePotion(panoramix.effetPotionPreparee);

	}
	
	private String prendreParole() {
		String texte = "Le gaulois " + nom + " : ";
		return texte;
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		trophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; trophees != null && i < trophees.length; i++, nb_trophees++) {
			this.trophees[nb_trophees] = trophees[i];
		}
	}
	
	public void boirePotion(int effetPotionPreparee) {
		effetPotion = effetPotionPreparee;
		parler("Merci Druide, je sens ma force est"+effetPotion + " fois décuplé");
	}
	
}


