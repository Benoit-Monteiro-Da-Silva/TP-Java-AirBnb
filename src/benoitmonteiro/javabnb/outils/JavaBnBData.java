package benoitmonteiro.javabnb.outils;

import java.util.ArrayList;
import benoitmonteiro.javabnb.utilisateurs.Hote;
import benoitmonteiro.javabnb.logements.Logement;

//Singleton
public class JavaBnBData {

    //Unique instance de la classe créée à l'intérieur même de celle-ci
    private static JavaBnBData instance = new JavaBnBData();

    //Attributs de l'instance
    private ArrayList<Hote> hotes;
    private ArrayList<Logement> logements;

    //Constructeur privé
    private JavaBnBData() {
        hotes = new ArrayList<>();
        logements = new ArrayList<>();

        try {
            LogementsDomParser.parse("res/logements.xml", hotes, logements);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération des données.");
        }
    }


    //Getter de l'instance
    public static JavaBnBData getInstance() {
        return instance;
    }


    //Autres Getters
    public ArrayList<Hote> getHotes() {
        return hotes;
    }

    public ArrayList<Logement> getLogements() {
        return logements;
    }

}
