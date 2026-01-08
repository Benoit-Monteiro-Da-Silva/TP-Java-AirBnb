package benoitmonteiro.javabnb.outils;

import java.util.Date;


public class Utile {

    /**
     * @param jour int between 1 and 31
     * @param mois int between 1 and 12
     * @param annee int
     * @return Date object
     */
    public static Date createDate(int jour, int mois, int annee) {
        
        return new Date(annee - 1900, mois - 1, jour);

    }

    /**
     * @param dateObj
     * @return Date String to the format 'day/month/year'
     */
    public static String formatDate(Date dateObj) {

        String date = (dateObj.getDate() <= 9) ? "0" + dateObj.getDate() : "" + dateObj.getDate();
        int correctedMonth = dateObj.getMonth() + 1;
        String month = (correctedMonth <= 9) ? "0" + correctedMonth : "" + correctedMonth;
        int correctedYear = dateObj.getYear() + 1900;
        String dateFormatee = date + "/" + month + "/" + correctedYear;

        return dateFormatee;

    }

    private Utile(){}

}
