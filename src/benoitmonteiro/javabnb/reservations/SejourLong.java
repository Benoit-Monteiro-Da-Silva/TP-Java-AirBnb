package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;

public class SejourLong extends Sejour {

    private int promotion;
    private static final int PROMOTION_EN_POURCENTAGE = 20;

    //Constructor has 'package' visibility so that 'Main' can't use it but 'SejourFactory' can
    SejourLong(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, paramNbVoyageurs);
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour long est de " + this.prix + "€ (" + promotion + "€ de promotion)");  
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return this.getNbNuits() >= 6 && this.getNbNuits() <= 31; 
    }

    @Override
    public void miseAJourDuPrixDeSejour() {
        promotion = this.getLogement().getTarifParNuit() * this.getNbNuits() * PROMOTION_EN_POURCENTAGE / 100;
        this.prix = this.getLogement().getTarifParNuit() * this.getNbNuits() - promotion;    
    }

}
