package com.example.project_fx;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.rmi.RemoteException;

public class DashboardController implements Initializable,Dashbord{

    @FXML
    public Text info;
    @FXML
    public Text nam;
    @FXML
    private Text rank;
    @FXML
    public VBox dash;
    @Override

    public void initialize(URL location, ResourceBundle resources) {
        try {
          nam.setText(ConnexionDB.str);
          if(ConnexionDB.check_admin()!=0){
              rank.setText("Client");
          }else rank.setText("Admin");
        }catch (Exception e){
           e.printStackTrace();
        }
    }
    static Stage st;
    public void checkin(ActionEvent event) throws Exception{
        Parent p= FXMLLoader.load(getClass().getResource("Checkin.fxml"));
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc=new Scene(p,1300,800);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Dashboard");
        s.setScene(sc);
        s.show();
    } public void check_out(ActionEvent event) throws Exception{
        Parent p= FXMLLoader.load(getClass().getResource("check_out.fxml"));
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        st=s;
        Scene sc=new Scene(p,1300,800);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Checkout");
        s.setScene(sc);
        s.show();
    }
    public void room(ActionEvent event) throws Exception{
        Parent p= FXMLLoader.load(getClass().getResource("Room.fxml"));
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc=new Scene(p,1300,800);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Room");
        s.setScene(sc);
        s.show();
    }
    public void go_guests(ActionEvent event) throws Exception{
        Parent p= FXMLLoader.load(getClass().getResource("Guests.fxml"));
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc=new Scene(p,1300,800);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Room");
        s.setScene(sc);
        s.show();
    }
    public void go_to_setting(ActionEvent event) throws Exception {
        if (rank.getText().equals("Admin")) {
            Stage s = new Stage();
            Parent p = FXMLLoader.load(getClass().getResource("AddUser.fxml"));
            Image im = new Image(String.valueOf(getClass().getResource("/icone/hotel-logo-design_423075-16-removebg-preview.png")));
            s.getIcons().add(im);
            Scene sc = new Scene(p, 578, 495);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
            s.setTitle("Setting");
            s.setScene(sc);
            s.setResizable(false);
            s.show();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Check");
            a.setHeaderText(null);
            a.setContentText("your are not Admin");
            a.show();
        }
    }
    public void back_to_home(ActionEvent event)  {
        Parent p= null;
        try {
            p = FXMLLoader.load(getClass().getResource("login.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc=new Scene(p,600,500);
        s.setTitle("Dashboard");
        s.setScene(sc);
        s.show();}
    public void logout(ActionEvent event)  {System.exit(0);}
}
