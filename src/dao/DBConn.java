package dao;

import com.mysql.jdbc.exceptions.MySQLSyntaxErrorException;
import config.LoadProperties;
import service.DataLoader;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;

/**
 * Created by Rivolta Fabio on 29/06/2017.
 */
public class DBConn {
    private String driver = null;
    private String url = null;
    private String username = null;
    private String password = null;
    private String host = null;
    private String port = null;
    private String encode = null;
    private String database = null;
    public static DBConn cd = null;
    private Connection con = null;

    private DBConn(LoadProperties prop) {
        //prima di alzare la connessione setto i parameri letti dal file prop
        setDriver(prop.getProp("db.connection.driver"));
        setUsername(prop.getProp("db.connection.user"));
        setPassword(prop.getProp("db.connection.password"));
        setHost(prop.getProp("db.connection.host"));
        setPort(prop.getProp("db.connection.port"));
        setEncode(prop.getProp("db.connection.encode"));
        setDatabase(prop.getProp("db.connection.database"));
        setUrl(prop.getProp("db.connection.url"));

        try {
            Class.forName(getDriver());
            con = DriverManager.getConnection(getUrl() + getDatabase(), getUsername(), getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            if (e.getErrorCode() == 1049) {
                this.creazionedb(prop);
            }
            //System.out.println(e.getErrorCode());
            //System.out.println("il nome di questo database non esiste");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConn getistance(LoadProperties prop) {
        if (
                prop.getProperties().contains("db.connection.user") &&
                        prop.getProperties().contains("db.connection.password") &&
                        prop.getProperties().contains("db.connection.driver") &&
                        prop.getProperties().contains("db.connection.host") &&
                        prop.getProperties().contains("db.connection.port") &&
                        prop.getProperties().contains("db.connection.encode") &&
                        prop.getProperties().contains("db.connection.database") &&
                        prop.getProperties().contains("db.connection.url")
                ) {
            if (cd == null) {
                cd = new DBConn(prop);
            }
        } else {
            return null;
        }
        System.out.println("\n\n*** SELEZIONATO IL DATABASE: "+prop.getProp("db.connection.database")+" ***\n");
        return cd;
    }

    //metodo per utilizzare la insert into
    public int doSQL(String sql) {
        System.out.println("ESEGUO: " + sql);
        try {
            Statement statement = con.createStatement();
            int rs = statement.executeUpdate(sql);
            return rs;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            System.out.println("hai inserito una query errata");
        } catch (NullPointerException n) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //metodo per utilizzare la select
    public ResultSet runSQL(String sql) {
        try {
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            return rs;
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            System.out.println("hai inserito una query errata");
        } catch (NullPointerException n) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    //test di select
    public void test() {
        try {
            ResultSet rs = runSQL("SELECT * FROM marca");
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                System.out.println(id + " - " + marca);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public int creazionedb(LoadProperties prop) {
        System.out.println("\n\n*** CREAZIONE DEL DATABASE ***\n");
        String filepath = prop.getProp("db.schema.sql");
        filepath = filepath.replaceAll("/", Matcher.quoteReplacement(File.separator));
        //System.out.println(filepath);

        String sql ="";

        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while((s = br.readLine()) != null) {
                sql+=s;
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(sql);
        StringTokenizer st = new StringTokenizer(sql, ";");

        try {
            Class.forName(getDriver());
            con = DriverManager.getConnection(getUrl(), getUsername(), getPassword());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException e) {
            System.out.println("DBConn->creazionedb : " + e.getErrorCode() + " - " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            while (st.hasMoreTokens()){
                doSQL(st.nextToken());
                //con.createStatement().execute(st.nextToken());
            }
            System.out.println("\n\n*** SELEZIONATO IL DATABASE: "+prop.getProp("db.connection.database")+" ***\n");
            con.setCatalog(prop.getProp("db.connection.database"));
            System.out.println("\n\n*** POPOLAMENTO DEL DATABASE ***\n");
            DataLoader dl = new DataLoader(this);

            String filepathDatas = prop.getProp("db.schema.datas");
            filepathDatas = filepathDatas.replaceAll("/", Matcher.quoteReplacement(File.separator));
            dl.caricaFile(new File(filepathDatas).toPath());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return -1;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getEncode() {
        return encode;
    }

    public void setEncode(String encode) {
        this.encode = encode;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }
}
