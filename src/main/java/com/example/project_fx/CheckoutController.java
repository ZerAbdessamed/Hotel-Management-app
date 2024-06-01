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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;
import java.util.ResourceBundle;

public class CheckoutController implements Initializable {
    @FXML
    public AnchorPane page;
    @FXML
    public AnchorPane page2;
    @FXML
    public AnchorPane page3;
    @FXML

    private TableColumn<User, Integer> id;
    @FXML

    private TableColumn<User, String> indate;

    @FXML
    private TableColumn<User, String> outdate;

    @FXML
    private AnchorPane page4;

    @FXML
    private AnchorPane page5;

    @FXML
    private TableColumn<User, String> rcapaciry;

    @FXML
    private TableColumn<User, String> room;

    @FXML
   public TableView<User> table;
    @FXML
    private Button btnr;
    @FXML
    private TextField room_number1;
    @FXML
    private Label lb_checkout1;
    @FXML
    private TableView<Guests> table1;

    @FXML
    private TableColumn<Guests, String> address;

    @FXML
    private TableColumn<Guests, String> day;

    @FXML
    private TableColumn<Guests, String> fees;
    @FXML
    private TableColumn<Guests, String> name;
    @FXML
    private TableColumn<Guests, String> phone;
    @FXML
    private TableColumn<Guests, Integer> roomid;
    @FXML
    private TextField city;
    @FXML
    private TextField email;
    @FXML
    private TextField adresse;
    @FXML
    private TextField passport;

    @FXML
    private TextField username2;
    @FXML
    private TextField phone2;
    @FXML
    private TextField natio;
    @FXML
    private DatePicker dateout;
    @FXML
    private DatePicker datein;

    @FXML
    private RadioButton dou;

    @FXML
    private RadioButton economy;
    @FXML
    private RadioButton single;
    @FXML
    private RadioButton triple;

    @FXML
    private RadioButton vip;
    @FXML
    private RadioButton normal;
    @FXML
    private Text id_room;
    ObservableList<User> list= FXCollections.observableArrayList(
//            new User(1,"Normal","Double","07/07/2024","17/07/2024",true),
//            new User(2,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(3,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(4,"Normal","Double","07/07/2024","17/07/2024",true),
//            new User(5,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(6,"vip","Single","08/01/2024","15/02/2025",false)
    );
    ObservableList<Guests> l= FXCollections.observableArrayList(
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {


            id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
            room.setCellValueFactory(new PropertyValueFactory<User, String>("room_type"));
            rcapaciry.setCellValueFactory(new PropertyValueFactory<User, String>("room_capacity"));
            outdate.setCellValueFactory(new PropertyValueFactory<User, String>("date_out"));
            indate.setCellValueFactory(new PropertyValueFactory<User, String>("date_in"));
            roomid.setCellValueFactory(new PropertyValueFactory<Guests,Integer>("idroom"));
            name.setCellValueFactory(new PropertyValueFactory<Guests,String>("name"));
            phone.setCellValueFactory(new PropertyValueFactory<Guests,String>("phone"));
            day.setCellValueFactory(new PropertyValueFactory<Guests,String>("day"));
            fees.setCellValueFactory(new PropertyValueFactory<Guests,String>("fees"));
            address.setCellValueFactory(new PropertyValueFactory<Guests,String>("address"));
            l=ConnexionDB.guests();
            list = ConnexionDB.room_insert();
            table1.setItems(l);
            table.setItems(list);
        }catch (Exception e){

        }


    }
    public void go_to_home(ActionEvent event) throws Exception{

        Parent p= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene sc=new Scene(p,1300,800);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Dashboard");
        s.setScene(sc);
        s.show();}

    public void go_to_room(ActionEvent event) throws Exception{
        page4.setVisible(true);
        page2.setVisible(false);
        page.setVisible(false);
        page3.setVisible(false);
    }
    public void go_to_check_in(ActionEvent event) throws Exception{
        page4.setVisible(false);
        page3.setVisible(false);
        page2.setVisible(false);
        page.setVisible(true);

    }
    public void go_to_check_out(ActionEvent event) throws Exception{
        page3.setVisible(false);
        page4.setVisible(false);
        page.setVisible(false);
        page2.setVisible(true);
    }
    public void r_number(ActionEvent event) throws Exception{
        String str= room_number1.getText();
        try {
            ConnexionDB.delete_room(Integer.parseInt(str));
            int num=Integer.parseInt(str);
            room_number1.setText("");
        }catch (Exception e){
            lb_checkout1.setText("is not number");
        }

    }
    public void clear(ActionEvent event) throws Exception{
        room_number1.setText("");
        lb_checkout1.setText("");
    }
    public void guests(ActionEvent event) throws Exception{

        page4.setVisible(false);
        page.setVisible(false);
        page2.setVisible(false);
        page3.setVisible(true);
//        btnch1.arm();
//        btnch1.getStyleClass().add("clicked");
//        btnr.disarm();
//        btnr.getStyleClass().add("normal");
    }

    String str1,date_in,str3,date_out;
    public void submit(ActionEvent event) throws Exception {
        Image im=new Image(String.valueOf(getClass().getResource("/icone/hotel-logo-design_423075-16-removebg-preview.png")));
        if(vip.isSelected()){
            str1="Vip";
        }
        if(normal.isSelected()){
            str1="Normal";
        }
        if(economy.isSelected()){
            str1="Economy";
        }
        if(single.isSelected()){
            str3="Single";
        }
        if(dou.isSelected()){
            str3="Double";
        }if(triple.isSelected()){
            str3="Triple";
        }
        date_in= String.valueOf(datein.getValue());
        date_out=String.valueOf(dateout.getValue());
        ConformationController.set_information(username2.getText(),email.getText(),phone2.getText(),adresse.getText(),city.getText(),
                natio.getText(),passport.getText(),str1,date_in,str3,date_out);
        Parent p = FXMLLoader.load(getClass().getResource("Confirmation.fxml"));
        Stage s = new Stage();
        s.getIcons().add(im);
        ConformationController.s=s;
        s.setResizable(false);
        Scene sc = new Scene(p, 1064, 730);
//  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
        s.setTitle("Confirmation");
        s.setScene(sc);
        s.show();
    }
    @FXML
    void RoomID(ActionEvent event) {
        Random r=new Random();
        CheckinController.num=r.nextInt(30)+1;
        id_room.setText(String.valueOf(CheckinController.num));
    }


}





