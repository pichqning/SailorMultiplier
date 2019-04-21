package main;

import program.PropertyManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PropertyManager propertyManager = PropertyManager.getInstance();
        System.out.println("Test username: " + propertyManager.getProperty("jdbc.user"));
    }
}
