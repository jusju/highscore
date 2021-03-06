package com.juslin.highscore.tietokanta;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Luokka sisältää tietokantayhteyden, yhdistämisen
 * ja katkaisemisen.
 * @author Jukka Harju
 */
public class Yhteys {
    private Connection yhteys;

    public Yhteys() {
        yhdista();
    }

    /**
     * Ottaa yhteyden tietokantaan.
     */
    public void yhdista() {
        // Syntaksi: jdbc:TYPE:machine:port/DB_NAME
        String url = "jdbc:mysql://localhost:3306/myy";

        // ladataan tietokanta-ajuri
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (java.lang.ClassNotFoundException ex) {
            System.out.print("ClassNotFoundException: ");
            System.out.println(ex.getMessage());
        }

        try {
            // Otetaan yhteys tietokantaan
            yhteys =
                DriverManager.getConnection(
                    url, "myycrawler", "oF5W@naW7$NM3cnlMrRr#6Wr");
        } catch (SQLException ex) {
            kasitteleVirhe(
                "Virhe tietokantayhteyden avaamisessa", ex);
        }
    }

    /**
     * Katkaistaan yhteys tietokantaan.
     */
    public void katkaise() {
        try {
            yhteys.close();
        } catch (SQLException ex) {
            kasitteleVirhe(
                "Virhe tietokantayhteyden sulkemisessa", ex);
        }
    }

    public Connection getYhteys() {
        if (yhteys == null) {
            yhdista();
        }

        return yhteys;
    }

    /**
     * Tulostaa SQL-virheen virheilmoituksen.
     *
     * @param selite
     *            Ohjelmoijan antama seliteteksti.
     * @param ex
     *            Viittausmuuttuja tarkempien
     *            virhetietojen näyttämiseen.
     */
    public static void kasitteleVirhe(
        String selite, SQLException ex) {
        System.out.println(selite);
        System.out.println("Message:   " + ex.getMessage());
        System.out.println("SQLState:  " + ex.getSQLState());
        System.out.println("ErrorCode: " + ex.getErrorCode());
    }
}