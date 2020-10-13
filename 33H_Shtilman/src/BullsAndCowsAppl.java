import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BullsAndCowsAppl {
	final static int MAX_DIGITS = 4;
	private static ArrayList<String> buffer = new ArrayList<String>();

	public static void addToBuffer(String line) {
		buffer.add(line);
	}

	public static void main(String[] args) throws FileNotFoundException {
		ArrayList<Integer> secret = genUniqueRandomNumber();
		String startText = "Game of Cows and Bulls! Please gues the number (4 digits)";
		addToBuffer(startText);
		System.out.println(startText);

		/*
		 * for (Integer c : secret) {
		 * System.out.print(Integer.parseInt(String.valueOf(c))); }
		 */

		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH_mm");
		String formattedDate = LocalDateTime.now().format(myFormatObj);
		Scanner scanner = new Scanner(System.in);
		int attemps = 0;
		while (true) {
			String guess = scanner.nextLine();
			addToBuffer(guess + "\n");
			attemps++;
			if (compareToSecret(secret, guess)) {
				addToBuffer("Finish!");
				System.out.println("Finish!");
				String filename = formattedDate + "_" + attemps;
				PrintStream ps = new PrintStream(filename);
				for (String i : buffer) {
					ps.print(i);
				}
				scanner.close();
				ps.close();
				break;
			}
		}
	}

	public static boolean compareToSecret(ArrayList<Integer> secret, String gues) {
		int cows = 0;
		int bulls = 0;
		char[] charGues = gues.toCharArray();
		for (int i = 0; i < charGues.length; i++) {
			try {
				Integer cGuess = Integer.parseInt("" + charGues[i]);
				int index = secret.indexOf(cGuess);
				if (index < 0) {
					continue;
				}
				if (index == i) {
					bulls++;
				} else {
					cows++;
				}
			} catch (Exception e) {
			}
		}
		String text = String.format("%s (%d cows; %d bulls)\n", gues, cows, bulls);
		System.out.printf(text);
		addToBuffer(text);
		return bulls == MAX_DIGITS && cows == 0;
	}

	public static ArrayList<Integer> genUniqueRandomNumber() {
		HashSet<Integer> set = new HashSet<Integer>(MAX_DIGITS);
		while (set.size() < MAX_DIGITS) {
			Random rand = new Random();
			set.add(rand.nextInt(8) + 1);
		}
		ArrayList<Integer> arr = new ArrayList<Integer>(MAX_DIGITS);
		arr.addAll(set);
		return arr;
	}
}
