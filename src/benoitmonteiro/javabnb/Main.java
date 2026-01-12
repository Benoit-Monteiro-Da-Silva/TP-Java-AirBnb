package benoitmonteiro.javabnb;

import benoitmonteiro.javabnb.logements.Appartement;
import benoitmonteiro.javabnb.logements.Maison;
import benoitmonteiro.javabnb.outils.Utile;
import benoitmonteiro.javabnb.utilisateurs.Voyageur;
import benoitmonteiro.javabnb.utilisateurs.Hote;
import benoitmonteiro.javabnb.reservations.Reservation;
import benoitmonteiro.javabnb.reservations.SejourCourt;
import benoitmonteiro.javabnb.reservations.SejourLong;


public class Main {

    public static void main(String[] args) {

        Voyageur alain = new Voyageur("Alain", "Dupont", 28);
        Hote justine = new Hote("Justine", "Cerise", 19, 3 );

        Maison chezMoi = new Maison(
            justine, 
            80, 
            "14 rue Colbert, 37000 Tours", 
            70, 
            4, 
            50, 
            true);

        Appartement chezLui = new Appartement(
            justine, 
            50, 
            "7 rue du Grenier, 41000 Blois", 
            25, 
            2, 
            0, 
            4);

        SejourCourt lesPetitesVacances = new SejourCourt(Utile.createDate(9, 12, 2026), 4, chezLui, 2);
        SejourLong lesGrandesVacances = new SejourLong(Utile.createDate(25, 8, 2026), 10, chezMoi, 4);

        Reservation lesPetitesVacancesReservees = new Reservation(lesPetitesVacances, alain);
        Reservation lesGrandesVacancesReservees = new Reservation(lesGrandesVacances, alain);

        // lesPetitesVacancesReservees.afficher();
        lesGrandesVacancesReservees.afficher();

    }

}
