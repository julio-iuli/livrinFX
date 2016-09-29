package application;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by julio on 15/08/16.
 */
public class Conexao {
    public static Connection getConexao(){
        Connection conexao  = null;
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/livrin2?autoReconnect=true&useSSL=false", "julio", "juju");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexao;
    }
}

