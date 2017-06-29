import dao.DBConn;
import service.DataLoader;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Agatino D'Agate on 27/06/2017.
 */
public class Main {
    public static void main(String[] args) {

        DataLoader dl=new DataLoader(DBConn.getistance());
        try {
            dl.caricaFile(new File("example-data"+File.separator+"db-schema.sql").toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.exit(0);

        //definizione parametri per la connessione
        String driver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/autonoleggio";
        String username = "root";
        String password = "root";

        PreparedStatement ps = null;
        try {
            //connessione
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(url, username, password);
            //conn.setCatalog(database);

            String sql1 = "SELECT * FROM marca";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql1);
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("nome_marca");
                System.out.println(id + " - " + marca);
            }
            /*

            //ciclo di aquisizione e inserimento dati
            Scanner console = new Scanner(System.in);
            boolean finito = false;
            int i = 0; //solo per il debug - eliminare successivamente

            while (!finito) {
                String strId = "";
                do {
                    System.out.println("Inserisci id auto. Attenzione, deve essere un intero!");
                    strId = console.next();
                } while (!isInteger(strId));
                int id = Integer.parseInt(strId);
                System.out.println("Inserisci la fk_rel_mod_mar_cat");
                int fk_rel_mod_mar_cat = console.nextInt();
                System.out.println("Inserisci la fk_colore");
                int fk_colore = console.nextInt();
                System.out.println("Inserisci targa");
                String targa = console.next();
                System.out.println("Inserisci il danno");
                int danno = console.nextInt();
                System.out.println("Inserisci il settore");
                String settore = console.next();
                System.out.println("Inserisci la data di assicurazione");
                Long dataAssicurazione= console.nextLong();

                DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
                //dateTimeFormatter=dataAssicurazione.longValue(dataAssicurazione);
                dateTimeFormatter.format(dataAssicurazione);


//registrazione dati sul database
                String sqlQuery = "INSERT INTO auto VALUES (? ,?, ?, ?, ?, ?, ?, ?, ?)";
                ps = conn.prepareStatement(sqlQuery);
                ps.setInt(1, id);
                ps.setString(2, fk_rel_mod_mar_cat);
                ps.setString(3, targa);
                ps.setString(4, cittResidenza);
                int rows = ps.executeUpdate();
//solo per il debug - eliminare successivamente
                i++;
                System.out.println("Righe inserite=" + i);
//************************************************
                System.out.println("Hai altri dati da inserire? [y per confermare]");
                String risposta = console.next().toLowerCase();
                finito = !risposta.equals("y");
            }
//solo per il debug - eliminare successivamente
            System.out.println("Inserimento input terminato - Applicazione terminata");
//chiusura della connessione
                //console.close();
*/


            //ps.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean isInteger(String str) {
        try {
            int i = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}

