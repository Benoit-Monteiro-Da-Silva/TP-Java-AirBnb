package benoitmonteiro.javabnb.outils;

import java.util.Date;


public class Utile {

    public static Date createDate(int jour, int mois, int annee) {
        
        return new Date(annee, mois - 1, jour);

    }

    public static String formatDate(Date dateObj) {

        String date = (dateObj.getDate() <= 9) ? "0" + dateObj.getDate() : "" + dateObj.getDate();
        int correctedMonth = dateObj.getMonth() + 1;
        String month = (correctedMonth <= 9) ? "0" + correctedMonth : "" + correctedMonth;
        String year = "" + dateObj.getYear();
        String dateFormatee = date + "/" + month + "/" + year;

        return dateFormatee;

    }

    private Utile(){}

}
