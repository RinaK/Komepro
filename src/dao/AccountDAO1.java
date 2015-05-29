/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.komepro.Account1;
import com.komepro.Login1;


 
public class AccountDAO1 {
     public Account1 findByLogin(Login1 login) {
        Connection conn = null;
        Account1 account = null;
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            String driverURL = "jdbc:derby://localhost:1527/db2719";

            conn = DriverManager.getConnection(
                    driverURL, "db", "db");

            String sql = "SELECT USER_ID,PASS,MAIL,NAME,ADRESS,PHONE FROM ACCOUNT WHERE USER_ID = ? AND PASS = ?";
            PreparedStatement pStmt = conn.prepareStatement(sql);
            pStmt.setString(1, login.getUserId());
            pStmt.setString(2,login.getPass());
            
            ResultSet rs = pStmt.executeQuery();
            
            if(rs.next()){
                String userId =rs.getString("USER_ID");
                String pass = rs.getString("PASS");
                String mail = rs.getString("MAIL");
                String name = rs.getString("NAME");
                String adress = rs.getString("ADRESS");
                int phone = rs.getInt("PHONE");
                
                account = new Account1(userId,pass,mail,name,adress,phone);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        }
        return account;
    }
}
    