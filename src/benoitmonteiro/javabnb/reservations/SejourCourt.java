package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;

public class SejourCourt extends Sejour {

    private final int prix;

    public SejourCourt(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int nbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, nbVoyageurs);
        prix = this.getLogement().getTarifParNuit() * this.getNbNuits();
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de " + prix + "€.");  
    }

}
