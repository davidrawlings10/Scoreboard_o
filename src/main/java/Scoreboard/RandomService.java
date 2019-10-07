package Scoreboard;

import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class RandomService {
    public static boolean decide(int weight) {
        Random rand = new Random();
        int random = rand.nextInt(10000);
        System.out.println("random: "+random + ", weight: "+weight);
        return random < weight;
    }
}