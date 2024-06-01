package com.example.project_fx;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField usern;
    public PasswordField password;
    public Label lb;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void login(ActionEvent event) throws Exception{
         DashboardController d=new DashboardController();

          int ch=ConnexionDB.check(usern.getText(),password.getText());
        switch (ch){
            case 0:
                Parent p= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
                Scene sc=new Scene(p,1300,800);
                s.setTitle("Dashboard");
                s.setScene(sc);
                s.show();
            break;
            case 1:lb.setText("Check your Password or Username");break;
            case -1: System.out.println("not connecte data base");break;
        }
    }



}
