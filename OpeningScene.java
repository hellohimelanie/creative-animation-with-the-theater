import org.code.theater.*;
import org.code.media.*;

public class OpeningScene extends Scene {
    private Player announcer;
    private String arena;

    public OpeningScene(Player announcer, String arena){
        this.announcer = announcer;
        this.arena = arena;
    }

    public void playCheering(){
        playSound("crowd_cheering.wav");
    }

    public void createScene(){
        drawImage(arena, 0, 0, 400);
        drawImage(announcer.getImage(), 100, 250, 150);
        playSound(announcer.getSoundFile());
        playCheering();
        pause(3);
        clear("black");
    }
}