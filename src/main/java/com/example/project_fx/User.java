package com.example.project_fx;
public class User {
  private   int id;
    private String room_type,room_capacity,date_out,date_in;
    public User(int id,String r_type,String r_capacity,String date_in,String date_out){
        this.id=id;
        this.date_in=date_in;
        this.date_out=date_out;
        this.room_capacity=r_capacity;
        this.room_type=r_type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setRoom_capacity(String room_capacity) {
        this.room_capacity = room_capacity;
    }

    public void setDate_out(String date_out) {
        this.date_out = date_out;
    }

    public void setDate_in(String date_in) {
        this.date_in = date_in;
    }

    public int getId() {
        return id;
    }

    public String getRoom_type() {
        return room_type;
    }

    public String getRoom_capacity() {
        return room_capacity;
    }

    public String getDate_out() {
        return date_out;
    }

    public String getDate_in() {
        return date_in;
    }


}
