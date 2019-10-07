package MySqlTest.MySqlTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class GameService {

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    public String playGame(int home_team_id, int away_team_id, Sport sport, Integer season_id) throws InterruptedException {
        Game game = new Game();
        game.setHomeTeamId(home_team_id);
        game.setAwayTeamId(away_team_id);
        game.setHomeScore(3);
        game.setAwayScore(2);
        userRepository.save(game);

        return "SAVED";

        /*switch (sport) {
            case HOCKEY:
                return playHockeyV2(home_team_id, away_team_id, season_id);
            default:
                return "";
        }*/
    }

    private void playHockeyV1(long home_team_id, long away_team_id, long season_id) {
        Random rand = new Random();

        final int maxScore = 6;

        int home_score = rand.nextInt(maxScore);
        int away_score = rand.nextInt(maxScore);

        //insertGame(home_team_id, away_team_id, home_score, away_score, season_id);
    }

    private String playHockeyV2(int home_team_id, int away_team_id, Integer season_id) throws InterruptedException {
        Random rand = new Random();

        int home_score = 0, away_score = 0, period = 1, minutes = 20, seconds = 0;

        while (true) {

            //TimeUnit.SECONDS.sleep(1);
            System.out.println("HOME: " + home_score + " AWAY: " + away_score + " PERIOD: " + period + " " + minutes + ":" + seconds);

            seconds--;

            if (seconds == -1) {
                minutes--;
                seconds = 59;
            }

            if (minutes == -1) {
                period++;
                if (period < 4) {
                    minutes = 20;
                    seconds = 0;
                } else if (period == 4) {
                    if (home_score != away_score) {
                        break;
                    } else {
                        minutes = 5;
                        seconds = 0;
                    }
                } else if (period == 5) {
                    break;
                    // Shoot-out
                }
            }

            // average goals per period .869
            // average time to score a goal 1,357.2

            final int RAND = 1357;

            int home_rand = 0, away_rand = 0;
            home_rand = rand.nextInt(RAND);
            away_rand = rand.nextInt(RAND);
            if (home_rand == 0) {
                home_score++;
                if (period == 4)
                    break;
            }
            if (away_rand == 0) {
                away_score++;
                if (period == 4)
                    break;
            }

            //System.out.println(" ~"+home_rand + " ~"+away_rand);
        }

        Game game = new Game();
        game.setHomeTeamId(home_team_id);
        game.setAwayTeamId(away_team_id);
        game.setHomeScore(home_score);
        game.setAwayScore(away_score);
        userRepository.save(game);

        return "HOME: " + home_score + " AWAY: " + away_score + " PERIOD: " + period + " " + minutes + ":" + seconds;

        //insertGame(home_team_id, away_team_id, home_score, away_score, season_id);
    }
}
