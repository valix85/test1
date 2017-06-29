package service;

import dao.DBConn;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberti stefano on 29/06/2017.
 */
public class DataLoader {

    private DBConn db;

    public DataLoader(DBConn db) {this.db = db;}

    public void caricaFile(Path p) throws IOException {

        List<String> list = new ArrayList<>();
        FileReader f;
        f = new FileReader(p.toString());
        BufferedReader b;
        b = new BufferedReader(f);
        String s;
        try {
            while (true) {
                s = b.readLine();
                list.add(s);
                if (s == null)
                    break;
                String file = "";
                for (int i = 0; i < list.size(); i++) {
                    file = list.get(i);
                } db.doSQL(file);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
