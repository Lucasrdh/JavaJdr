public class GameView {

    public void welcome() {
        System.out.println("Bienvenue dans mon jeu !");
    }

    public void afficherPosition(int position) {
        System.out.println("Tu avances à la case : " + (position + 1));
    }
    public void afficherVictoire() {
        System.out.println("Tu est arriver à la dernière case ! Tu as gagné bravo !");
    }
    public void afficherTouche(){
        System.out.println("Appuie sur 'espace' pour avancer, 'b' pour les infos de ton personnage, 'q' pour quitter");

    }
    public void concentre(){
        System.out.println("Concentre toi stp..");
    }
}
