package com.example.project_fx;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[]args)  {
        try {
            implement_methods ob=new implement_methods();
            Registry registry= LocateRegistry.createRegistry(107) ;
            registry.bind("s",ob);
            System.out.println("server ready");
        }catch (Exception e){
          e.printStackTrace();
        }

    }


}
