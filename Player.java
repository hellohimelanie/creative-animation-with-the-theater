import org.code.theater.*;
import org.code.media.*;

public class Player extends Character {
    private String soundFile;

    public Player(String soundFile, String image) {
        super(image);
        this.soundFile = soundFile;
    }

    public String getSoundFile() {
        return soundFile;
    }
}