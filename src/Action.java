public abstract class Action extends Carte{
	//IDENTIFIANT type 1,2 etc...

	public Action(int identifiant) {
		super(identifiant);	
	}
	
	public int getIdentifiant() {
		return identifiant;
	}
	
	public abstract String toString();
	
}
