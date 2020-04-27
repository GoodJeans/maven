/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smsserver.web.controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/**
 *
 * @author Guan Ji
 */
public class QueryRepository {

    Connection con = null;
    JavaConfig j1 = new JavaConfig();

    public QueryRepository() {

        String [] Config = new String[3];//[host,username,secret]

        try {
            Config = j1.webConfig();
            System.out.println("Establishing connection to Database..");
        } catch (Exception e) {
            System.out.println("Error at queryRepository" + e);
        }
        String url = "jdbc:mysql://localhost:3306/database";
        String username = "root";
        String password = "Nebulas3";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connection to Database has been established.");
//            con = DriverManager.getConnection(url, username, password);
            con = DriverManager.getConnection(Config[0], Config[1], Config[2]);
        } catch (Exception e) {
            System.out.println("Unable to establish a DSatabase connection, error:" + e);
        }
    }

    public List<Users> queryGetAllUsers() {
        List<Users> usersObject = new ArrayList<>();
        String sql = "select * from users";
        try {
            System.out.println("Establishing query for all data into database.");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery((sql));
            while (rs.next()) {
                Users a = new Users();
                a.setId(rs.getInt(1));
                a.setMobileNumber(rs.getString(2));
                a.setUserName(rs.getString(3));
                usersObject.add(a);
                System.out.println("Qquery all data from database successful.");
            }
        } catch (Exception e) {
            System.out.println("Unsuccessful query,all data error:," + e);
        }
        return usersObject;
    }

    public Users queryGetUser(int id) {
        String sql = "select * from users where id=" + id;
        Users a = new Users();
        try {
            System.out.println("Establishing query for individual data statement into database.");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery((sql));
            if (rs.next()) {
                a.setId(rs.getInt(1));
                a.setUserName(rs.getString(2));
                a.setMobileNumber(rs.getString(3));
            }
            System.out.println("Query individual data from database successful.");
        } catch (Exception e) {
            System.out.println("Unsuccessful query, individualdata error:," + e);
        }
        return a;
    }

    public void queryCreate(Users a1) {
        String sql = "insert into users values(?,?,?)";

        try {
            System.out.println("Establishing insert statement into database..");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, a1.getId());
            st.setString(2, a1.getUserName());
            st.setString(3, a1.getMobileNumber());
            st.executeUpdate();
            System.out.println("Insert query to database successful.");
        } catch (Exception e) {
            System.out.println("Unsuccessful insert error:," + e);
        }
    }

    public void queryUpdate(Users a1) {
        String sql = "update users set username=?, mobilenumber=? where id =?";

        try {
            System.out.println("Establishing update statement into database..");
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, a1.getUserName());
            st.setString(2, a1.getMobileNumber());
            st.setInt(3, a1.getId());
            st.executeUpdate();
            System.out.println("update query to database successful.");
        } catch (Exception e) {
            System.out.println("Unsuccessful updating error:," + e);
        }
    }

    public void queryDelete(int id) {
        String sql = "delete from users where id=?";

        try {
            System.out.println("Establishing delete query into database.");
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, id);
            st.executeUpdate();
            System.out.println("Delete query to database successful.");
        } catch (Exception e) {
            System.out.println("Unsuccessful deleting, error:" + e);
        }
    }

}
