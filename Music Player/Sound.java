
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineEvent;
import java.util.concurrent.CountDownLatch;

public class Sound {
    private Clip clip;
    public Sound(String fileName) {
       
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
                
            }
            else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Malformed URL: " + e);
        }
        catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        }
        catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        }
        catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
        }

    // play, stop, loop the sound clip
    }
    public void play(){
    	final CountDownLatch clipDone = new CountDownLatch(1);
    	clip.addLineListener(new LineListener() {
    	    @Override
    	    public void update(LineEvent event) {
    	        if (event.getType() == LineEvent.Type.STOP) {
    	            event.getLine().close();
    	            clipDone.countDown();
    	        }
    	    }
    	});
        clip.setFramePosition(0); 
        clip.start();
        //clipDone.await();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
    public boolean running(){
    	return clip.isRunning();
    }
}
