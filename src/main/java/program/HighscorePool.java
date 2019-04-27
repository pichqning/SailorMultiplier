package program;

import java.util.List;

public class HighscorePool {
    private List<Highscore> highscores;
    private static HighscorePool instance;

    public HighscorePool () {
        for (int i = 2 ; i <= 12 ; i++) {
//            Highscore h = new Highscore(i,0);
//            highscores.add(h);
        }
    }

    public static HighscorePool getInstance() {
        if (instance == null) {
            instance = new HighscorePool();
        }
        return instance;
    }

    public Highscore getHighscoreIndiv (int mul) {
        return highscores.get(mul-2);
    }

    public List<Highscore> getHighscores() {
        return highscores;
    }

    public void setHighscoresIndiv (int mul , int a) {
        highscores.get(mul-2).setScore(a);
    }

    public void deleteHighScoreIndiv (int mul) {
        highscores.remove(mul-0);
    }

    public void clearHighScore () {
        highscores.clear();
    }

    public void updatePool () {
        highscores.clear();
        for (int i = 2 ; i <= 12 ; i++) {
//            Highscore h = new Highscore(i,0);
//            highscores.add(h);
        }
    }
}
