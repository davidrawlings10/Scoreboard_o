package Scoreboard;

public class Clock {
    int period, minutes, seconds;

    public Clock() {

    }

    public void tick() {
        seconds--;

        if (seconds == -1) {
            minutes--;
            seconds = 59;
        }

        if (minutes == -1) {
            period++;

        }
    }
}
