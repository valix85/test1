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

    public List<Auto> getAutoInScadenza(Integer traGiorni){
        List<Auto> risultato = new ArrayList<>();
        String sql = "SELECT * FROM auto WHERE data_scadenza_assicurazione <= (NOW()+ INTERVAL "+traGiorni+" day) ";
        ResultSet rs = db.runSQL(sql);
        try {
            while(rs.next()==true){
                Auto tmp = new Auto();
                tmp.setId(rs.getInt("id"));
                tmp.setTarga(rs.getString("targa"));
                String sdatatmp = rs.getString("data_scadenza_assicurazione");
                LocalDate datatmp = LocalDate.parse(sdatatmp, DateTimeFormatter.ISO_LOCAL_DATE);
                tmp.setData_scadenza_assicurazione(datatmp);
                tmp.setNumeroTelaio(rs.getString("numeroTelaio"));
                tmp.setKilometri(rs.getInt("kilometri"));
                tmp.setNoleggiata(rs.getBoolean("noleggiata"));
                tmp.setPrezzoGiornaliero(rs.getDouble("prezzoGiornaliero"));
                tmp.setN_Porte(rs.getInt("n_Porte"));
                tmp.setFk_rel_marca_categoria(rs.getInt("fk_rel_marca_categoria"));
                tmp.setFk_colore(rs.getInt("fk_colore"));
                risultato.add(tmp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return risultato;
    }



}
