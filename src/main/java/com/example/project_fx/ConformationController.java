package com.example.project_fx;



import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.event.ActionEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;
import java.util.function.IntBinaryOperator;

public class ConformationController implements Initializable {

    public TextField phone1;
    @FXML
    private Text Number_night;

    @FXML
    private Text adresse;

    @FXML
    private Text checkindate;

    @FXML
    private Text checkoutdate;

    @FXML
    private Text checkoutdate1;

    @FXML
    private Text city;

    @FXML
    private Text email;

    @FXML
    public Text name;

    @FXML
    public Text name1;

    @FXML
    private Text natio;

    @FXML
    private Text night_cost;

    @FXML
    private AnchorPane page;

    @FXML
    private Text pass;

    @FXML
    private  Text phone;

    @FXML
    private Text price;

    @FXML
    private Text roomcapacity;

    @FXML
    private Text roomtype;
    int num,t;
    public  static  String  nam1,email1,phon,adr,city1,nat,pas,str,str2,str3,date;
        @Override
        public void initialize (URL location, ResourceBundle resources){
            phone.setText(phon);
            pass.setText(pas);
            natio.setText(nat);
            email.setText(email1);
            name.setText(nam1);
            city.setText(city1);
            adresse.setText(adr);
            roomtype.setText(str);
            roomcapacity.setText(str3);
            checkindate.setText(str2);
            checkoutdate.setText(date);
            num=calculate_number_jour(str2,date);
            Number_night.setText(String.valueOf(num));
            if(str=="Vip"){
                if(str3=="Single"){
                       night_cost.setText("25$");
                       t=num*25;}else {
                       if(str3=="Double"){
                            night_cost.setText("45$");
                            t=num*45;
                       }else {
                            night_cost.setText("70$");
                            t=num*70;
                    }
                }}
            if(str=="Normal"){
                if(str3=="Single"){
                    night_cost.setText("15$");
                    t=num*15;}else {
                    if(str3=="Double"){
                        night_cost.setText("25$");
                        t=num*25;
                    }else {
                        night_cost.setText("40$");
                        t=num*40;
                    }}}
            if(str=="Economy"){
                if(str3=="Single"){
                    night_cost.setText("10$");
                    t=num*10;}else {
                    if(str3=="Double"){
                        night_cost.setText("15$");
                        t=num*15;
                    }else {
                        night_cost.setText("25$");
                        t=num*25;
                    }}}

            price.setText(String.valueOf(t)+"$");
        }
        public static void set_information (String name,String email,String phone,String adresse,String city ,String nationality ,String p,String s ,String st,String st1,String date_out){
        nam1=name;
        email1=email;phon=phone;adr=adresse;city1=city;nat=nationality;pas=p;
        str=s;
        str2=st;
        str3=st1;
        date=date_out;
        }
        public int calculate_number_jour(String date1,String date2) {
            String s1[] = date1.split("-");
            String s2[] = date2.split("-");
            String jour1 = s1[s1.length - 2] + s1[s1.length - 1];
            String jour2 = s2[s2.length - 2] + s2[s2.length - 1];
            int som = Integer.parseInt(jour2) - Integer.parseInt(jour1);
            return som;
        }
        static  Stage s;
    @FXML
    void submit(ActionEvent event) throws IOException {
        ConnexionDB.insert_in_room(str,str3,str2,date);
        ConnexionDB.insert_in_guests(name.getText(),phone.getText(),adresse.getText(),String.valueOf(num),String.valueOf(t)+" $");
             s.close();
    }



    public String getAdresse() {
        return adresse.getText();
    }


    public String getName() {
        return name.getText();
    }


    public String getPhone() {
        return phone.getText();
    }

}


