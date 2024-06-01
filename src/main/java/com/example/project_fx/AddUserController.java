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

import java.sql.SQLException;

public class AddUserController {
    @FXML
    private AnchorPane Add;

    @FXML
    private AnchorPane adddelete;

    @FXML
    private AnchorPane delete;
    @FXML
    private TextField username;
    @FXML
    private TextField password;

    @FXML
    private TextField usern1;

    @FXML
    private TextField password1;

    @FXML
    void AddUser(ActionEvent event) {
        Add.setVisible(true);
        adddelete.setVisible(false);
        delete.setVisible(false);
    }

    @FXML
    void DeleteUser(ActionEvent event) {
        Add.setVisible(false);
        adddelete.setVisible(false);
        delete.setVisible(true);
    }
    @FXML
    void User(ActionEvent event) {
        Add.setVisible(false);
        adddelete.setVisible(true);
        delete.setVisible(false);
    }

    @FXML
    void delete(ActionEvent event){
//     ConnexionDB.add(usern1.getText(),password1.getText());
     ConnexionDB.delete_user(usern1.getText(),password1.getText());
     usern1.setText("");
     password1.setText("");
    }
    @FXML
    void Add(ActionEvent event){
     ConnexionDB.add(username.getText(),password.getText());
     username.setText("");
     password.setText("");
    }

}
