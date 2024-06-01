
package com.example.project_fx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.*;

public class ConnexionDB {
    private static final String USERNAME="root";
    private static final String PASSWORD="";
    private static final String HOST="127.0.0.1";
    private static final String DB_NAME="data_base";
    private static final int PORT=3306;
    public static Connection con;
    public static String str="";
    public static String str_pass="";

    static {
        try {
            con= DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME,USERNAME,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int check(String username,String passowrd){
        str=username;
        str_pass=passowrd;
        Connection con=ConnexionDB.con;
        if (con==null) {
            return -1;
        }
        String sql="SELECT * FROM users WHERE username=? AND password=?";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,passowrd);
            ResultSet rs =pre.executeQuery();
            while (rs.next()) {
                return 0;
            }
            pre.close();
        }catch (Exception e){
            System.out.println("error");
        }
        return 1;
    }
    public static int check_admin(){
        Connection con=ConnexionDB.con;
        if (con==null) {
            return -1;
        }
        String sql="SELECT * FROM admin WHERE username=? AND password=?";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,str);
            pre.setString(2,str_pass);
            ResultSet rs =pre.executeQuery();
            while (rs.next()) {
                return 0;
            }
            pre.close();
        }catch (Exception e){
            System.out.println("error");
        }
        return 1;
    }

    public static void add(String username,String passowrd)  {
        Connection con=ConnexionDB.con;
        if (con==null) {
            System.out.println("not conne");
        }
        int is_existe= check(username,passowrd);
        if(is_existe==0){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("User is existe");
            a.setHeaderText(null);
            a.setContentText("user is existe");
            a.show();
        }else {
        String sql="INSERT INTO users (username, password) VALUES (?,?)";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,passowrd);
            pre.executeUpdate();
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("User is add");
            a.setHeaderText(null);
            a.setContentText("user is add");
            a.show();
            pre.close();
        }catch (Exception e){
        }}}

    public static void delete_user(String username,String passowrd){
        Connection con=ConnexionDB.con;
        if (con==null) {
            System.out.println("not conne");
        }
        int is_existe= check(username,passowrd);
        if(is_existe!=0){
            Alert a=new Alert(Alert.AlertType.ERROR);
            a.setTitle("User is not existe");
            a.setHeaderText(null);
            a.setContentText("user is not existe");
            a.show();
        }else {
        String sql="DELETE FROM users WHERE username=? AND password=?";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setString(1,username);
            pre.setString(2,passowrd);
            pre.executeUpdate();
            Alert a=new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("User is deleted");
            a.setHeaderText(null);
            a.setContentText("user is deleted");
            a.show();
            pre.close();
        }catch (Exception e){

        }
    }}
    public static void delete_room(int id){
        Connection con=ConnexionDB.con;
        if (con==null) {
            System.out.println("not conne");
        }
        String sql="DELETE FROM room WHERE id=?";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setInt(1,id);
            pre.executeUpdate();
            pre.close();
        }catch (Exception e){
        }
    }
    public static ObservableList<User> room_insert() {
        int i=0;
        ObservableList<User> l=null;
        Connection con = ConnexionDB.con;
        l= FXCollections.observableArrayList();
        if (con == null) {
            System.out.println("error1");
        }
        String sql = "SELECT * FROM room ";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            CheckoutController c = new CheckoutController();
            while (rs.next()) {
              l.add(new User(rs.getInt("id"),rs.getString("roomtype"),rs.getString("roomcapacity"),rs.getString("checkindate"),rs.getString("checkoutdate")));
            }
            pre.close();
        } catch (Exception e) {
            System.out.println("error2");
        }

    return l;
    }
    public static void insert_in_room(String roomtype1 ,String roomcapacity1,String checkindate1 ,String checkoutdat1 )  {
        Connection con=ConnexionDB.con;
        if (con==null) {
            System.out.println("not conne");
        }
        String sql="INSERT INTO room (id,roomtype,roomcapacity,checkindate,checkoutdate) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setInt(1,CheckinController.num);
            pre.setString(2,roomtype1);
            pre.setString(3,roomcapacity1);
            pre.setString(4,checkindate1);
            pre.setString(5,checkoutdat1);
            pre.executeUpdate();
            pre.close();
        }catch (Exception e){
           e.printStackTrace();
            }}

    public static void insert_in_guests(String name ,String phone,String adress ,String day,String fees )  {
        Connection con=ConnexionDB.con;
        if (con==null) {
            System.out.println("not conne");
        }
        String sql="INSERT INTO guests (RoomID,Name,Phone,Address,Day,Fees) VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pre=con.prepareStatement(sql);
            pre.setInt(1,CheckinController.num);
            pre.setString(2,name);
            pre.setString(3,phone);
            pre.setString(4,adress);
            pre.setString(5,day);
            pre.setString(6,fees);
            pre.executeUpdate();
            pre.close();
        }catch (Exception e){
           e.printStackTrace();
        }}
    public static ObservableList<Guests> guests() {
        int i=0;
        ObservableList<Guests> l=null;
        Connection con = ConnexionDB.con;
        l= FXCollections.observableArrayList();
        if (con == null) {
            System.out.println("error1");
        }
        String sql = "SELECT * FROM guests ";
        try {
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            CheckoutController c = new CheckoutController();
            while (rs.next()) {
                l.add(new Guests(rs.getInt("RoomID"),rs.getString("Name"),rs.getString("Phone"),rs.getString("Address"),rs.getString("Day"),rs.getString("Fees")));
            }
            pre.close();
        } catch (Exception e) {
            System.out.println("error5");
        }
        return l;
    }
}
