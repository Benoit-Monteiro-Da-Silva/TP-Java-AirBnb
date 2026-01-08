package benoitmonteiro.javabnb.utilisateurs;

public class Personne {
    
    private String prenom;
    private String nom;
    private int age;

    public Personne(String paramPrenom, String paramNom, int paramAge) {
        prenom = paramPrenom;
        nom = paramNom;
        age = paramAge;
    }

    public void afficher() {
        System.out.println(prenom + " " + nom + " (" + age + " ans)");
    }

}
