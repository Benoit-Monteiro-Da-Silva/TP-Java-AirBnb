package benoitmonteiro.javabnb.reservations;

public interface Reservable {

    boolean aUneDateArriveeCorrect();

    boolean aUnNombreDeNuitsCorrect();

    boolean aUnNombreDeVoyageursCorrect();

    void afficher();

}
