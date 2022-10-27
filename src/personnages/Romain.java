package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements = new Equipement[2];
	private int nbEquipement = 0;
	private String texte;

	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		assert (force>=0);
	}

	public String getNom() {
		return nom;
	}

	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}

	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

//	public void recevoirCoup(int forceCoup) {
//		int forceInit = force;
//		assert (forceCoup>0);
//		force -= forceCoup;
//		if (force > 0) {
//			parler("Aïe");
//		}
//		else {
//			parler("J'abandonne...");
//		}
//		assert (force<forceInit);
//	}
	
	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		// précondition
		assert (force > 0);
		int oldForce = force;
		
		forceCoup = CalculResistanceEquipement(forceCoup);
		
		force -= forceCoup;
		if (force == 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
//		switch (force) {
//		case 0:
//			parler("Aïe");
//		default:
//			equipementEjecte = ejecterEquipement();
//			parler("J'abandonne...");
//			break;
//		}
		// post condition : la force à diminuer
		assert force < oldForce;
		return equipementEjecte;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom.toString() + "s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] == null) {
				continue;
			} else {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
	}	

	private int CalculResistanceEquipement(int forceCoup) {
		texte = "Ma force est de " + this.force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (!(nbEquipement == 0)) {
			texte += "Mais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement; i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				}
				else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
				i++;
			}
			texte =+ resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= resistanceEquipement;
		return forceCoup;
	}
				    
	public String toString() {
		return "Romain [nom = " + nom + ", force = " + force + "]";
	}
		
	public void equipe(Equipement equip) {
		System.out.println("Le soldat" + nom + " s'équipe avec un " + equip.getNom() + "!");
		nbEquipement ++;
		equipements[nbEquipement - 1] = equip;
	}
				    
	public void sEquiper(Equipement equip) {
		switch(nbEquipement) {
			case 2 : System.out.println("Le soldat " + nom + " est deja bien protégé !");
					break;
			case 1 : if (equipements[0] == equip) {
				System.out.println("Le soldat " + nom + " possede déjà" + equip.getNom() + "!");
				}
			else {
				equipe(equip);
			}
				break;
			case 0 : 
				equipe(equip);
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus", 6);
		System.out.println(minus);
		System.out.println(minus.prendreParole());
		minus.parler("test");
		minus.recevoirCoup(2);
		System.out.println(Equipement.CASQUE);
		System.out.println(Equipement.BOUCLIER);
		minus.sEquiper(Equipement.CASQUE);
		minus.sEquiper(Equipement.CASQUE);
	}
}
