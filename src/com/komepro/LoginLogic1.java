/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komepro;

import dao.AccountDAO1;





public class LoginLogic1 {
     public boolean execute(Login1 login){
        AccountDAO1 dao = new AccountDAO1();
        Account1 account = dao.findByLogin(login);
        return account != null;
     }
    
}
