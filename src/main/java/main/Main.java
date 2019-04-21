package main;

import com.j256.ormlite.table.TableUtils;
import orm.DatabaseManager;
import program.PropertyManager;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        PropertyManager propertyManager = PropertyManager.getInstance();
        System.out.println("Test username: " + propertyManager.getProperty("jdbc.user"));

        DatabaseManager databaseManager = new DatabaseManager();

    }
}
