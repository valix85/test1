package dao;

import java.sql.*;

/**
 * Created by Rivolta Fabio on 29/06/2017.
 */
public class DBConn {
    private String driver="com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/db_auto_noleggio";
    private String username="root";
    private String password="root";
    public static DBConn cd;
    private Connection con=null;

    private DBConn() {
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DBConn getistance(){
        if(cd==null){
            cd= new DBConn();
        }
    return cd;
    }

//metodo per utilizzare la insert into
    public int doSQL(String sql){
        try {
            Statement statement= con.createStatement();
            int rs=statement.executeUpdate(sql);
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }return -1;
    }
//metodo per utilizzare la select
    public ResultSet runSQL(String sql){
        try {
            Statement statement= con.createStatement();
            ResultSet rs=statement.executeQuery(sql);
            return rs;
        }catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }


//test di select
    public void test(){
        try {
            ResultSet rs = runSQL("SELECT * FROM marca");
            while (rs.next()) {
                int id = rs.getInt("id");
                String marca = rs.getString("marca");
                System.out.println(id + " - " + marca);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
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
}
