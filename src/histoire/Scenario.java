package histoire;
import personnages.Romain;
import personnages.Gaulois;
import personnages.Druide;


public class Scenario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Romain minus = new Romain("Minus",6);
		Gaulois asterix = new Gaulois("Asterix",8);
		Druide panoramix = new Druide("Panoramix",5,10);
		Gaulois obelix = new Gaulois("Obélix",10);
		panoramix.parler ("Je vais aller préparer une petite potion");
		panoramix.preparerPotion();
		panoramix.booster(obelix);
		obelix.parler("Par Bélénos, ce n´est pas juste !);
		asterix.parler("Bonjour");
		minus.parler("UN GAU... UN GAUGAU...");
		asterix.frapper(minus);
		asterix.frapper(minus);
		asterix.frapper(minus);	 
	}

}
