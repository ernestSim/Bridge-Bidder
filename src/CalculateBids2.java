import java.util.ArrayList;


public class CalculateBids2 {
	private static double[][] AllbidsCardsInSuit = new double[1][38];
	private static double[][] FirstbidsCardsInSuit = new double[1][38];
	
	private static double[][] AllbidsHighCardSuit = new double[1][38];
	private static double[][] FirstbidsHighCardSuit = new double[1][38];
	
	private static double[][] AllbidsHighCardHand = new double[1][38];
	
	
	private static int[][] NorthInfoBid2 = new int[1][3];
	private static int[][] EastInfoBid2 = new int[1][3];
	private static int[][] SouthInfoBid2 = new int[1][3];
	private static int[][] WestInfoBid2 = new int[1][3];
	
	private static double[][] FirstBidBid = new double[1][38];
	private static double[][] AllBidBid = new double[1][38];
	
	
	private static int[][] NorthInfoSuit2 = new int[1][5];
	private static int[][] EastInfoSuit2 = new int[1][5];
	private static int[][] SouthInfoSuit2 = new int[1][5];
	private static int[][] WestInfoSuit2 = new int[1][5];
	
	private static double[][] FirstBidSuit = new double[1][38];
	private static double[][] AllBidSuit = new double[1][38];
	
	private static double[][] FirstTotal = new double[1][38];
	private static double[][] SecondTotal = new double[1][38];
	
	private static double correct ;
	private static double incorrect ;
	private static double tots ;
	
	public static void CalculateBids() {

		for (int i = 0; i < 910; i++) {
			for (int j = 0; j < 4; j++) {
				populateArray();
				getAllBidsAmountSuit(i,j);
				getFirstBidsAmountSuit(i,j);
				getAllBidsHighCardSuit(i,j);
				getFirstBidsHighCardSuit(i,j);
				getAllHighCardsInHand(i,j);
				getHistory(i,j);
				getTotal();
				System.out.println("Actual Bids :"+GameInfo.getBidsFor(i, j));
				System.out.println("Estimated First Bid : "+ getBid(getFirst()));
				
				if (GameInfo.getBidsFor(i, j).size() > 0) {
					if (getBid(getFirst()).equalsIgnoreCase(GameInfo.getBidsFor(i, j).get(0)) ) {
						tots++;
						correct++;
					}
					else {
						tots++;
						incorrect++;
					}
				}
				System.out.println("Estimated  Bid : "+ getBid(getSecond()));
				if (GameInfo.getBidsFor(i, j).size() > 1) {
					if (getBid(getSecond()).equalsIgnoreCase(GameInfo.getBidsFor(i, j).get(1)) ) {
						tots++;
						correct++;
					}
					else {
						tots++;
						incorrect++;
					}
				}
				System.out.println();
			}


		}
	
		System.out.println();
		System.out.println("Correct evaluations percentage : "+String.format("%.2f",correct/tots*100)+"% ");
		System.out.println("Correct evaluations : "+(int)correct);
		System.out.println("Incorrect evaluations : "+(int)incorrect);
		System.out.println("Total evaluations : "+(int)tots);
		System.out.println();
		
	}
	
	
private static int getSecond() {
	double max = SecondTotal[0][0];
	int l = 0;
		for ( int i = 0; i < 38; i++) {
			if (SecondTotal[0][i] >= max) {
				max = SecondTotal[0][i];
				l=i;
			}
		}
		return l;	
		
	}

private static String getBid(int l) {
	String[] bids = {"1C","1D","1H","1S","1T","2C","2D","2H","2S","2T",
			"3C","3D","3H","3S","3T","4C","4D","4H","4S","4T",
			"5C","5D","5H","5S","5T","6C","6D","6H","6S","6T",
			"7C","7D","7H","7S","7T","P","D","R"};
	return bids[l];
}


private static int getFirst() {
	double max = FirstTotal[0][0];
	int l = 0;
		for ( int i = 0; i < 38; i++) {
			if (FirstTotal[0][i] >= max) {
				max = FirstTotal[0][i];
				l=i;
			}
		}

		return l;
	}

private static void getTotal() {
		for (int i = 0; i < 38; i++) {
			FirstTotal[0][i] = FirstbidsCardsInSuit[0][i] * FirstbidsHighCardSuit[0][i] * FirstBidBid[0][i] * FirstBidSuit[0][i] ;
			SecondTotal[0][i] = AllbidsCardsInSuit[0][i] * AllbidsHighCardSuit[0][i] * AllbidsHighCardHand[0][i] * AllBidBid[0][i] * AllBidSuit[0][i];
		}
		
	}

private static void populateArray() {
	NorthInfoBid2[0][0] = 1;
	NorthInfoBid2[0][1] = 0;
	NorthInfoBid2[0][2] = 0;
	
	EastInfoBid2[0][0] = 1;
	EastInfoBid2[0][1] = 0;
	EastInfoBid2[0][2] = 0;
	
	SouthInfoBid2[0][0] = 1;
	SouthInfoBid2[0][1] = 0;
	SouthInfoBid2[0][2] = 0;
	
	WestInfoBid2[0][0] = 1;
	WestInfoBid2[0][1] = 0;
	WestInfoBid2[0][2] = 0;
	
	for (int i = 0; i < 5; i++) {
		NorthInfoSuit2[0][i] = 0;
		EastInfoSuit2[0][i] = 0;
		SouthInfoSuit2[0][i] = 0;
		WestInfoSuit2[0][i] = 0;
	}
		
	}

private static int getHistory(int g, int p) {
	ArrayList<Character> gameBids = new ArrayList<Character>();
	gameBids = GameInfo.getGameBids(g);
	int dealer = GameInfo.getDealer(g);
	int check = 0;
	if (p == dealer) {
		check = 1;
	}

	for (int i = 0; i < gameBids.size(); i++) {
		if (dealer == 0) {
			if (p == dealer) {
				if (check == 1) {
					FirstBidBid(p);
					FirstBidSuit(p);
					check = 0;
				}
				else{
					getBidBid(p);
					getBidSuit(p);
					return 0;
				}
			}
			NorthInfoBid2[0][0] = 0;
			if (gameBids.get(i) == 'P') {
				NorthInfoBid2[0][1] = 1 ;
			}
			else{
				NorthInfoBid2[0][2] = 1;
			}
			
			if (Character.isDigit(gameBids.get(i))) {
				if (gameBids.get(i+1) == 'C') {
					NorthInfoSuit2[0][0] = 1;
				}
				else if(gameBids.get(i+1) == 'D'){
					NorthInfoSuit2[0][1] = 1;
				}
				else if(gameBids.get(i+1) == 'H'){
					NorthInfoSuit2[0][2] = 1;
				}
				else if(gameBids.get(i+1) == 'S'){
					NorthInfoSuit2[0][3] = 1;
				}
				else if(gameBids.get(i+1) == 'T'){
					NorthInfoSuit2[0][4] = 1;
				}
			}
		}
		if (dealer == 1) {
			if (p == dealer) {
				if (check == 1) {
					FirstBidBid(p);
					FirstBidSuit(p);
					check =0;
				}
				else{
					getBidBid(p);
					getBidSuit(p);
					return 0;
				}
			}
			EastInfoBid2[0][0] = 0;
			if (gameBids.get(i) == 'P') {
				EastInfoBid2[0][1] = 1 ;
			}
			else{
				EastInfoBid2[0][2] = 1;
			}
			if (Character.isDigit(gameBids.get(i))) {
				if (gameBids.get(i+1) == 'C') {
					EastInfoSuit2[0][0] = 1;
				}
				else if(gameBids.get(i+1) == 'D'){
					EastInfoSuit2[0][1] = 1;
				}
				else if(gameBids.get(i+1) == 'H'){
					EastInfoSuit2[0][2] = 1;
				}
				else if(gameBids.get(i+1) == 'S'){
					EastInfoSuit2[0][3] = 1;
				}
				else if(gameBids.get(i+1) == 'T'){
					EastInfoSuit2[0][4] = 1;
				}
			}
		}
		if (dealer == 2) {
			if (p == dealer) {
				if (check == 1) {
					FirstBidBid(p);
					FirstBidSuit(p);
					check =0;
				}
				else{
					getBidBid(p);
					getBidSuit(p);
					return 0;
				}
			}
			SouthInfoBid2[0][0] = 0;
			if (gameBids.get(i) == 'P') {
				SouthInfoBid2[0][1] = 1 ;
			}
			else{
				SouthInfoBid2[0][2] = 1;
			}
			if (Character.isDigit(gameBids.get(i))) {
				if (gameBids.get(i+1) == 'C') {
					SouthInfoSuit2[0][0] = 1;
				}
				else if(gameBids.get(i+1) == 'D'){
					SouthInfoSuit2[0][1] = 1;
				}
				else if(gameBids.get(i+1) == 'H'){
					SouthInfoSuit2[0][2] = 1;
				}
				else if(gameBids.get(i+1) == 'S'){
					SouthInfoSuit2[0][3] = 1;
				}
				else if(gameBids.get(i+1) == 'T'){
					SouthInfoSuit2[0][4] = 1;
				}
			}
		}
		if (dealer == 3) {
			if (p == dealer) {
				if (check == 1) {
					FirstBidBid(p);
					FirstBidSuit(p);
					check =0;
				}
				else{
					getBidBid(p);
					getBidSuit(p);
					return 0;
				}
			}
			WestInfoBid2[0][0] = 0;
			if (gameBids.get(i) == 'P') {
				WestInfoBid2[0][1] = 1 ;
			}
			else{
				WestInfoBid2[0][2] = 1;
			}
			if (Character.isDigit(gameBids.get(i))) {
				if (gameBids.get(i+1) == 'C') {
					WestInfoSuit2[0][0] = 1;
				}
				else if(gameBids.get(i+1) == 'D'){
					WestInfoSuit2[0][1] = 1;
				}
				else if(gameBids.get(i+1) == 'H'){
					WestInfoSuit2[0][2] = 1;
				}
				else if(gameBids.get(i+1) == 'S'){
					WestInfoSuit2[0][3] = 1;
				}
				else if(gameBids.get(i+1) == 'T'){
					WestInfoSuit2[0][4] = 1;
				}
			}
		}	
		if (Character.isDigit(gameBids.get(i))) {
			i++;
		}
		dealer++;
		if (dealer > 3) {
			dealer =0;
		}
	}
	return 0;
		
}

private static void FirstBidSuit(int p) {
	
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(6);
	
	int location = 16;
	if (p == 1) {
		location = 20;
	}
	else if (p == 2) {
		location = 24;
	}
	else if (p == 3) {
		location = 28;
	}
	
	double total1 = 0;
	double total2 = 0;
	double total3 = 0;
	double total4 = 0;
	double total5 = 0;
	double total6 = 0;
	double total7 = 0;
	double total8 = 0;
	double total9 = 0;
	double total10 = 0;
	double total11 = 0;
	double total12 = 0;
	double total13 = 0;
	double total14 = 0;
	double total15 = 0;
	double total16 = 0;
	double total17 = 0;
	double total18 = 0;
	double total19 = 0;
	double total20 = 0;
	
	for (int i = 0; i < 38; i++) {
		total1 += tables.get(location)[0][i];
		total2 += tables.get(location)[1][i];
		total3 += tables.get(location)[2][i];
		total4 += tables.get(location)[3][i];
		total5 += tables.get(location)[4][i];
		
		total6 += tables.get(location+1)[0][i];
		total7 += tables.get(location+1)[1][i];
		total8 += tables.get(location+1)[2][i];
		total9 += tables.get(location+1)[3][i];
		total10 += tables.get(location+1)[4][i];
		
		total11 += tables.get(location+2)[0][i];
		total12 += tables.get(location+2)[1][i];
		total13 += tables.get(location+2)[2][i];
		total14 += tables.get(location+2)[3][i];
		total15 += tables.get(location+2)[4][i];
		
		total16 += tables.get(location+3)[0][i];
		total17 += tables.get(location+3)[1][i];
		total18 += tables.get(location+3)[2][i];
		total19 += tables.get(location+3)[3][i];
		total20 += tables.get(location+3)[4][i];
	}
	for (int i = 0; i < 38; i++) {
		double t = 1;
		if (tables.get(location)[0][i] != 0) {
			t = t * (tables.get(location)[0][i]-1/total1-1);
		}
		if (tables.get(location)[1][i] != 0) {
			t = t * (tables.get(location)[1][i]-1/total2-1);
		}
		if (tables.get(location)[2][i] != 0) {
			t = t * (tables.get(location)[2][i]-1/total3-1);
		}
		if (tables.get(location)[3][i] != 0) {
			t = t * (tables.get(location)[3][i]-1/total4-1);
		}
		if (tables.get(location)[4][i] != 0) {
			t = t * (tables.get(location)[4][i]-1/total5-1);
		}
		
		if (tables.get(location+1)[0][i] != 0) {
			t = t * (tables.get(location+1)[0][i]-1/total6-1);
		}
		if (tables.get(location+1)[1][i] != 0) {
			t = t * (tables.get(location+1)[1][i]-1/total7-1);
		}
		if (tables.get(location+1)[2][i] != 0) {
			t = t * (tables.get(location+1)[2][i]-1/total8-1);
		}
		if (tables.get(location+1)[3][i] != 0) {
			t = t * (tables.get(location+1)[3][i]-1/total9-1);
		}
		if (tables.get(location+1)[4][i] != 0) {
			t = t * (tables.get(location+1)[4][i]-1/total10-1);
		}
		
		if (tables.get(location+2)[0][i] != 0) {
			t = t * (tables.get(location+2)[0][i]-1/total11-1);
		}
		if (tables.get(location+2)[1][i] != 0) {
			t = t * (tables.get(location+2)[1][i]-1/total12-1);
		}
		if (tables.get(location+2)[2][i] != 0) {
			t = t * (tables.get(location+2)[2][i]-1/total13-1);
		}
		if (tables.get(location+2)[3][i] != 0) {
			t = t * (tables.get(location+2)[3][i]-1/total14-1);
		}
		if (tables.get(location+2)[4][i] != 0) {
			t = t * (tables.get(location+2)[4][i]-1/total15-1);
		}
		
		if (tables.get(location+3)[0][i] != 0) {
			t = t * (tables.get(location+3)[0][i]-1/total16-1);
		}
		if (tables.get(location+3)[1][i] != 0) {
			t = t * (tables.get(location+3)[1][i]-1/total17-1);
		}
		if (tables.get(location+1)[2][i] != 0) {
			t = t * (tables.get(location+3)[2][i]-1/total18-1);
		}
		if (tables.get(location+3)[3][i] != 0) {
			t = t * (tables.get(location+3)[3][i]-1/total19-1);
		}
		if (tables.get(location+3)[4][i] != 0) {
			t = t * (tables.get(location+3)[4][i]-1/total20-1);
		}
		FirstBidSuit[0][i]  = t;
	}
}

private static void getBidSuit(int p) {
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(6);
	
	int location = 0;
	if (p == 1) {
		location = 4;
	}
	else if (p == 2) {
		location = 8;
	}
	else if (p == 3) {
		location = 12;
	}
	
	double total1 = -1;
	double total2 = -1;
	double total3 = -1;
	double total4 = -1;
	double total5 = -1;
	double total6 = -1;
	double total7 = -1;
	double total8 = -1;
	double total9 = -1;
	double total10 = -1;
	double total11 = -1;
	double total12 = -1;
	double total13 = -1;
	double total14 = -1;
	double total15 = -1;
	double total16 = -1;
	double total17 = -1;
	double total18 = -1;
	double total19 = -1;
	double total20 = -1;
	
	if (NorthInfoSuit2[0][0] == 1) {
		total1 = 0;
	}
	if (NorthInfoSuit2[0][1] == 1) {
		total2 = 0;
	}
	if (NorthInfoSuit2[0][2] == 1) {
		total3 = 0;
	}
	if (NorthInfoSuit2[0][3] == 1) {
		total4 = 0;
	}
	if (NorthInfoSuit2[0][4] == 1) {
		total5 = 0;
	}
	
	if (EastInfoSuit2[0][0] == 1) {
		total6 = 0;
	}
	if (EastInfoSuit2[0][1] == 1) {
		total7 = 0;
	}
	if (EastInfoSuit2[0][2] == 1) {
		total8 = 0;
	}
	if (EastInfoSuit2[0][3] == 1) {
		total9 = 0;
	}
	if (EastInfoSuit2[0][4] == 1) {
		total10 = 0;
	}
	
	if (SouthInfoSuit2[0][0] == 1) {
		total11 = 0;
	}
	if (SouthInfoSuit2[0][1] == 1) {
		total12 = 0;
	}
	if (SouthInfoSuit2[0][2] == 1) {
		total13 = 0;
	}
	if (SouthInfoSuit2[0][3] == 1) {
		total14 = 0;
	}
	if (SouthInfoSuit2[0][4] == 1) {
		total15 = 0;
	}
	
	if (WestInfoSuit2[0][0] == 1) {
		total16 = 0;
	}
	if (WestInfoSuit2[0][1] == 1) {
		total17 = 0;
	}
	if (WestInfoSuit2[0][2] == 1) {
		total18 = 0;
	}
	if (WestInfoSuit2[0][3] == 1) {
		total19 = 0;
	}
	if (WestInfoSuit2[0][4] == 1) {
		total20 = 0;
	}
	
	for (int i = 0; i < 38; i++) {
		if (total1 != -1) {
			total1 += tables.get(location)[0][i];
		}
		if (total2 != -1) {
			total2 += tables.get(location)[1][i];
		}
		if (total3 != -1) {
			total3 += tables.get(location)[2][i];
		}
		if (total4 != -1) {
			total4 += tables.get(location)[3][i];
		}
		
		if (total5 != -1) {
			total5 += tables.get(location)[4][i];
		}
		
		if (total6 != -1) {
			total6 += tables.get(location+1)[0][i];
		}
		if (total7 != -1) {
			total7 += tables.get(location+1)[1][i];
		}
		if (total8 != -1) {
			total8 += tables.get(location+1)[2][i];
		}
		if (total9 != -1) {
			total9 += tables.get(location+1)[3][i];	
		}
		if (total10 != -1) {
			total10 += tables.get(location+1)[4][i];
		}

		
		if (total11 != -1) {
			total11 += tables.get(location+2)[0][i];
		}
		if (total12 != -1) {
			total12 += tables.get(location+2)[1][i];
		}
		if (total13 != -1) {
			total13 += tables.get(location+2)[2][i];
		}
		if (total14 != -1) {
			total14 += tables.get(location+2)[3][i];
		}
		if (total15 != -1) {
			total15 += tables.get(location+2)[4][i];
		}
		
		if (total16 != -1) {
			total16 += tables.get(location+3)[0][i];
		}
		if (total17 != -1) {
			total17 += tables.get(location+3)[1][i];
		}
		if (total18 != -1) {
			total18 += tables.get(location+3)[2][i];
		}
		if (total19 != -1) {
			total19 += tables.get(location+3)[3][i];
		}
		if (total20 != -1) {
			total20 += tables.get(location+3)[4][i];
		}
	}

	for (int i = 0; i < 38; i++) {
		double t = 1;
		if (total1 != -1 && tables.get(location)[0][i] != 0) {
			t = t * (tables.get(location)[0][i]-1/total1-1);
		}
		if (total2 != -1 && tables.get(location)[1][i] != 0) {
			t = t * (tables.get(location)[1][i]-1/total2-1);
		}
		if (total3 != -1 && tables.get(location)[2][i] != 0) {
			t = t * (tables.get(location)[2][i]-1/total3-1);
		}
		if (total4 != -1 && tables.get(location)[3][i] != 0) {
			t = t * (tables.get(location)[3][i]-1/total4-1);
		}
		if (total5 != -1 && tables.get(location)[4][i] != 0) {
			t = t * (tables.get(location)[4][i]-1/total5-1);
		}
		
		if (total6 != -1 && tables.get(location+1)[0][i] != 0) {
			t = t * (tables.get(location+1)[0][i]-1/total6-1);
		}
		if (total7 != -1 && tables.get(location+1)[1][i] != 0) {
			t = t * (tables.get(location+1)[1][i]-1/total7-1);
		}
		if (total8 != -1 && tables.get(location+1)[2][i] != 0) {
			t = t * (tables.get(location+1)[2][i]-1/total8-1);
		}
		if (total9 != -1 && tables.get(location+1)[3][i] != 0) {
			t = t * (tables.get(location+1)[3][i]-1/total9-1);
		}
		if (total10 != -1 && tables.get(location+1)[4][i] != 0) {
			t = t * (tables.get(location+1)[4][i]-1/total10-1);
		}
		
		if (total11 != -1 && tables.get(location+2)[0][i] != 0) {
			t = t * (tables.get(location+2)[0][i]-1/total11-1);
		}
		if (total12 != -1 && tables.get(location+2)[1][i] != 0) {
			t = t * (tables.get(location+2)[1][i]-1/total12-1);
		}
		if (total13 != -1 && tables.get(location+2)[2][i] != 0) {
			t = t * (tables.get(location+2)[2][i]-1/total13-1);
		}
		if (total14 != -1 && tables.get(location+2)[3][i] != 0) {
			t = t * (tables.get(location+2)[3][i]-1/total14-1);
		}
		if (total15 != -1 && tables.get(location+2)[4][i] != 0) {
			t = t * (tables.get(location+2)[4][i]-1/total15-1);
		}
		
		if (total16 != -1 && tables.get(location+3)[0][i] != 0) {
			t = t * (tables.get(location+3)[0][i]-1/total16-1);
		}
		if (total17 != -1 && tables.get(location+3)[1][i] != 0) {
			t = t * (tables.get(location+3)[1][i]-1/total17-1);
		}
		if (total18 != -1 && tables.get(location+1)[2][i] != 0) {
			t = t * (tables.get(location+3)[2][i]-1/total18-1);
		}
		if (total19 != -1 && tables.get(location+3)[3][i] != 0) {
			t = t * (tables.get(location+3)[3][i]-1/total19-1);
		}
		if (total20 != -1 && tables.get(location+3)[4][i] != 0) {
			t = t * (tables.get(location+3)[4][i]-1/total20-1);
		}
		AllBidSuit[0][i]  = t;
	}	
}

//Calculate ALL bid NONE/PASS/OTHER
private static void getBidBid(int p) {
	int location = 0;
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(5);
	
	if (p == 0) {
		location = 0;
	}
	else if(p == 1){
		location = 4;
	}
	else if(p == 2){
		location = 8;
	}
	else if(p == 3){
		location = 12;
	}
	
	double total1 = -1;
	double total2 = -1;
	double total3 = -1;
	double total4 = -1;
	double total5 = -1;
	double total6 = -1;
	double total7 = -1;
	double total8 = -1;
	
		if (NorthInfoBid2[0][1] == 1) {
			total1 = 0;
		}
		if (NorthInfoBid2[0][2] == 1) {
			total2 = 0;
		}
		if (EastInfoBid2[0][1] == 1) {
			total3 = 0;
		}
		if (EastInfoBid2[0][2] == 1) {
			total4 = 0;
		}
		if (SouthInfoBid2[0][1] == 1) {
			total5 = 0;
		}
		if (SouthInfoBid2[0][2] == 1) {
			total6 = 0;
		}
		if (WestInfoBid2[0][1] == 1) {
			total7 = 0;
		}
		if (WestInfoBid2[0][2] == 1) {
			total8 = 0;
		}
		
		for (int i = 0; i < 38; i++) {
			if (total1 != -1) {
				total1 += tables.get(location)[1][i];
			}
			if (total2 != -1) {
				total2 += tables.get(location)[2][i];
			}

			if (total3 != -1) {
				total3 += tables.get(location+1)[1][i];
			}
			if (total4 != -1) {
				total4 += tables.get(location+1)[2][i];
			}

			if (total5 != -1) {
				total5 += tables.get(location+2)[1][i];
			}

			if (total6 != -1) {
				total6 += tables.get(location+2)[2][i];
			}
			if (total7 != -1) {
				total7 += tables.get(location+3)[1][i];
			}
			if (total8 != -1) {
				total8 += tables.get(location+3)[2][i];
			}
		}
		
		for (int i = 0; i < 38; i++) {
			double t = 1;
			if (total1 != -1 && tables.get(location)[1][i] != 0) {
				t = t * (tables.get(location)[1][i]-1/total1-1);
			}
			if (total2 != -1 && tables.get(location)[2][i] != 0) {
				t = t * (tables.get(location)[2][i]-1/total2-1);
			}

			if (total3 != -1 && tables.get(location+1)[1][i] != 0) {
				t = t * (tables.get(location+1)[1][i]-1/total3-1);
			}
			if (total4 != -1 && tables.get(location+1)[2][i] != 0) {
				t = t * (tables.get(location+1)[2][i]-1/total4-1);
			}

			if (total5 != -1 && tables.get(location+2)[1][i] != 0) {
				t = t * (tables.get(location+2)[1][i]-1/total5-1);
			}

			if (total6 != -1 && tables.get(location+2)[2][i] != 0) {
				t = t * (tables.get(location+2)[2][i]-1/total6-1);
			}
			if (total7 != -1 && tables.get(location+3)[1][i] != 0) {
				t = t * (tables.get(location+3)[1][i]-1/total7-1);
			}
			if (total8 != -1 && tables.get(location+3)[2][i] != 0) {
				t = t * (tables.get(location+3)[2][i]-1/total8-1);
			}
			AllBidBid[0][i] = t;
		}
		
}

//Calculate first bid NONE/PASS/OTHER
private static void FirstBidBid(int p) {
	int location = 0;
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(5);
	
	if (p == 0) {
		location = 0;
	}
	else if(p == 1){
		location = 4;
	}
	else if(p == 2){
		location = 8;
	}
	else if(p == 3){
		location = 12;
	}
	
	double total1 = 0;
	double total2 = 0;
	double total3 = 0;
	double total4 = 0;
	for (int i = 0; i < 38; i++) {
		total1 +=tables.get(location)[0][i];
		total2 +=tables.get(location+1)[0][i];
		total3 +=tables.get(location+2)[0][i];
		total4 +=tables.get(location+3)[0][i];
	}
	
	for (int i = 0; i < 38; i++) {
		double t = 1;
		if(tables.get(location)[0][i] != 0){
			t = tables.get(location)[0][i]-1/total1-1;
		}
		if(tables.get(location+1)[0][i] != 0){
			t = t * (tables.get(location+1)[0][i]-1/total2-1);
		}
		if(tables.get(location+2)[0][i] != 0){
			t = t * (tables.get(location+2)[0][i]-1/total3-1);
		}
		if(tables.get(location+3)[0][i] != 0){
			t = t * (tables.get(location+3)[0][i]-1/total4-1);
		}
		FirstBidBid[0][i] = t;
	}

	
}

//calculate all bids for highcards in hand
private static void getAllHighCardsInHand(int g, int p) {
	
	int highCards = GameInfo.countPlayerHandStrenght(g,p);
	int r = 0;
	if (highCards < 2) {
		r = 0;
	}
	else if(highCards < 4 && highCards > 1){
		r = 1;
	}
	else if(highCards < 7 && highCards > 3){
		r = 2;
	}
	else if(highCards > 6){
		r = 3;
	}

	double total = 0;

	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(4);
	
		for (int j = 0; j < 38 ; j++) {
			total += tables.get(0)[r][j];

		}
		
		for (int i = 0; i < 38; i++) {
			double t = 1;
			if(tables.get(0)[r][i] != 0){
				t =  (tables.get(0)[r][i]-1/total-1);
				//System.out.println(tables.get(0)[r][i]+" / "+total+" = "+tables.get(0)[r][i]/total);
			}
			//System.out.println(t);
			AllbidsHighCardHand[0][i] = t;
			//System.out.println(String.format("%.8f",t*100)+" "+i);
		}
				
	}

//calcualte ALL bids for amount of higcards in suit
private static void getFirstBidsHighCardSuit(int g, int p) {
	int spades = GameInfo.countPlayerSuitStrenght(g, p ,'S');
	int clubs = GameInfo.countPlayerSuitStrenght(g, p ,'C');
	int diamonds = GameInfo.countPlayerSuitStrenght(g, p ,'D');
	int hearts = GameInfo.countPlayerSuitStrenght(g, p ,'H');

	double totalC = 0;
	double totalD = 0;
	double totalH = 0;
	double totalS = 0;
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(3);
	
		for (int j = 0; j < 38 ; j++) {
			totalC += tables.get(3)[getRow2(clubs)][j];
			totalD += tables.get(2)[getRow2(diamonds)][j];
			totalH += tables.get(1)[getRow2(hearts)][j];
			totalS += tables.get(0)[getRow2(spades)][j];
		}
		
		for (int i = 0; i < 38; i++) {
			double t = 1;
			if(tables.get(3)[getRow2(clubs)][i] != 0){
				t = tables.get(3)[getRow2(clubs)][i]-1/totalC-1;
				//System.out.println(tables.get(3)[getRow2(clubs)][i]+" / "+totalC+" = "+tables.get(3)[getRow2(clubs)][i]/totalC);
				
			}
			if(tables.get(2)[getRow2(diamonds)][i] != 0){
				t = t * (tables.get(2)[getRow2(diamonds)][i]-1/totalD-1);
				//System.out.println(tables.get(2)[getRow2(diamonds)][i]+" / "+totalD+" = "+tables.get(2)[getRow2(diamonds)][i]/totalD);
			}
			if(tables.get(1)[getRow2(hearts)][i] != 0){
				t = t * (tables.get(1)[getRow2(hearts)][i]-1/totalH-1);
				//System.out.println(tables.get(1)[getRow2(hearts)][i]+" / "+totalH+" = "+tables.get(1)[getRow2(hearts)][i]/totalH);
			}
			if(tables.get(0)[getRow2(spades)][i] != 0){
				t = t * (tables.get(0)[getRow2(spades)][i]-1/totalS-1);	
				//System.out.println(tables.get(0)[getRow2(spades)][i]+" / "+totalS+" = "+tables.get(0)[getRow2(spades)][i]/totalS);
			}
			//System.out.println(t);
			FirstbidsHighCardSuit[0][i] = t;
			//System.out.println(String.format("%.8f",t*100)+" "+i);
		}
				
	}

//calcualte ALL bids for amount of higcards in suit
private static void getAllBidsHighCardSuit(int g, int p) {
	
	int spades = GameInfo.countPlayerSuitStrenght(g, p ,'S');
	int clubs = GameInfo.countPlayerSuitStrenght(g, p ,'C');
	int diamonds = GameInfo.countPlayerSuitStrenght(g, p ,'D');
	int hearts = GameInfo.countPlayerSuitStrenght(g, p ,'H');

	double totalC = 0;
	double totalD = 0;
	double totalH = 0;
	double totalS = 0;
	ArrayList<int[][]>tables;
	tables = BuildTables.getTables().get(2);
	
		for (int j = 0; j < 38 ; j++) {
			totalC += tables.get(3)[getRow2(clubs)][j];
			totalD += tables.get(2)[getRow2(diamonds)][j];
			totalH += tables.get(1)[getRow2(hearts)][j];
			totalS += tables.get(0)[getRow2(spades)][j];
		}
		
		for (int i = 0; i < 38; i++) {
			double t = 1;
			if(tables.get(3)[getRow2(clubs)][i] != 0){
				t = tables.get(3)[getRow2(clubs)][i]-1/totalC-1;
				//System.out.println(tables.get(3)[getRow2(clubs)][i]+" / "+totalC+" = "+tables.get(3)[getRow2(clubs)][i]/totalC);
				
			}
			if(tables.get(2)[getRow2(diamonds)][i] != 0){
				t = t * (tables.get(2)[getRow2(diamonds)][i]-1/totalD-1);
				//System.out.println(tables.get(2)[getRow2(diamonds)][i]+" / "+totalD+" = "+tables.get(2)[getRow2(diamonds)][i]/totalD);
			}
			if(tables.get(1)[getRow2(hearts)][i] != 0){
				t = t * (tables.get(1)[getRow2(hearts)][i]-1/totalH-1);
				//System.out.println(tables.get(1)[getRow2(hearts)][i]+" / "+totalH+" = "+tables.get(1)[getRow2(hearts)][i]/totalH);
			}
			if(tables.get(0)[getRow2(spades)][i] != 0){
				t = t * (tables.get(0)[getRow2(spades)][i]-1/totalS-1);	
				//System.out.println(tables.get(0)[getRow2(spades)][i]+" / "+totalS+" = "+tables.get(0)[getRow2(spades)][i]/totalS);
			}
			//System.out.println(t);
			AllbidsHighCardSuit[0][i] = t;
			//System.out.println(String.format("%.8f",t*100)+" "+i);
		}
		
	}

	//Calculate FIRST bids for amount of cards in suit
private static void getFirstBidsAmountSuit(int g, int p) {
		
		int spades = GameInfo.getSuitValue(p, 'S', g);
		int clubs = GameInfo.getSuitValue(p, 'C', g);
		int diamonds = GameInfo.getSuitValue(0, 'D', 0);
		int hearts = GameInfo.getSuitValue(p, 'H', g);
//		System.out.print(spades+" ");
//		System.out.print(hearts+" ");
//		System.out.print(diamonds+" ");
//		System.out.println(clubs);
		double totalC = 0;
		double totalD = 0;
		double totalH = 0;
		double totalS = 0;
		ArrayList<int[][]>tables;
		tables = BuildTables.getTables().get(1);
		
			for (int j = 0; j < 38 ; j++) {
				totalC += tables.get(3)[getRow(clubs)][j];
				totalD += tables.get(2)[getRow(diamonds)][j];
				totalH += tables.get(1)[getRow(hearts)][j];
				totalS += tables.get(0)[getRow(spades)][j];
			}
			
			for (int i = 0; i < 38; i++) {
				double t = 1;
				if(tables.get(3)[getRow(clubs)][i] != 0){
					t = tables.get(3)[getRow(clubs)][i]-1/totalC-1;
					//System.out.println(tables.get(3)[getRow(clubs)][i]+" / "+totalC+" = "+tables.get(3)[getRow(clubs)][i]/totalC);
					
				}
				if(tables.get(2)[getRow(diamonds)][i] != 0){
					t = t * (tables.get(2)[getRow(diamonds)][i]-1/totalD-1);
					//System.out.println(tables.get(2)[getRow(diamonds)][i]+" / "+totalD+" = "+tables.get(2)[getRow(diamonds)][i]/totalD);
				}
				if(tables.get(1)[getRow(hearts)][i] != 0){
					t = t * (tables.get(1)[getRow(hearts)][i]-1/totalH-1);
					//System.out.println(tables.get(1)[getRow(hearts)][i]+" / "+totalH+" = "+tables.get(1)[getRow(hearts)][i]/totalH);
				}
				if(tables.get(0)[getRow(spades)][i] != 0){
					t = t * (tables.get(0)[getRow(spades)][i]-1/totalS-1);	
					//System.out.println(tables.get(0)[getRow(spades)][i]+" / "+totalS+" = "+tables.get(0)[getRow(spades)][i]/totalS);
				}
				//System.out.println(t);
				FirstbidsCardsInSuit[0][i] = t;
				//System.out.println(String.format("%.8f",t*100)+" "+i);
			}		
	}

//calcualte ALL bids for amount of cards in suit;
private static void getAllBidsAmountSuit(int g, int p) {
		int spades = GameInfo.getSuitValue(p, 'S', g);
		int clubs = GameInfo.getSuitValue(p, 'C', g);
		int diamonds = GameInfo.getSuitValue(0, 'D', 0);
		int hearts = GameInfo.getSuitValue(p, 'H', g);
//		System.out.print(spades+" ");
//		System.out.print(hearts+" ");
//		System.out.print(diamonds+" ");
//		System.out.println(clubs);
		double totalC = 0;
		double totalD = 0;
		double totalH = 0;
		double totalS = 0;
		ArrayList<int[][]>tables;
		tables = BuildTables.getTables().get(0);
		
			for (int j = 0; j < 38 ; j++) {
				totalC += tables.get(3)[getRow(clubs)][j];
				totalD += tables.get(2)[getRow(diamonds)][j];
				totalH += tables.get(1)[getRow(hearts)][j];
				totalS += tables.get(0)[getRow(spades)][j];
			}
			
			for (int i = 0; i < 38; i++) {
				double t = 1;
				if(tables.get(3)[getRow(clubs)][i] != 0){
					t = tables.get(3)[getRow(clubs)][i]-1/totalC-1;
					//System.out.println(tables.get(3)[getRow(clubs)][i]+" / "+totalC+" = "+tables.get(3)[getRow(clubs)][i]/totalC);
					
				}
				if(tables.get(2)[getRow(diamonds)][i] != 0){
					t = t * (tables.get(2)[getRow(diamonds)][i]-1/totalD-1);
					//System.out.println(tables.get(2)[getRow(diamonds)][i]+" / "+totalD+" = "+tables.get(2)[getRow(diamonds)][i]/totalD);
				}
				if(tables.get(1)[getRow(hearts)][i] != 0){
					t = t * (tables.get(1)[getRow(hearts)][i]-1/totalH-1);
					//System.out.println(tables.get(1)[getRow(hearts)][i]+" / "+totalH+" = "+tables.get(1)[getRow(hearts)][i]/totalH);
				}
				if(tables.get(0)[getRow(spades)][i] != 0){
					t = t * (tables.get(0)[getRow(spades)][i]-1/totalS-1);	
					//System.out.println(tables.get(0)[getRow(spades)][i]+" / "+totalS+" = "+tables.get(0)[getRow(spades)][i]/totalS);
				}
				//System.out.println(t);
				AllbidsCardsInSuit[0][i] = t;
				//System.out.println(String.format("%.8f",t*100)+" "+i);
			}
	}
	
//get row
	private static int getRow(int x) {
		int row = 0;
		if(x > -1 && x < 2){
			row = 0;
		}
		else if(x > 1 && x < 4){
			row = 1;
		}
		else if(x > 3 && x < 7){
			row = 2;
		}
		else if(x > 6){
			row = 3;
		}
		
		return row;
	}

	private static int getRow2(int x) {
		int row = 0;
		if(x== 0){
			row = 0;
		}
		else if(x == 1){
			row = 1;
		}
		else if(x > 1 && x < 4){
			row = 2;
		}
		else if(x > 3){
			row = 3;
		}
		
		return row;
	}
}
