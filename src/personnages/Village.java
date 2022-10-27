package personnages;

public class Village {
	private String nom; 
	private Chef chef;
	private int nbVillageois = 0;
	private int nbVillageoisMaximum = 30;
	private Gaulois[] villageois;
	
	public Village(String nom,int nbVillageoisMaximum ) { 
		this.nom = nom; 
		villageois = new Gaulois[nbVillageoisMaximum]
	} 
	
	public void setChef(Chef chef) { 
		this.chef = chef; 
	} 
	
	public String getNom() { 
		return nom; 
	}
	
	public void ajouterHabiant(Gaulois gaulois) { 
		villageois[nbVillageois] = gaulois;
		nbVillageois += 1;
	}
	
	public Gaulois trouverHabitant(int nbVillageois) {
		return villageois[nbVillageois];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans "+ getNom() + " du chef " + chef.getNom() + " vivent les légendaires gaulois : ");
		for(int i = 0; i<nbVillageois ; i++) {
			Gaulois gaulois = trouverHabitant(i);
			System.out.println(gaulois);
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles",30);
		Gaulois asterix = new Gaulois("Asterix",8);
		Gaulois obelix = new Gaulois("Obelix",25);
		Chef abraracourcix = new Chef("Abraracourcix",6,0,village);
		village.setChef(abraracourcix);
		village.ajouterHabiant(asterix);
		village.ajouterHabiant(obelix);
		village.afficherVillageois();
	}
	
}
