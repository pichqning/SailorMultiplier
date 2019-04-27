package program;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "high_score")
public class Highscore {

    @DatabaseField(id = true)
    private int multiplier;

    @DatabaseField(canBeNull = true, foreign = true)
    private User user;

    @DatabaseField
    private int score;

    public Highscore (int multi, User u, int score) {
       this.multiplier = multi;
       this.score = score;
       this.user = u;
    }

    public Highscore() {

    }

    public int getScore() {
        return score;
    }

    public int getMultiplier() {
        return multiplier;
    }

    public void setScore(int a) {
        this.score = a;
    }

    public User getUser() {
        return user;
    }

    public String getUsername() {
        if(this.user == null) return "-";
        else return user.getUsername();
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format("%d",score);
    }

}
