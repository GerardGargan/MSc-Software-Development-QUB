package bookanlysis;

import java.util.Queue;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class BookReadSpeech implements Runnable {
	
	private boolean stopSpeech = false;
	public Queue<String> bookText;
	
	
	@Override
	public void run() {
		Voice voice;
		voice = VoiceManager.getInstance().getVoice("kevin");
		
		if(voice!=null) {
			voice.allocate();
		} 
		try {
		voice.setRate(140);
		voice.setPitch(70);
		voice.setVolume(1);
		
		
		while(!bookText.isEmpty()) {
			voice.speak(bookText.remove());
		}
		
		if(stopSpeech) {
			System.out.println("Stopping reading...");
			return;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public void stopSpeaking(boolean setting) {
		this.stopSpeech = setting;
	}

}
