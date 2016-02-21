import java.lang.reflect.Array;
import java.util.ArrayList;

/*---------------------------*/
/*	         dealer			 */
/*			  0=N			 */
/*			  1=E			 */
/*			  2=S			 */
/*			  3=W			 */
/*---------------------------*/

public class GameInfo {

	static ArrayList<ArrayList<ArrayList<Character>>> games = new ArrayList<ArrayList<ArrayList<Character>>>();
	static ArrayList<Array> bids = new ArrayList<Array>();


	public GameInfo() {

	}
	
	/**********************************

	   This is the start of a method

	**********************************/
	
	public static void addGame(ArrayList<ArrayList<Character>> game) {

		games.add(game);
	}
	
	/**********************************

	   This is the start of a method

	**********************************/

	public static int getDealer(int i) {
		char dealer = games.get(i).get(4).get(games.get(i).get(4).size() - 2);
		int d = 0;

		if (dealer == 'N') {
			d = 0;
		} else if (dealer == 'E') {
			d = 1;
		} else if (dealer == 'S') {
			d = 2;
		} else if (dealer == 'W') {
			d = 3;
		} else {
			System.out.println("Dealer for game " + i + " is wrong");
		}

		return d;

	}
	
	/**********************************

	   This is the start of a method

	**********************************/

	public static ArrayList<Character> getGameInfo(int i) {

		return games.get(i).get(4);
	}
	
	/**********************************

	   This is the start of a method

	**********************************/

	public static ArrayList<Character> getGameBids(int i) {

		return games.get(i).get(5);
	}
	
	/**********************************

	   This is the start of a method

	**********************************/

	public static ArrayList<Character> getPlayerCards(int i, int j) {

		return games.get(i).get(j);
	}
	
	/**********************************

	   This is the start of a method

	**********************************/

	public static void PrintGames() {
		for (int i = 0; i < games.size(); i++) {
			System.out.println(games.get(i));
		}
		 System.out.println(games.size());
	}
	
	/**********************************

	   This is the start of a method

	**********************************/
	
	public static int getSuitValue(int p, char s,int g) {
		
		int k = (p) * 4;
		if (s == 'H') {
			k++;
		} else if (s == 'D') {
			k += 2;
		} else if (s == 'C') {
			k += 3;
		}
		
		return Character.getNumericValue(getGameInfo(g).get(k));
		
	}
  
	/**********************************

	   This is the start of a method

	**********************************/
	
	public static int countPlayerSuitStrenght(int g, int p, char s){

		int total=0;
		ArrayList<Character> hand = games.get(g).get(p);
		int i = hand.indexOf(s)+1;
		if (s=='S') {
			while (hand.get(i)!='H') {
				if (hand.get(i) == 'A' || hand.get(i) == 'K' || hand.get(i) == 'Q'
						|| hand.get(i) == 'J') {
					total++;
				}
				i++;
			}
		}
		else if (s == 'H') {
			while (hand.get(i)!='D') {
				if (hand.get(i) == 'A' || hand.get(i) == 'K' || hand.get(i) == 'Q'
						|| hand.get(i) == 'J') {
					total++;
				}
				i++;
			}
		}
		else if (s=='D') {
			while (hand.get(i)!='C') {
				if (hand.get(i) == 'A' || hand.get(i) == 'K' || hand.get(i) == 'Q'
						|| hand.get(i) == 'J') {
					total++;
				}
				i++;
			}
		}
		else if (s=='C') {
			while (i!=hand.size()) {
				if (hand.get(i) == 'A' || hand.get(i) == 'K' || hand.get(i) == 'Q'
						|| hand.get(i) == 'J') {
					total++;
				}
				i++;
			}
		}
		
		return total;
		
	}

	/**********************************

	   This is the start of a method

	**********************************/
	
	public static int countPlayerHandStrenght(int g, int p){
		
		int total=0;
		ArrayList<Character> hand = games.get(g).get(p);
		for (int i = 0; i < hand.size(); i++) {	
			if (hand.get(i) == 'A' || hand.get(i) == 'K' || hand.get(i) == 'Q'
					|| hand.get(i) == 'J') {
				total++;
			}
		}
		
		return total;
		
	}
	
	public static  ArrayList<String> getBidsFor(int g, int p){
		 ArrayList<String> x = new  ArrayList<String>();
		 ArrayList<Character> test = new  ArrayList<Character>();
		 ArrayList<String> all = new  ArrayList<String>();
		 
		 test = getGameBids(g);
		 
			for (int i = 0; i < test.size(); i ++) {
				String temp = "";
				if(test.get(i) == 'P' || test.get(i) == 'R'  || test.get(i) == 'B'){
					temp += test.get(i);
					all.add(temp);
				}
				else if(Character.isDigit(test.get(i))){
					temp += test.get(i);
					temp +=test.get(i + 1);
					all.add(temp);
				}
				
			}
			int temp = 0;
			int dealer = getDealer(g);
			if(dealer == 0){
				temp = p;
			}
			else if(dealer == 1){
				if(p == 0){
					temp = 3;
				}
				else if(p == 1){
					temp = 0;
				}
				else if(p == 2){
					temp = 1;
				}
				else if(p == 3){
					temp = 2;
				}
			}
			else if(dealer == 2){
				if(p == 0){
					temp = 2;
				}
				else if(p == 1){
					temp = 3;
				}
				else if(p == 2){
					temp = 0;
				}
				else if(p == 3){
					temp = 1;
				}
			}
			else if(dealer == 3){
				if(p == 0){
					temp = 1;
				}
				else if(p == 1){
					temp = 2;
				}
				else if(p == 2){
					temp = 3;
				}
				else if(p == 3){
					temp = 0;
				}
			}
			
			for (int i = temp; i < all.size(); i+=4) {
				//System.out.println(all.get(i));
				x.add(all.get(i));
				
			}
			//System.out.println(x);
			
		return x;
			
	}
}
