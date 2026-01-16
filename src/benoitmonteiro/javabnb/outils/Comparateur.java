package benoitmonteiro.javabnb.outils;

//Classe générique
public class Comparateur <T extends Comparable> {

    private final T obj1;
    private final T obj2;

    public Comparateur(T pObj1, T pObj2) {
        obj1 = pObj1;
        obj2 = pObj2;
    }


    public T getHigher() {
        if (obj1.getComparableAttribute() >= obj2.getComparableAttribute()) {
            return obj1;
        }
        return obj2;
    }

    public T getLower() {
        if (obj1.getComparableAttribute() <= obj2.getComparableAttribute()) {
            return obj1;
        }
        return obj2;
    }

}
