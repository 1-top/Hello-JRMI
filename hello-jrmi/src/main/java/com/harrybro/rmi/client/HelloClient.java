package com.harrybro.rmi.client;

import com.harrybro.rmi.server.Hello;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1234);
            Hello hello = (Hello) registry.lookup("hello");
            System.out.println(hello.sayHello("HarryBro"));
        } catch (NotBoundException e) {
            System.out.println("연결 실패");
        } catch (RemoteException e) {
            System.out.println("원격 메서드 호출 중 문제 발생");
        }
    }
}
