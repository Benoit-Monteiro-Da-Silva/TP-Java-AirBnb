package benoitmonteiro.javabnb;

import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.utilisateurs.Personne;
import benoitmonteiro.javabnb.reservations.Sejour;
import java.util.Date;


public class Main {

    public static void main(String[] args) {

        Personne alain = new Personne("Alain", "Dupont", 28);
        Personne justine = new Personne("Justine", "Cerise", 19 );

        Logement chezMoi = new Logement(justine, 20, "14 rue Colbert, 37000 Tours", 15, 2);

        Sejour lesVacances = new Sejour(new Date(2026, 10, 30), 4, chezMoi, 2);

        lesVacances.afficher();

    }

}
