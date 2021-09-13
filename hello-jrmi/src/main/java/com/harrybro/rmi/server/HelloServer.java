package com.harrybro.rmi.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloServer {
    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            HelloImpl hello = new HelloImpl(); // Remote Object
            Registry registry = LocateRegistry.createRegistry(1234);
            registry.rebind("hello", hello);
            System.out.println("Hello 원격 객체를 registry에 등록완료");
            System.out.println("클라이언트에서 호출 대기 중");
        } catch (RemoteException e) {
            System.err.println("메서드를 호출하는 도중 에러 발생");
        }
    }
}
