/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vagne
 */
public class Conexao {
    
    
    public static Connection con () throws SQLException{
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_usuario", "root", "");
    }
}
