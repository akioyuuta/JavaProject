import java.util.*;
import javax.swing.*;
import javax.sound.sampled.*;

abstract class Instrument{
	public String name;
	public String key, tune;
	
	public abstract void play();
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setKey(String key){
		this.key = key;
	}
	
	public String getKey(){
		return this.key;
	}
	
	public void setTune(String tune){
		this.tune = tune;
	}
	
	public String getTune(){
		return this.tune;
	}
}

abstract class Aerophone extends Instrument{
	
	protected boolean stream;
	
	public abstract boolean isStreamDirect();
	
	public void setStream(boolean stream){
		this.stream = stream;
	}
	
	public boolean getStream(){
		return this.stream;
	}
	
}

abstract class Cordophone extends Instrument{
	
	protected int stringNum;
	
	public abstract int stringNum();
	
	public void setStringNum(int num){
		this.stringNum = num;
	}
	
	public int getStringNum(){
		return this.stringNum;
	}
	
}

abstract class Electrophone extends Instrument{
	protected int tuneNum;
	
	public abstract int tuneNum();
	
	public void setTuneNum(int num){
		this.tuneNum = num;
	}
}

interface PlayTune{
	public void play();
	public void play(String song);
	public void stop();
}

class Flute extends Aerophone implements PlayTune{
	
	private Sound play;
	
	Flute(){
		 this.play = new Sound("Flute.wav");
		 this.stream = true;
	}
	
	public boolean isStreamDirect(){
		return this.stream;
	}
	
	public void play(){
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void play(String song){
		this.play = new Sound(song);
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void stop(){
		this.play.stop();
	}
}

class ClassicGuitar extends Cordophone implements PlayTune{
	private Sound play;
	
	ClassicGuitar(){
		this.stringNum = 6;
		this.play = new Sound("ClassicGuitar.wav");
	}
	
	ClassicGuitar(int string){
		this.stringNum = string;
		this.play = new Sound("ClassicGuitar.wav");
	}
	
	public int stringNum(){
		return this.stringNum;
	}
	
	public void play(){
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void play(String song){
		this.play = new Sound(song);
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void stop(){
		this.play.stop();
	}
}

class Bass extends Cordophone implements PlayTune{
	private Sound play;
	
	Bass(){
		this.stringNum = 5;
		this.play = new Sound("Bass.wav");
	}
	
	Bass(int string){
		this.stringNum = string;
		this.play = new Sound("Bass.wav");
	}
	
	public void play(){
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public int stringNum(){
		return this.stringNum;
	}
	
	public void play(String song){
		this.play = new Sound(song);
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void stop(){
		this.play.stop();
	}
}

class Violin extends Cordophone implements PlayTune{
	private Sound play;
	Violin(){
		this.stringNum = 4;
		this.play = new Sound("Violin.wav");
	}
	
	Violin(int string){
		this.stringNum = string;
		this.play = new Sound("Violin.wav");
	}
	
	public int stringNum(){
		return this.stringNum;
	}
	
	public void play(){
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void play(String song){
		this.play = new Sound(song);
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void stop(){
		this.play.stop();
	}
}

class Keyboard extends Electrophone implements PlayTune{
	private Sound play;
	Keyboard(){
		this.tuneNum = 6;
		this.play = new Sound("Keyboard.wav");
	}
	
	Keyboard(int tune){
		this.tuneNum = tune;
		this.play = new Sound("Keyboard.wav");
	}
	
	public int tuneNum(){
		return this.tuneNum;
	}
	
	public void play(){
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void play(String song){
		this.play = new Sound(song);
        this.play.play();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Close to exit!");
            }
        });
	}
	
	public void stop(){
		this.play.stop();
	}
}

class main{
	public static void main(String[] args){
		Bass bass = new Bass();
		//bass.setName("Meong");
		//System.out.println(bass.getName());
		//bass.play();
		//bass.setStringNum(7);
		//System.out.println(bass.getStringNum());
		Flute flute = new Flute();
		//flute.play();
		ClassicGuitar guitar = new ClassicGuitar();
		//guitar.play();
		Violin violin = new Violin();
		//violin.play("Lol.wav");
		Keyboard keyboard = new Keyboard();
		//keyboard.play();
		
		String fluteSong = "fluteSong.wav";
		String bassSong = "bassSong.wav";
		String guitarSong = "guitarSong.wav";
		String violinSong = "violinSong.wav";
		String keyboardSong = "keyboardSong.wav";
		
		while(true){
			System.out.println("Choose Instrument:");
			System.out.println("[1] Flute");
			System.out.println("[2] Classic Guitar");
			System.out.println("[3] Bass");
			System.out.println("[4] Violin");
			System.out.println("[5] Keyboard");
			System.out.println("[6] Exit");
			System.out.print("Pick : ");
			int pick;
			Scanner scanner = new Scanner(System.in);
			pick = scanner.nextInt();
			if(pick == 6){
				break;
			}
			
			while(true){
				System.out.println("Choose Action:");
				System.out.println("[1] Play");
				System.out.println("[2] Play Song");
				System.out.println("[3] Stop");
				System.out.println("[4] Back");
				System.out.print("Pick : ");
				int choice = scanner.nextInt();
				if(choice == 1){
					if(pick == 1){
						flute.play();
					}else if(pick == 2){
						guitar.play();
					}else if(pick == 3){
						bass.play();
					}else if(pick == 4){
						violin.play();
					}else if(pick == 5){
						keyboard.play();
					}
				}else if(choice == 2){
					if(pick == 1){
						flute.play(fluteSong);
					}else if(pick == 2){
						guitar.play(guitarSong);
					}else if(pick == 3){
						bass.play(bassSong);
					}else if(pick == 4){
						violin.play(violinSong);
					}else if(pick == 5){
						keyboard.play(keyboardSong);
					}
				}else if(choice == 3){
					if(pick == 1){
						flute.stop();
					}else if(pick == 2){
						guitar.stop();
					}else if(pick == 3){
						bass.stop();
					}else if(pick == 4){
						violin.stop();
					}else if(pick == 5){
						keyboard.stop();
					}
				}else if(choice == 4){
					break;
				}
			}
		}
		
	}
}