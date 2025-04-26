import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner {
    public static void main(String[] args) {
        Player announcer = new Player("announcer_gibberish.wav", "announcer.png");

        Player[] DunkinDonuts = {
            new Player("", "cameron_after_baller-removebg-preview.png"),
            new Player("", "daron_after_baller-removebg-preview.png")
        };

        Player[] LeBrunch = {
            new Player("", "jared_dunking-removebg-preview-(1).png"),
            new Player("", "gettyimages-917841836-612x612-removebg-preview.png")
        };

        OpeningScene openingScene = new OpeningScene(announcer, "arena.jpg");
        BasketballCourtScene basketballScene = new BasketballCourtScene(DunkinDonuts, LeBrunch, "court.jpg", announcer);

        openingScene.createScene();
        basketballScene.createScene();
        Theater.playScenes(openingScene, basketballScene);
    }
}