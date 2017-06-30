package service;

import dao.DBConn;
import entity.Auto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alberti stefano on 30/06/2017.
 */
public class AutoService {

    private DBConn db;

    public AutoService(DBConn db){
        this.db=db;
    }

    public List<Auto> getAutoInScadenza(){
        List<Auto> risultato = new ArrayList<>();
        String sql = "SELECT * FROM auto";
        ResultSet rs = db.runSQL(sql);
        try {
            while(rs.next()==true){
                Auto tmp = new Auto();
                tmp.setId(rs.getInt("id"));
                tmp.setTarga(rs.getString("targa"));
                String sdatatmp = rs.getString("data_scadenza_assicurazione");
                LocalDate datatmp = LocalDate.parse(sdatatmp, DateTimeFormatter.ISO_LOCAL_DATE);
                tmp.setData_scadenza_assicurazione(datatmp);
                risultato.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return risultato;
    }



}
