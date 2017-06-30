package service;

import dao.DBConn;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by alberti stefano on 29/06/2017.
 */
public class DataLoader {

    private DBConn db;

    //Costruttore
    public DataLoader(DBConn db) {this.db = db;}

    //Metodo per popolare il database
    public boolean caricaFile(Path p) throws IOException {


        FileReader f = new FileReader(p.toString());
        BufferedReader b = new BufferedReader(f);
        String s="";
        String file = "";
        try {
            while ((s = b.readLine()) != null) {
                file += s;
            }
            StringTokenizer st = new StringTokenizer(file,";");
            while(st.hasMoreTokens()){
                db.doSQL(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
