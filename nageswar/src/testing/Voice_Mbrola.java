package testing;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Voice_Mbrola {

	public static void main(String[] args) {
		// get text
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your text");
		String x = sc.nextLine();
		//conver text into voice
		System.setProperty("mbrola.base", "D:\\batch241\\mbrola");
		VoiceManager vm = VoiceManager.getInstance();
		Voice v = vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();

	}

}
