package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbhelper
{
    private static Connection connection = null;
    //private static PreparedStatement connectionPreparedStat = null;
    public static Connection GetJDBCConnection()
    {
        try {
            if(connection == null)
            {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "123456");
            }
        } catch (Exception e) {
            //TODO: handle exception
        }

        return connection;
    }

    public static ResultSet ExecQuerry(String querry)
    {
        ResultSet rs = null;
        try {
            PreparedStatement connectionPreparedStat = connection.prepareStatement(querry);
            rs = connectionPreparedStat.executeQuery();
        } catch (SQLException ex) {
            
        }

        return rs;
    }

    public static void CloseConnection() throws SQLException
    {
        if(connection != null)
        {
            connection.close();
        }
    }
}