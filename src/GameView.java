/**
 * Classe qui gère l'affichage du jeu.
 * Cette classe est responsable de l'affichage des messages à l'utilisateur,
 * comme les instructions, les positions du joueur, les victoires, et les erreurs.
 */
public class GameView {

    /**
     * Affiche un message de bienvenue lorsque le jeu commence.
     * Ce message explique brièvement le but du jeu.
     */
    public void welcome() {
        System.out.println("Bienvenue dans le jeux de plateau D&D ! Ton but est d'arriver à la case final sans mourir ! Tu trouveras sur ta route des choses insane !");
    }

    /**
     * Affiche la position actuelle du joueur sur le plateau.
     * @param position La position actuelle du joueur (indexé de 0 à n-1).
     */
    public void afficherPosition(int position) {
        System.out.println("Tu avances à la case : " + (position + 1));
    }

    /**
     * Affiche un message de victoire lorsque le joueur atteint la dernière case du plateau.
     */
    public void afficherVictoire() {
        System.out.println("Tu es arrivé à la dernière case ! Tu as gagné bravo !");
    }

    /**
     * Affiche les commandes disponibles pour le joueur.
     * Les touches disponibles sont 'espace' pour avancer,
     * 'b' pour afficher les informations du personnage, et 'q' pour quitter.
     */
    public void afficherTouche() {
        System.out.println("Appuie sur 'espace' pour avancer, 'b' pour les infos de ton personnage, 'q' pour quitter");
    }

    /**
     * Affiche un message d'encouragement pour rappeler au joueur de se concentrer.
     */
    public void concentre() {
        System.out.println("Concentre toi stp..");
    }

    /**
     * Affiche un message de fin de jeu avec un message personnalisé,
     * généralement utilisé lorsqu'une condition de fin de jeu est remplie.
     * @param message Le message personnalisé à afficher à la fin du jeu.
     */
    public void afficherFinJeu(String message) {
        System.out.println(message);
    }
}
