import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioSystem;

public class PlayMusic {
	

	void playMusic(String musicLocation) {
		
		try {
			
			File musicPath = new File(musicLocation);
			
			if(musicPath.exists()) {
				
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);						
			}
			else {
				
				System.out.println("Can't find file");
			}
				
		}
			
		catch( Exception ex) {
			
			ex.printStackTrace();
		}
	}
	
	}
