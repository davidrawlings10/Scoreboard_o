package Scoreboard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomService {
    public static boolean decide(int weight) {
        int random = rand.nextInt(10000);
        return random < weight;
    }
}