package benoitmonteiro.javabnb.utilisateurs;

import java.util.Objects;
import benoitmonteiro.javabnb.outils.Comparable;

public class Personne implements Comparable {
    
    private final String prenom;
    private final String nom;
    private final int age;

    public Personne(String paramPrenom, String paramNom, int paramAge) {
        prenom = paramPrenom;
        nom = paramNom;
        age = paramAge;
    }

    public void afficher() {
        System.out.print(prenom + " " + nom + " (" + age + " ans)");
    }

    //Methode pour comparer deux personnes (redéfinition de la méthode 'equals' de la classe Object qui se contente de vérifier les pointeurs mémoires)
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Personne other = (Personne) obj;

        return this.age == other.age &&
                Objects.equals(this.prenom, other.prenom) &&
                Objects.equals(this.nom, other.nom);
    }


    //Interface methods
    
    @Override
    public int getComparableAttribute() {
        return age;
    }

}
