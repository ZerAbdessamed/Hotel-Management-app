//package com.example.project_fx;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.fxml.Initializable;
//import javafx.scene.Node;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.control.cell.PropertyValueFactory;
//import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//public class HelloController implements Initializable {
//
//    public AnchorPane page;
//    public AnchorPane page2;
//    public AnchorPane page3;
//    @FXML
//    private TableColumn<User, Integer> id;
//
//    @FXML
//    private TableColumn<User, String> indate;
//
//    @FXML
//    private TableColumn<User, Boolean> isavai;
//
//    @FXML
//    private TableColumn<User, String> outdate;
//
//    @FXML
//    private AnchorPane page4;
//
//    @FXML
//    private AnchorPane page5;
//
//    @FXML
//    private TableColumn<User, String> rcapaciry;
//
//    @FXML
//    private TableColumn<User, String> room;
//
//    @FXML
//    private TableView<User> table;
//    @FXML
//    private Button btnr;
//    @FXML
//    private TextField room_number;
//    @FXML
//    private Label lb_checkout;
//    ObservableList<User>list= FXCollections.observableArrayList(
//            new User(1,"Normal","Double","07/07/2024","17/07/2024",true),
//            new User(2,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(3,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(4,"Normal","Double","07/07/2024","17/07/2024",true),
//            new User(5,"vip","Single","08/01/2024","15/02/2025",false),
//            new User(6,"vip","Single","08/01/2024","15/02/2025",false)
//    );
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//try {
//    btnr.arm();
//    id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
//    indate.setCellValueFactory(new PropertyValueFactory<User, String>("date_in"));
//    isavai.setCellValueFactory(new PropertyValueFactory<User, Boolean>("is_vailable"));
//    outdate.setCellValueFactory(new PropertyValueFactory<User, String>("date_out"));
//    rcapaciry.setCellValueFactory(new PropertyValueFactory<User, String>("room_capacity"));
//    room.setCellValueFactory(new PropertyValueFactory<User, String>("room_type"));
//    table.setItems(list);
//}catch (Exception e){}
//    }
//
//    public void on(ActionEvent event) throws Exception{
//
//            Parent p= FXMLLoader.load(getClass().getResource("hello-view.fxml"));
//            Stage s=(Stage) ((Node) event.getSource()).getScene().getWindow();
//            Scene sc=new Scene(p,1300,800);
////  sc.getStylesheets().add(getClass().getResource("st.css").toExternalForm());
//            s.setTitle("Dashboard");
//            s.setScene(sc);
//            s.show();}
//
//    public void ok(ActionEvent event) throws Exception{
//     page3.setVisible(true);
//     page2.setVisible(false);
//     page.setVisible(false);
////     btnr.arm();
////     btnr.getStyleClass().add("clicked");
////     btnch1.disarm();
////     btnch1.getStyleClass().add("normal");
//    }
//    public void ok1(ActionEvent event) throws Exception{
//        page3.setVisible(false);
//        page2.setVisible(false);
//        page.setVisible(true);
////        btnch1.arm();
////        btnch1.getStyleClass().add("clicked");
////        btnr.disarm();
////        btnr.getStyleClass().add("normal");
//    }
//    public void ok2(ActionEvent event) throws Exception{
//        page3.setVisible(false);
//        page.setVisible(false);
//        page2.setVisible(true);
////        btnch1.arm();
////        btnch1.getStyleClass().add("clicked");
////        btnr.disarm();
////        btnr.getStyleClass().add("normal");
//    }
//    public void r_number(ActionEvent event) throws Exception{
//            String str= room_number.getText();
//            try {
//                int num=Integer.parseInt(str);
//            }catch (Exception e){
//                lb_checkout.setText("is not number");
//            }
//    }
//    public void clear(ActionEvent event) throws Exception{
//       room_number.setText("");
//       lb_checkout.setText("");
//    }
//
//
//}