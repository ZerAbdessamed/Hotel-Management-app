package com.example.project_fx;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public interface Dashbord {
    public void checkin(ActionEvent event) throws Exception;
    public void check_out(ActionEvent event) throws Exception;
    public void room(ActionEvent event) throws Exception;
    public void go_guests(ActionEvent event) throws Exception;
    public void go_to_setting(ActionEvent event) throws Exception;
    public void logout(ActionEvent event);
}