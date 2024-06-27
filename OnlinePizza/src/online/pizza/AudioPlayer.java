
package online.pizza;

import jaco.mp3.player.MP3Player;
import java.io.File;





public class AudioPlayer {
    public  final String SONG="C:\\Users\\ponja\\Documents\\NetBeansProjects\\Online _Pizza\\OnlinePizza\\Tarantella Napoletana.mp3";
    MP3Player mp3player=new MP3Player(new File(SONG));
}
