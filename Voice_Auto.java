package testing;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voice_Auto {

	public static void main(String[] args) {
		// get text
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your text");
        String x = sc.nextLine();
        //covert text into voice
        VoiceManager vm  = VoiceManager.getInstance();
        Voice v = vm.getVoice("kevin");
        v.allocate();
        v.speak(x);
        v.deallocate();
        
	}

}
