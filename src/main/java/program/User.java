package program;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "users")
public class User {

    @DatabaseField(id = true)
    private String username;

    @DatabaseField(canBeNull = false)
    private String sailor_character;

    public User() {

    }

    public User(String username, String character) {
        this.username = username;
        this.sailor_character = character;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSailor_character() {
        return sailor_character;
    }

    public void setSailor_character(String sailor_character) {
        this.sailor_character = sailor_character;
    }

}
