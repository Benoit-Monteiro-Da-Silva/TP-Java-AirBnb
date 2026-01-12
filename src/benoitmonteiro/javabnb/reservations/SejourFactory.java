package benoitmonteiro.javabnb.reservations;

import java.util.Date;
import benoitmonteiro.javabnb.logements.Logement;


//'Final' for a class means that this class can't have children
public final class SejourFactory {

    private SejourFactory(){}

    public static Sejour creerSejour(Date dateSejour, int nbNuits, int nbVoyageurs, Logement logementVacances) {
        Sejour sejour;
        if(nbNuits <= 5) {
            sejour = new SejourCourt(dateSejour, nbNuits, logementVacances, nbVoyageurs);
        } else {
            sejour = new SejourLong(dateSejour, nbNuits, logementVacances, nbVoyageurs);
        }
        return sejour;
    }


}
