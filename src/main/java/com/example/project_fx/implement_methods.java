package com.example.project_fx;
import javafx.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class implement_methods extends UnicastRemoteObject implements interface_method{
    protected implement_methods() throws RemoteException {
        super();
    }
    @Override
    public void logout1() throws RemoteException {
      System.exit(0);}




}
