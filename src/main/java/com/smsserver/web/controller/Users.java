/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsserver.web.controller;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Guan Ji
 */
@XmlRootElement
public class Users {
    private String userName;
    private String mobileNumber;
    private int Id;

    public void setId(int Id){
        this.Id = Id;
    }
    public int getId(){
        return Id;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public String getUserName(){
        return userName;
    }        
     public void setMobileNumber(String mobileNumber){
         this.mobileNumber = mobileNumber;
     }
     public String getMobileNumber(){
        return mobileNumber;
    }
     @Override
     public String toString()
     {
         return "Alien [id ="+Id+"name="+userName;
     }
}

