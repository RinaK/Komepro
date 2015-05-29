/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.komepro;




/**
 *
 * @author 
 */
public class LoginLogicTest1 {
    public static void main (String[] args){
     testExecute1();
     testExecute2();
 }   
 
 public static void testExecute1(){
     Login1 login = new Login1("minato","1234");
     LoginLogic1 bo = new LoginLogic1();
     boolean result = bo.execute(login);
     if(result){
         System.out.println("testExecute1:成功しました");
     }else{
         System.out.println("testExecute1;失敗しました");
     }
 }
 public static void testExecute2(){
     Login1 login = new Login1("minato","12345");
     LoginLogic1 bo = new LoginLogic1();
     boolean result = bo.execute(login);
        if(!result){
            System.out.println("testExcute2;成功しました");
        }else{
            System.out.println("testExcute2;失敗しました");
        }
 }
}
   

    
