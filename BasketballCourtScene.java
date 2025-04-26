import org.code.theater.*;
import org.code.media.*;

public class BasketballCourtScene extends Scene {
    private Player[] leBrunch;
    private Player[] dunkin;
    private String courtImage;
    private Player announcer;

    public BasketballCourtScene(Player[] dunkinDonuts, Player[] leBrunch, String courtImage, Player announcer) {
        this.leBrunch = leBrunch;
        this.dunkin = dunkinDonuts;
        this.courtImage = courtImage;
        this.announcer = announcer;
    }

    public void createScene() {
        Player jared = leBrunch[0];      // Jared (LeBrunch)
        Player getty = leBrunch[1];      // Getty (teammate)
        Player cameron = dunkin[0];      // Cameron (defender, moves to middle)
        Player daron = dunkin[1];        // Daron (just chillin)

        // Initial scene setup
        drawImage(courtImage, 0, 0, 400);
        drawImage(getty.getImage(), 300, 20, 100);       // Getty chillin near hoop
        drawImage(daron.getImage(), 70, 10, 80);        // Daron chillin low
        drawImage(cameron.getImage(), 10, 150, 100);     // Cameron on far left
        drawImage(jared.getImage(), 300, 90, 100);      // Jared on far right
        pause(1);

        // Cameron walks from left to middle
        int camX = 10;
        while (camX < 170) {
            clear("black");
            drawImage(courtImage, 0, 0, 400);
            drawImage(getty.getImage(), 300, 20, 100);
            drawImage(daron.getImage(), 70, 10, 80);
            drawImage(jared.getImage(), 300, 90, 100);  // Jared not moving yet
            drawImage(cameron.getImage(), camX, 150, 100);
            pause(0.5);
            camX += 40;
        }

        pause(1);

        // Jared walks from right to left (to score!)
        int jaredX = 300;
        while (jaredX > 80) {
            clear("black");
            drawImage(courtImage, 0, 0, 400);
            drawImage(getty.getImage(), 300, 20, 100);
            drawImage(daron.getImage(), 70, 10, 80);
            drawImage(cameron.getImage(), 170, 150, 100); // Cameron stopped
            drawImage(jared.getImage(), jaredX, 90, 100);
            pause(0.5);
            jaredX -= 30;
        }

        // Jared shoots the ball!
        playSound("ballSwoosh.wav");

        // Add basketball shot animation
        int ballX = 70;  // Starting position for the basketball (right side of the screen)
        int ballY = 90;   // Same height as Jared

        // Animate the basketball moving towards the left
        while (ballX > 0) {
            clear("black");
            drawImage(courtImage, 0, 0, 400);
            drawImage(getty.getImage(), 300, 20, 100);
            drawImage(daron.getImage(), 70, 10, 80);
            drawImage(cameron.getImage(), 170, 150, 100);
            drawImage(jared.getImage(), 80, 90, 100);  // Jared at the left side now
            drawImage("basketball.jpeg", ballX, ballY, 40);  // Spawning the basketball image
            pause(0.5);
            ballX -= 30;  // Move the basketball closer to the left
        }
        // Once the basketball disappears, play the cheering sound
        playSound("crowd_cheering.wav");

        // Win message
        drawText("LeBrunch wins!", 130, 50);
        pause(2);
    }
}