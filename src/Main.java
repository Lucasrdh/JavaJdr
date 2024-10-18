/**
 * Classe principale pour lancer le jeu.
 * Elle est responsable de la création et du démarrage du jeu.
 */
public class Main {

    /**
     * Méthode principale pour exécuter le jeu.
     * Elle crée une instance de la classe Game et démarre le jeu.
     *
     * @param args Les arguments de la ligne de commande (non utilisés ici).
     */
    public static void main(String[] args) {
        // Création d'une instance de la classe Game
        Game game = new Game();

        // Démarrage du jeu
        game.start();
    }
}
