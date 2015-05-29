package com.komepro;

/**
 *
 * @author 
 */
public class Account1 {
    private String userId;
    private String pass;
    private String mail;
    private String name;
    private String adress;
    private int phone;
    
    public Account1(String userId,String pass,String mail,String name,String adress,int phone){
        this.userId = userId;
        this.pass = pass;
        this.mail = mail;
        this.name = name;
        this.adress = adress;
        this.phone = phone;
    }
    
    public String getUserId(){return userId;}
    public String getPass(){return pass;}
    public String getMail(){return mail;}
    public String getName(){return name;}
    public String getAdress(){return adress;}
    public int getPhone(){return phone;}
}

    

