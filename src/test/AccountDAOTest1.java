/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.AccountDAO1;
import com.komepro.Account1;
import com.komepro.Login1;

/**
 *
 * @author 
 */
public class AccountDAOTest1 {
     public static void main(String[] agrs){
        testFindByLogin1();
        testFindByLogin2();
        
    }
    
    public static void testFindByLogin1() {
        Login1 login = new Login1("minato", "1234");
        AccountDAO1 dao = new AccountDAO1();
        Account1 result = dao.findByLogin(login);
        System.out.println(result.getUserId().equals("minato"));
        System.out.println(result.getPass().equals("1234"));
        System.out.println(result.getMail().equals("mnt@cm.com"));
        System.out.println(result.getName().equals("湊　雄輔"));
        System.out.println(result.getAdress().equals("東京都津田市１２３"));
        System.out.println(result.getPhone()==12345678);
        if (result != null
                && result.getUserId().equals("minato")
                && result.getPass().equals("1234")
                && result.getMail().equals("mnt@cm.com")
                && result.getName().equals("湊　雄輔")
                && result.getAdress().equals("東京都津田市１２３")
                && result.getPhone()==12345678) {
            System.out.println("testFindByLogin1:成功しました");
        } else {
            System.out.println("testFindByLogin1:失敗しました");
        }
    }

    public static void testFindByLogin2() {
        Login1 login = new Login1("minato", "12345");
        AccountDAO1 dao = new AccountDAO1();
        Account1 result = dao.findByLogin(login);
        if (result == null) {
            System.out.println("testFindByLogin2:成功しました");
        } else {
            System.out.println("testFindByLogin2:失敗しました");
        }
    }
}

   