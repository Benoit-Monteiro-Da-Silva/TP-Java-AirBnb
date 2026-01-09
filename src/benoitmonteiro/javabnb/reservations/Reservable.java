package benoitmonteiro.javabnb.reservations;

public interface Reservable {

    //Les méthodes d'interface sont par défaut 'public' et 'abstract'

    boolean aUneDateArriveeCorrect();

    boolean aUnNombreDeNuitsCorrect();

    boolean aUnNombreDeVoyageursCorrect();

    void afficher();

}
