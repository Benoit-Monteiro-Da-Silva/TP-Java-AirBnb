package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;

public class SejourCourt extends Sejour {

    //Constructor has 'package' visibility so that 'Main' can't use it but 'SejourFactory' can
    SejourCourt(Date paramDateArrivee, int paramNbNuits, Logement paramLogement, int paramNbVoyageurs) {
        super(paramDateArrivee, paramNbNuits, paramLogement, paramNbVoyageurs);
    }

    @Override
    public void afficher() {
        super.afficher();
        System.out.println("Le prix de ce séjour court est de " + this.prix + "€.");  
    }

    @Override
    public boolean aUnNombreDeNuitsCorrect() {
        return (this.getNbNuits() >= 1) && (this.getNbNuits() <= 5); 
    }

    @Override
    public void miseAJourDuPrixDeSejour() {
        this.prix = this.getLogement().getTarifParNuit() * this.getNbNuits();        
    }

}
