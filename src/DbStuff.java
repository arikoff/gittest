import java.sql.*;

public class DbStuff {
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String dbAddress = "jdbc:mysql://localhost:3306/";
    private String userPass = "?user=root&password=#@#Xtvgbjyfn06";
    private String dbName = "TestAuth";
    private String SSL = "?verifyServerCertificate=false&useSSL=true";
    private String userName = "root";
    private String password = "#@#Xtvgbjyfn06";

    private PreparedStatement statement;
    private ResultSet result;
    private Connection con;

    public DbStuff() {

        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName + SSL, userName, password);
        }

        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (SQLException e) {
            createDatabase();
        }
    }

    private void createDatabase() {
        try {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass, userName, password);
            Statement s = con.createStatement();
            int myResult = s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        }
        catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean checkLogin(String login, String password) {
        try {
            Statement s = con.createStatement();
            String SQL = "SELECT login FROM testauth.auth where login = '" + login +
                         "' AND password = '" + password + "'";
            boolean success = s.execute(SQL);
            if (success) {
                result = s.getResultSet();
                if (result.next()) {
                    return true;
                }
                else {
                    return false;
                }
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean checkLogin(String login) {
        try {
            Statement s = con.createStatement();
            String SQL = "SELECT login FROM testauth.auth where login = '" + login + "'";
            s.execute(SQL);
            result = s.getResultSet();
            if (result.next()) {
                return true;
            }
            else {
                return false;
            }
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public boolean Register(String login, String password) {
        try {
            Statement s = con.createStatement();
            String SQL = "INSERT INTO testauth.auth VALUES ('" + login + "', '" + password + "')";
            s.execute(SQL);
            return true;
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }
    public void CloseConnection(){
        try {
            con.close();
        }
        catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}