import java.util.ArrayList;

public class Joueur {
	private ArrayList<Carte> main; //carte en main
	private ArrayList<Action> pile; //Chaque joueur a une pile d'Action devant lui (contraintes/solutions)
	private static int id=0;
	private int cpt;
	private int score; 
	private boolean estBloque; 
	
	public Joueur() {
		score=0;
		id++;
		cpt=id; 
		
		main= new ArrayList<Carte>();
		pile= new ArrayList<Action>();
		estBloque=false;
	}
	
	public int getId() {
		return cpt;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int m) {
		score+=m;
	}
	
	public ArrayList<Carte> getMain(){
		return main;
	}
	
	public void AjoutCarte(Carte c) {
		main.add(c);
	}
	
	public ArrayList<Action> getPile(){
		return pile; 
	}
	
	public void addCartePile(Action a) {
		pile.add(a);
	}
	
	public boolean getEstBloque() {
		return estBloque;
	}
	
	public boolean poserKm (Kilometre k, Jeu jeu) {
		for(int i=0; i<main.size();i++) {
			if(main.get(i)==k) {
				jeu.getPilePrincipale().add(k);
				setScore(k.getIdentifiant());
				System.out.println("La carte posée dans la principale est : "+main.get(i)+"\n");
				main.remove(k);
				return true;
			}
		}		
		
		return false;
	}
	
	/*public boolean poserContrainte(Contrainte c, Joueur joueurVise) { 
			for(int i=0; i<main.size();i++) {
				if(main.get(i)==c) {
					joueurVise.addCartePile(c);
					main.remove(c);
					joueurVise.estBloque=true;
					return true;
				}
			}	
			
			return false;
	}*/
	
	public boolean poserContrainte(Joueur joueurVise) { 
		for(int i=0; i<main.size();i++) {
			if(main.get(i) instanceof Contrainte) {
				joueurVise.addCartePile((Action) main.get(i));
				System.out.println("La contrainte posée est : "+main.get(i)+"\n");
				main.remove(main.get(i));
				joueurVise.estBloque=true;
				return true;
			}
		}	
		
		return false;
	}
	
	
	public boolean poserSolution() {
		if(pile.get(pile.size()-1) instanceof Contrainte) { //on regarde si la derniere carte de la pile du joueur est une contrainte
			for(int i=0;i<main.size();i++) {
				if(main.get(i) instanceof Solution && (pile.get(pile.size()-1).getIdentifiant())==(main.get(i).getIdentifiant())) {
					pile.add((Action) main.get(i));
					System.out.println("La solution posée est : "+main.get(i)+"\n");
					main.remove(main.get(i));
					estBloque=false;
					return true;
				}
				
			}
		}	
		return false;
	}
	
	public int indexKilometreMax() {// -1 = pas de kilometre dans la main !
		int maxKm=0;
		int iMax=-1;
		
		for(int i=0; i<main.size();i++) {
			if (main.get(i) instanceof Kilometre) {
				if(main.get(i).getIdentifiant()>maxKm) {
					maxKm=main.get(i).getIdentifiant();
					iMax=i;
				}
			}
		}
		
		return iMax;
	}
	
	
	public boolean atteint1000() {
		if(score>=1000) {
			return true;
		}
		return false;
	}
	
	public boolean plusCarteMain() {
		return main.isEmpty();
	}
	
	public String toString() {
		String s="Joueur"+cpt+" ";
		
		if(pile==null) {
			s+="Pas de Contrainte \n";
		}
		
		s+=" - Cartes en main: [";
		
		for(int i=0; i<main.size(); i++) { //parcours des cartes en main => ArrayList<Cartes>
			s+=main.get(i).toString(); 
			s+=";";
			
		}
		
		s+="]\n";
		
		return s;
	}
}
