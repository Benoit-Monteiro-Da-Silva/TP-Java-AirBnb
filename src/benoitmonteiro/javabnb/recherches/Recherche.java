package benoitmonteiro.javabnb.recherches;

import java.util.ArrayList;

import benoitmonteiro.javabnb.logements.Logement;
import benoitmonteiro.javabnb.logements.Maison;
import benoitmonteiro.javabnb.outils.JavaBnBData;

//Classe immuable avec des attributs optionnels malgré tout (Design Pattern : Builder)

//Les attributs optionnels sont tout de même 'final' dans le but d'obtenir un objet immuable
//Ces attributs auront une valeur par défaut correspondant à leur type dans le cas où on ne set pas leur valeur

public class Recherche {

    private final int nbVoyageurs; //obligatoire
    private final int tarifMinParNuit; //optionnel
    private final int tarifMaxParNuit; //optionnel
    private final int possedePiscine; //optionnel (Pas un boolean car il y a trois valeurs possibles : 'oui', 'non' et 'non renseigné')

    //On définit des constantes 'int' dédiées à l'attribut 'possedePiscine'
    private static final int YES = 1;
    private static final int NO = 2;
    private static final int I_DONT_CARE = 0;

    //Constructeur privé qui attend un Builder et reprend les attributs de ce builder
    private Recherche (RechercheBuilder builder) {
        this.nbVoyageurs = builder.nbVoyageurs;
        this.tarifMinParNuit = builder.tarifMinParNuit;
        this.tarifMaxParNuit = builder.tarifMaxParNuit;
        this.possedePiscine = builder.possedePiscine;
    }

    //Méthode qui utilise les attributs de la Recherche pour renvoyer une ArrayList<Logement> qui y correspond
	public ArrayList<Logement> result() {

		ArrayList<Logement> result = new ArrayList<>();

		for (Logement logement : JavaBnBData.getInstance().getLogements()) {

			// Test nombre de voyageur
			if (logement.getNbVoyageursMax() < nbVoyageurs)
				continue;

			// Test du tarif par nuit
			if (logement.getTarifParNuit() < tarifMinParNuit || logement.getTarifParNuit() > tarifMaxParNuit)
				continue;

			// Test pour la piscine
			if (possedePiscine == YES) {
				// Oui pour la piscine du coup c'est forcément une maison
				if (logement instanceof Maison) {
					Maison maison = (Maison) logement;
					// La maison n'a pas de piscine, on ne la prend pas
					if (!maison.hasPiscine())
						continue;
				} else
					continue;

			} else if (possedePiscine == NO) {
				// Non pour la piscine
				if (logement instanceof Maison) {
					Maison maison = (Maison) logement;
					// Si la maison a une piscine, on ne la prend pas
					if (maison.hasPiscine())
						continue;
				}
			}

			result.add(logement);
		}

		return result;
	}


    //Classe interne static (qui peut donc être appelée sans créer d'instance) qui va pouvoir set les attributs de 'Recherche' à l'aide de méthodes dédiées
    //Elle pourra aussi lancer le constructeur privé de 'Recherche'
    public static class RechercheBuilder {
        
        //Seuls les attributs obligatoires de 'Recherche' sont 'final' ici
        private final int nbVoyageurs;
        private int tarifMinParNuit;
        private int tarifMaxParNuit;
        private int possedePiscine;

        //Le constructeur du Builder prend et set les attributs obligatoires (et éventuellement, comme ici, des valeurs par défaut)
        public RechercheBuilder(int pNbVoyageurs) {
            nbVoyageurs = pNbVoyageurs;
            possedePiscine = I_DONT_CARE;
            tarifMaxParNuit = Integer.MAX_VALUE;
        }

        //Méthodes qui set les attributs optionnels et retourne la classe 'Builder' pour pouvoir être appelées à la chaine
        //Les méthodes ont le nom de l'attribut qu'elles set par commodité
        public RechercheBuilder tarifMinParNuit (int pTarifMinParNuit) {
            tarifMinParNuit = pTarifMinParNuit;
            return this;
        }

        public RechercheBuilder tarifMaxParNuit (int pTarifMaxParNuit) {
            tarifMaxParNuit = pTarifMaxParNuit;
            return this;
        }

        public RechercheBuilder possedePiscine (boolean pPossedePiscine) {
            if (pPossedePiscine) {
                possedePiscine = YES;
            } else {
                possedePiscine = NO;
            }

            return this;
        }


        //Méthode qui peut (doit !) lancer le constructeur privé de 'Recherche' en lui passant le Builder qui a été fabriqué
        public Recherche build() {
            return new Recherche(this);
        }

    }
}
