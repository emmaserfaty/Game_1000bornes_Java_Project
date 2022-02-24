public class Kilometre extends Carte {
	
	public Kilometre(int identifiant){ 
		super(identifiant);	
		
	}

	public int getIdentifiant() {
		return identifiant;
	}

	public String toString() {
		return identifiant+"kms ";
	}

}
