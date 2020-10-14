package game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static BullsAndCows.BullsAndCowsModel.*;
import static BullsAndCows.BullsAndCowsView.*;

public class BullsAndCowsAppl {

	private static ArrayList<String> buffer = new ArrayList<String>();
	private static final int MAX_DIGITS = 4;
	
	public static void addToBuffer(String line,boolean print) {
		if(print)System.out.println(line);
		buffer.add(line);
	}

	public static void main(String[] args) throws IOException {
		
		String secret = genUniqueRandomNumber();
		if(args.length>0 && args[0].equals("--debug")) {
			System.out.println(secret);	
		}
		
		addToBuffer("Game of Cows and Bulls! Please gues the number (4 digits)",true);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String guess = reader.readLine();
			int[] result = compareToSecret(secret, guess);
			addToBuffer(guess,false);
			addToBuffer(String.format("%s (%d cows; %d bulls)", guess, result[0], result[1]),true);
			if (result[0] == 0 && result[1] == MAX_DIGITS) {
				addToBuffer("Finish!",true);
				sendToFile(buffer);
				break;
			}
		}
	}


}
