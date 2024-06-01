package com.example.project_fx;

public class Guests  {
    private String name,phone,address,fees,day;
    private int idroom;
    public Guests(int idroom,String name, String phone, String address, String day, String fees ) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.idroom = idroom;
        this.fees = fees;
        this.day = day;
    }
    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getIdroom() {
        return idroom;
    }

    public String getFees() {
        return fees;
    }

    public String getDay() {
        return day;
    }
}
