
package Azmin.DBSPT;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBSupport {
    
 public static Connection establishConnection() throws SQLException, ClassNotFoundException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Properties connectProp = new Properties();
        connectProp.put("dbms","mysql");
        connectProp.put("user","root");
        connectProp.put("password","root");
        connectProp.put("useSSL","false");         
        String P1 = "jdbc:mysql://localhost:3306/";
        conn = DriverManager.getConnection(P1,connectProp);
        return conn;
    }
    
    public static void executeQuery(String q) throws SQLException, ClassNotFoundException{        
        Connection conn = establishConnection();
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE carrental");
        Statement queryStatement = conn.createStatement();
        queryStatement.execute(q); 
        conn.close();
    }

    public static String executeResultsQuery(String q) throws SQLException, ClassNotFoundException {
        Connection conn = establishConnection();  // Corrected this line
        Statement useStatement = conn.createStatement();
        useStatement.execute("USE carrental");
        
        String result = "";
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(q);
        if (resultSet.next()) {
            result = resultSet.getString(1);
        }

        resultSet.close();
        statement.close();
        conn.close();

        return result;
    }

   
    
}



