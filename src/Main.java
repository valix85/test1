import config.LoadProperties;
import dao.DBConn;
import service.AutoService;

import javax.swing.text.DateFormatter;
import java.io.File;
import java.sql.*;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Nextre on 27/06/2017.
 */
public class Main {
    public static void main(String[] args) {

        LoadProperties.setFp("src" + File.separator + "config" + File.separator + "db-dev.properties");
        LoadProperties prop = LoadProperties.getInstance();
        DBConn db = DBConn.getistance(prop);


        /* AUTO CON ASSICURAZIONE IN SCADENZA */

        AutoService as = new AutoService(db);
        /*as.getAutoInScadenza(30).stream().forEach(System.out::println);*/

        as.getAutoVendibili(80000).stream().forEach(System.out::println);

    }
}

