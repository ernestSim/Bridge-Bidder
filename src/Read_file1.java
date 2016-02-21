import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/*---------------------------------------------------------------------------------------------------------------------*/
/*		B = DOUBLE			*/
/*		R = RE-DOUBLE		*/
/*		Neither = 0			*/
/*		Z = All Pass		*/
/*		NT = T				*/
/*	589.pdf error 14 cards	*/
/*	659.pdf error 14 cards	*/
/*	1029.pdf ?? wrong		*/
/*	1010.pdf error Jeff		*/
/* 598.pdf error DEALER VUL */
/*---------------------------------------------------------------------------------------------------------------------*/
public class Read_file1 {

	public static ArrayList<String> bids_test = new ArrayList<String>();
	public static void readFile() {
		
		String bid = "1C1D1H1S1T2C2D2H2S2T3C3D3H3S3T4C4D4H4S4T5C5D5H5S5T6C6D6H6S6T7C7D7H7S7T";
		int line=0;
		for (int i = 0; i < bid.length(); i += 2) {
			String x = "";
			x += bid.charAt(i);
			x += bid.charAt(i + 1);
			bids_test.add(x);
		}

		char letter = 0;
		ArrayList<Character> FullTest = new ArrayList<Character>();
		ArrayList<Character> PlayerCards = new ArrayList<Character>();

		String x = "23456789XJQKA23456789XJQKA23456789XJQKA23456789XJQKA";

		for (int i = 0; i < x.length(); i++) {
			FullTest.add(x.charAt(i));
		}
		Collections.sort(FullTest);
		File file = new File("ALL.txt");
		//File file = new File("test.txt");
		if (!file.exists()) {
			System.out.println(file.getName() + " does not exist.");
		}
		if (!(file.isFile() && file.canRead())) {
			System.out.println(file.getName() + " cannot be read from.");
		}
		try {
			FileInputStream fis = new FileInputStream(file);
			while (fis.available() > 0) {
				ArrayList<Character> test1 = new ArrayList<Character>();
				ArrayList<ArrayList<Character>> all = new ArrayList<ArrayList<Character>>();
				letter = (char) fis.read();
				if (letter != ' ' && letter != '!' && letter != '\n') {
					PlayerCards.add(letter);
				} else if (letter == ' ') {
					test1 = ErrorCheckCards(PlayerCards, line);
					if (!test1.equals(FullTest)) {

						System.out.println("Mistake in input(Full test) : "+ test1);
						System.out.println("In line : "+line);
						System.exit(0);
					} else {
						ArrayList<Character> bids = new ArrayList<Character>();
						char dealer = (char) fis.read();
						letter = (char) fis.read(); // SPACE
						char vulnerable = (char) fis.read();
						letter = (char) fis.read(); // SPACE
						all = CardInformation(PlayerCards, dealer, vulnerable);
						while (letter != '+') {
							letter = (char) fis.read();
							if (letter == '+') {
								line++;
								PlayerCards.clear();
								break;
							}
							bids.add(letter);
						}
						if (check_bids(bids,bids_test,line)) {

						}
						all.add(bids);
						GameInfo.addGame(all);
					}
				}
			}
			fis.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param line 
	 * @param bids_test2 ****************************************************************************************
	 ******************************************************************************************
	 ******************************************************************************************/
	// to do
	private static boolean check_bids(ArrayList<Character> bids, ArrayList<String> test, int line) {
		ArrayList<String> bidsMade = new ArrayList<String>();
		for (int i = 0; i < bids.size(); i ++) {
			String x = "";
			if(bids.get(i) == 'P' || bids.get(i) == 'R' || bids.get(i) == 'T' || bids.get(i) == 'B'){
				x += bids.get(i);
				bidsMade.add(x);
			}
			else if(Character.isDigit(bids.get(i))){
				x += bids.get(i);
				x +=bids.get(i + 1);
				bidsMade.add(x);
				i+=1;
			}
			
		}
		
		int previous = -1;
		String pBid ="";
		int passCounter=0;
		for (int i = 0; i < bidsMade.size(); i++) {
			//System.out.println(previous+"   "+bidsMade.get(i));
			if (test.indexOf(bidsMade.get(i)) > previous) {
				previous = test.indexOf(bidsMade.get(i));
				pBid = bidsMade.get(i);
				passCounter=0;
			}
			else if(bidsMade.get(i).contains("P")){
				passCounter++;
				if (passCounter > 3) {	
					System.out.println("More than 3 passes in a Row in LINE :"+line);
					System.exit(0);
				}
				//pBid = bidsMade.get(i);
			}
			else if(bidsMade.get(i).contains("B")){
				passCounter=0;;
				pBid = bidsMade.get(i);
			}
			else if(bidsMade.get(i).contains("R")){
				passCounter=0;;
				pBid = bidsMade.get(i);
			}
			else{
				System.out.println("Error in line : "+line);
				System.out.println("Previous bid : "+pBid);
				System.out.println("Current bid : "+bidsMade.get(i));
				System.exit(0);
			}

			
		}
		return false;
	}

	/******************************************************************************************
	 ******************************************************************************************
	 ******************************************************************************************/

	// call CountCards to count card in each suit ;
	// call countHandStrenght to count high cards ;
	// store all info in all ;

	private static ArrayList<ArrayList<Character>> CardInformation(
			ArrayList<Character> array, char dealer, char vulnerable) {

		ArrayList<ArrayList<Character>> all = new ArrayList<ArrayList<Character>>();
		ArrayList<Character> stats = new ArrayList<Character>();
		ArrayList<Character> north = new ArrayList<Character>();
		ArrayList<Character> south = new ArrayList<Character>();
		ArrayList<Character> east = new ArrayList<Character>();
		ArrayList<Character> west = new ArrayList<Character>();

		String x = "";
		for (int i = 1; i < array.size(); i++) {
			if (i < 18) {
				north.add(array.get(i));
			} else if (i > 18 && i < 36) {
				east.add(array.get(i));
			} else if (i > 36 && i < 54) {
				south.add(array.get(i));
			} else if (i > 54 && i < 72) {
				west.add(array.get(i));
			}
		}
		x = CountCards(north);
		for (int i = 0; i < x.length(); i++) {
			stats.add(x.charAt(i));
		}

		x = CountCards(east);
		for (int i = 0; i < x.length(); i++) {
			stats.add(x.charAt(i));
		}

		x = CountCards(south);
		for (int i = 0; i < x.length(); i++) {
			stats.add(x.charAt(i));
		}

		x = CountCards(west);
		for (int i = 0; i < x.length(); i++) {
			stats.add(x.charAt(i));
		}

		stats.add(dealer);
		stats.add(vulnerable);

		all.add(north);
		all.add(east);
		all.add(south);
		all.add(west);
		all.add(stats);

		return all;
	}

	/*****************************************************************************************
	 ******************************************************************************************
	 ******************************************************************************************/

	// count cards in each suit

	// count cards for each suit;
	private static String CountCards(ArrayList<Character> hand) {

		String answer = "";
		int i = 1;
		int j = 0;
		int counter = 0;

		while (j == 0) {
			if (hand.get(i) != 'H') {
				counter++;
				i++;
			} else {
				answer += counter;
				i++;
				break;
			}
		}
		counter = 0;
		while (j == 0) {
			if (hand.get(i) != 'D') {
				counter++;
				i++;
			} else {
				answer += counter;
				i++;
				break;
			}
		}
		counter = 0;
		while (j == 0) {
			if (hand.get(i) != 'C') {
				counter++;
				i++;
			} else {
				answer += counter;
				i++;
				break;
			}
		}
		counter = 0;
		while (j == 0) {
			if (i < hand.size()) {
				counter++;
				i++;
			} else {
				answer += counter;
				i++;
				break;
			}
		}
		return answer;
	}

	/*****************************************************************************************
	 ******************************************************************************************
	 ******************************************************************************************/

	// Cheack if input cards are correct
	// sorts input cards according to their suit and performs first 3 tests ;

	private static ArrayList<Character> ErrorCheckCards(ArrayList<Character> PlayerCards ,int l) {

		ArrayList<Character> test1 = new ArrayList<Character>();
		ArrayList<Character> FirstTest = new ArrayList<Character>();
		ArrayList<Character> SecondTest = new ArrayList<Character>();
		ArrayList<Character> ThirdTest = new ArrayList<Character>();

		String x = "23456789XJQKA";

		for (int i = 0; i < x.length(); i++) {
			FirstTest.add(x.charAt(i));
		}
		String y = "23456789XJQKA23456789XJQKA";

		for (int i = 0; i < y.length(); i++) {
			SecondTest.add(y.charAt(i));
		}

		String z = "23456789XJQKA23456789XJQKA23456789XJQKA";

		for (int i = 0; i < z.length(); i++) {
			ThirdTest.add(z.charAt(i));
		}

		char LastLetter = PlayerCards.get(0);
		int i = 0;
		while (i < PlayerCards.size()) {
			if ((PlayerCards.get(i) == 'S' && LastLetter == 'N')
					|| (PlayerCards.get(i) == 'S' && LastLetter == 'E')
					|| (PlayerCards.get(i) == 'S' && LastLetter == 'W')
					|| (PlayerCards.get(i) == 'S' && LastLetter == 'S')) {
				while (PlayerCards.get(i) != 'H') {
					if (PlayerCards.get(i) != 'S') {
						test1.add(PlayerCards.get(i));
						//System.out.println(PlayerCards.get(i));
						i++;
					} else {
						i++;
					}
				}
				LastLetter = PlayerCards.get(i);
				i++;

			} else {
				LastLetter = PlayerCards.get(i);
				i++;
			}
		}
		Collections.sort(test1);
		Collections.sort(FirstTest);
		if (!test1.equals(FirstTest)) {
			System.out.println("Mistake in input(first test) : " + test1 +"LINE "+l);
			System.exit(0);
		}
		i = 0;
		while (i < PlayerCards.size()) {
			if (PlayerCards.get(i) == 'H') {
				while (PlayerCards.get(i) != 'D') {
					if (PlayerCards.get(i) != 'H') {
						test1.add(PlayerCards.get(i));
						i++;
					} else {
						i++;
					}
				}
				i++;
			} else {
				i++;
			}
		}
		Collections.sort(test1);
		Collections.sort(SecondTest);
		if (!test1.equals(SecondTest)) {
			System.out.println("Mistake in input(seocnd test) : " + test1+"LINE "+l);
			System.exit(0);
		}
		i = 0;
		while(i < PlayerCards.size()){
			if(PlayerCards.get(i) == 'D'){
				while(PlayerCards.get(i) != 'C'){
					if(PlayerCards.get(i) != 'D'){
						test1.add(PlayerCards.get(i));
						i++;
					}
					else{
						i++;
					}
				}
			}
			i++;
		}
		Collections.sort(test1);
		Collections.sort(ThirdTest);
		if (!test1.equals(ThirdTest)) {
			System.out.println("Mistake in input(third test) : " + test1+"LINE "+l);
			System.exit(0);
		}
		i = 0;
		while(i < PlayerCards.size()){
			if (PlayerCards.get(i) == 'C') {
				while(PlayerCards.get(i) != 'E' &&
						PlayerCards.get(i) != 'S' &&
						PlayerCards.get(i) != 'W'){
					if (PlayerCards.get(i) != 'C') {
						test1.add(PlayerCards.get(i));
					}

					i++;
					if(i > 71){
						break;
					}
				}			
			}
			else{
				i++;
			}
		}
		
		Collections.sort(test1);
		return test1;
	}
	
}