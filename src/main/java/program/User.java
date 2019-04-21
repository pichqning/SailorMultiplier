package program;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(id = true)
    private String username;

    @DatabaseField(canBeNull = false)
    private String character;

    public User() {

    }

    public User(String username, String character) {
        this.username = username;
        this.character = character;
    }


}
