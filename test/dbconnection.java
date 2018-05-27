/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;

/**
 *
 * @author deepak
 */
public class dbconnection {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        dbconnection db=new dbconnection();
        //db.select();
        //db.insert();
        //db.update();
        //db.delete();
    }
    
    private void select() throws SQLException    //SELECT
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalnoticeboard","root","admin");
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from teachers");
        while(rs.next())
        {
            String select=rs.getString(1)+" : "+rs.getString(2)+" : "+rs.getString(3);
            System.out.println(select);
        }
        rs.close();
        con.close(); 
    }

    void insert() throws SQLException    //INSERT
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalnoticeboard","root","admin");  
        String query="insert into teachers values(?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1,"vinod.shastri");
        ps.setString(2, "Vinod");
        ps.setString(3, "password");
        int count =ps.executeUpdate();
        System.out.println(count+" row/s affected");  
        ps.close();
        con.close(); 
    }

    void update() throws SQLException    //UPDATE
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalnoticeboard","root","admin"); 
        String query = "UPDATE teachers SET LoginID=?, Name=?, password=? WHERE LoginID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "tanveer.ahmed");
        ps.setString(2, "Tanveer");
        ps.setString(3, "password");
        ps.setString(4, "gaurav.singal");
        int count = ps.executeUpdate();
        System.out.println(count+" row/s affected");
        if (count > 0) 
        {
            System.out.println("An existing user was updated successfully!");
        }
        ps.close();
        con.close();
    }
    void delete() throws SQLException    //DELETE
    {
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/digitalnoticeboard","root","admin"); 
        String query = "DELETE FROM teachers WHERE LoginID=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, "tanveer.ahmed");
        int count = ps.executeUpdate();
        System.out.println(count+" row/s deleted.");
        if (count > 0) 
        {
            System.out.println("A user was deleted successfully!");
        }
        ps.close();
        con.close();
    }
}
