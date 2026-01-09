package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;

public class SejourLong extends Sejour {

    private final int prix;
    private final int promotion;
    private static final int PROMOTION_EN_POURCENTAGE = 20;

    public SejourLong(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, paramNbVoyageurs);

        promotion = this.getLogement().getTarifParNuit() * this.getNbNuits() * PROMOTION_EN_POURCENTAGE / 100;
        prix = this.getLogement().getTarifParNuit() * this.getNbNuits() - promotion;
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour est de " + prix + "€ (" + promotion + "€ de promotion)");  
    }

}
