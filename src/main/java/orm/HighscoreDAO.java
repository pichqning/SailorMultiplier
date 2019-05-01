package orm;

import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import program.Highscore;
import program.User;

import java.sql.SQLException;
import java.util.List;

public class HighscoreDAO extends BaseDaoImpl<Highscore, Integer> {

    public HighscoreDAO(ConnectionSource connectionSource) throws SQLException {
        super(connectionSource, Highscore.class);
    }

    public Highscore getListFromColumn(String tableColumn, int search) {
        QueryBuilder<Highscore, Integer> qb = this. queryBuilder();
        List<Highscore> highscores = null;

        try {
            highscores = qb.where().eq(tableColumn, search).query();
        } catch (SQLException se){
            System.out.println("Cannot search in high score data.");
        }

        return highscores.get(0);
    }

    public void updateHighScore(int key, User user, int newScore) {
        try {
            this.update(new Highscore(key, user, newScore));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Cannot update high score");
        }

    }

}
