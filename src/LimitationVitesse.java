public class LimitationVitesse extends Contrainte{
	public LimitationVitesse(){
		super(4);
	}
	
	public String toString() {
		return "Contrainte "+identifiant+" : Limitation de vitesse ";
	}
}
