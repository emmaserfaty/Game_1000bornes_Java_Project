
public class TestJeu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Jeu jeu= new Jeu(3);

		jeu.creerJoueur();
		jeu.creer();//pioche - distribution de carte au joueur 
		System.out.println(jeu.toString()); // vu d'ensemble du jeu ARBITRAIRE 
		//jeu.jouer();
		jeu.jouer2();

	}

}
