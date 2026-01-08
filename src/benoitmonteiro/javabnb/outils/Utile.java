package benoitmonteiro.javabnb.outils;

import java.util.Date;


public class Utile {

    public static Date createDate(int jour, int mois, int annee) {
        
        return new Date(annee, mois, jour);

    }

    public static String formatDate(Date dateObj) {

        String date = (dateObj.getDate() <= 9) ? "0" + dateObj.getDate() : "" + dateObj.getDate();
        String month = (dateObj.getMonth() <= 9) ? "0" + dateObj.getMonth() : "" + dateObj.getMonth();
        String year = "" + dateObj.getYear();
        String dateFormatee = date + "/" + month + "/" + year;

        return dateFormatee;

    }

    private Utile(){}

}
