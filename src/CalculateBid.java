import java.util.ArrayList;

import javax.swing.text.Position;


public class CalculateBid {

	public static void getFirstBid(int game , int player) {
		ArrayList<Character> hand = new ArrayList<Character>();
		ArrayList<Character> info = new ArrayList<Character>();
		int cardsInSuit;
		int[][] x;
		
		hand = GameInfo.getPlayerCards(game, player);
		info = GameInfo.getGameInfo(game);
		System.out.println("Printing results for all bids :");
		x=BuildTables.getTables().get(0).get(0);
		System.out.println(x);
		cardsInSuit = GameInfo.getSuitValue(player, 'S', game);
		CalculateAllBids(cardsInSuit,x,'S');
		
		x=BuildTables.getTables().get(0).get(1);
		cardsInSuit = GameInfo.getSuitValue(player, 'H', game);
		CalculateAllBids(cardsInSuit,x,'H');
		
		x=BuildTables.getTables().get(0).get(2);
		cardsInSuit = GameInfo.getSuitValue(player, 'D', game);
		CalculateAllBids(cardsInSuit,x,'D');
		
		x=BuildTables.getTables().get(0).get(3);
		cardsInSuit = GameInfo.getSuitValue(player, 'C', game);
		CalculateAllBids(cardsInSuit,x,'C');
		
		System.out.println("\nPrinting results for first bids :");
		x=BuildTables.getTables().get(1).get(0);
		cardsInSuit = GameInfo.getSuitValue(player, 'S', game);
		CalculateAllBids(cardsInSuit,x,'S');
		
		x=BuildTables.getTables().get(1).get(1);
		cardsInSuit = GameInfo.getSuitValue(player, 'H', game);
		CalculateAllBids(cardsInSuit,x,'H');
		
		x=BuildTables.getTables().get(1).get(2);
		cardsInSuit = GameInfo.getSuitValue(player, 'D', game);
		CalculateAllBids(cardsInSuit,x,'D');
		
		x=BuildTables.getTables().get(1).get(3);
		cardsInSuit = GameInfo.getSuitValue(player, 'C', game);
		CalculateAllBids(cardsInSuit,x,'C');
		
		System.out.println("\nPrinting results for all high suit bids :");
		x=BuildTables.getTables().get(2).get(0);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'S');
		CalculateAllBids(cardsInSuit,x,'S');
		
		x=BuildTables.getTables().get(2).get(1);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'H');
		CalculateAllBids(cardsInSuit,x,'H');
		
		x=BuildTables.getTables().get(2).get(2);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'D');
		CalculateAllBids(cardsInSuit,x,'D');
		
		x=BuildTables.getTables().get(2).get(3);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'C');
		CalculateAllBids(cardsInSuit,x,'C');
		
		System.out.println("\nPrinting results for first high suit bids :");
		x=BuildTables.getTables().get(3).get(0);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'S');
		CalculateAllBids(cardsInSuit,x,'S');
		
		x=BuildTables.getTables().get(3).get(1);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'H');
		CalculateAllBids(cardsInSuit,x,'H');
		
		x=BuildTables.getTables().get(3).get(2);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'D');
		CalculateAllBids(cardsInSuit,x,'D');
		
		x=BuildTables.getTables().get(3).get(3);
		cardsInSuit = GameInfo.countPlayerSuitStrenght(game, player, 'C');
		CalculateAllBids(cardsInSuit,x,'C');
		
		System.out.println("\nPrinting results for all high hand bids :");
		x=BuildTables.getTables().get(2).get(0);
		cardsInSuit = GameInfo.countPlayerHandStrenght(game, player);
		CalculateAllBids(cardsInSuit,x,' ');
		
		
	}

	private static void CalculateAllBids(int cardsInSuit, int[][] x, char s) {
		double total = 0;
		int max=0;
		int row;
		int col = 0;
		
		row = getRow(cardsInSuit);
		
		for (int j = 0; j < 38; j++) {
			if (max < x[row][j]) {
				max = x[row][j];
				col=j;
			}
			total += x[row][j];
		}

		total = max/total*100;

		System.out.println("Player with "+cardsInSuit+" in "+s+" suit is likely to :	"+Calculatebid(col)+"	"+String.format("%.2f",total)+"% ");
		
	}

	private static String Calculatebid(int col) {

		String[] possibleBids = {"1S", "1H", "1D", "1C", "1NT","2S", "2H", "2D", "2C","2NT","3S", "3H", "3D", "3C","3NT",
							     "4S", "4H", "4D", "4C", "4NT","5S", "5H", "5D", "5C", "5NT","6S", "6H", "6D","6C","6NT",
							     "7S", "7H", "7D", "7C", "7NT","PASS", "DOUBLE","RE-DOUBLE"};
		
		return possibleBids[col];
	}

	private static int getRow(int c) {

		if (c < 2) {
			c = 0;
		}
		else if (c > 1 && c < 4) {
			c = 1;
		}
		else if (c > 3 && c < 7) {
			c = 2;
		}
		else if (c >= 7) {
			c = 3;
		}
		
		return c;
	}
}
