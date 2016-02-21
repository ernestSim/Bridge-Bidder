
import java.util.ArrayList;
import java.util.Arrays;

public class BuildTables {
	
	private static ArrayList<ArrayList<int[][]>> tables = new ArrayList<ArrayList<int[][]>>();
	
	private static ArrayList<int[][]> AllBids = new ArrayList<int[][]>();
	private static ArrayList<int[][]> Firstbids = new ArrayList<int[][]>();
	private static ArrayList<int[][]> AllHighSuitBids = new ArrayList<int[][]>();
	private static ArrayList<int[][]> FirstHighSuitBids = new ArrayList<int[][]>();
	private static ArrayList<int[][]> HighHandBids = new ArrayList<int[][]>();
	
	//**
	//private static ArrayList<int[][]> BiddingHistory= new ArrayList<int[][]>();
	//**
	//here//
	
	private static ArrayList<int[][]> AllroundBids = new ArrayList<int[][]>();
	private static ArrayList<int[][]> AllroundSuit = new ArrayList<int[][]>();
	private static ArrayList<int[][]> AllroundPass = new ArrayList<int[][]>();
	private static ArrayList<int[][]> AllPosibleBids = new ArrayList<int[][]>();
	
	//end//
	
	private static int[][] AllBidsSpades = new int[4][38];
	private static int[][] AllBidsHearts = new int[4][38];
	private static int[][] AllBidsDiamonds = new int[4][38];
	private static int[][] AllBidsClubs = new int[4][38];
	
	private static int[][] FirstBidSpades = new int[4][38];
	private static int[][] FirstBidHearts = new int[4][38];
	private static int[][] FirstBidDiamonds = new int[4][38];
	private static int[][] FirstBidClubs = new int[4][38];
	
	private static int[][] AllHighSuitBidsSpades = new int[4][38];
	private static int[][] AllHighSuitBidsHearts = new int[4][38];
	private static int[][] AllHighSuitBidsDiamonds = new int[4][38];
	private static int[][] AllHighSuitBidsClubds = new int[4][38];
	
	private static int[][] FirstHighSuitBidsSpades = new int[4][38];
	private static int[][] FirstHighSuitBidsClubds = new int[4][38];
	private static int[][] FirstHighSuitBidsDiamonds = new int[4][38];
	private static int[][] FirstHighSuitBidsHearts = new int[4][38];
	
	private static int[][] AllHighHandBids = new int[4][38];
	
	//last(history)
	
	//********************
	// NONE / PASS / OTHER
	//********************
	
	private static int[][] NorthInfoBid = new int[1][3];
	private static int[][] EastInfoBid = new int[1][3];
	private static int[][] SouthInfoBid = new int[1][3];
	private static int[][] WestInfoBid = new int[1][3];
	
	//*************
	private static int[][] NorthNorthBid = new int[3][38];
	private static int[][] NorthEastBid = new int[3][38];
	private static int[][] NorthSouthBid = new int[3][38];
	private static int[][] NorthWestBid = new int[3][38];
	
	private static int[][] EastEastBid = new int[3][38];
	private static int[][] EastSouthBid = new int[3][38];
	private static int[][] EastWestBid = new int[3][38];
	private static int[][] EastNorthBid = new int[3][38];
	
	private static int[][] SouthSouthBid = new int[3][38];
	private static int[][] SouthWestBid = new int[3][38];
	private static int[][] SouthNorthBid = new int[3][38];
	private static int[][] SouthEastBid = new int[3][38];

	private static int[][] WestWestBid = new int[3][38];
	private static int[][] WestNorthBid = new int[3][38];
	private static int[][] WestEastBid = new int[3][38];
	private static int[][] WestSouthBid = new int[3][38];
	
	//*****************************************
	// CLUB / DIAMONDS / HEARTS / SPADES / NT
	//*****************************************
	
	private static int[][] NorthInfoSuit = new int[1][5];
	private static int[][] EastInfoSuit = new int[1][5];
	private static int[][] SouthInfoSuit = new int[1][5];
	private static int[][] WestInfoSuit = new int[1][5];
	
	//*****************
	
	private static int[][] NorthNorthSuitYes = new int[5][38];
	private static int[][] NorthEastSuitYes = new int[5][38];
	private static int[][] NorthSouthSuitYes = new int[5][38];
	private static int[][] NorthWestSuitYes = new int[5][38];
	
	private static int[][] EastEastSuitYes = new int[5][38];
	private static int[][] EastSouthSuitYes = new int[5][38];
	private static int[][] EastWestSuitYes = new int[5][38];
	private static int[][] EastNorthSuitYes = new int[5][38];
	
	private static int[][] SouthSouthSuitYes = new int[5][38];
	private static int[][] SouthWestSuitYes = new int[5][38];
	private static int[][] SouthNorthSuitYes = new int[5][38];
	private static int[][] SouthEastSuitYes = new int[5][38];

	private static int[][] WestWestSuitYes = new int[5][38];
	private static int[][] WestNorthSuitYes = new int[5][38];
	private static int[][] WestEastSuitYes = new int[5][38];
	private static int[][] WestSouthSuitYes = new int[5][38];
	
	//*****************
	
	private static int[][] NorthNorthSuitNo = new int[5][38];
	private static int[][] NorthEastSuitNo = new int[5][38];
	private static int[][] NorthSouthSuitNo = new int[5][38];
	private static int[][] NorthWestSuitNo = new int[5][38];
	
	private static int[][] EastEastSuitNo = new int[5][38];
	private static int[][] EastSouthSuitNo = new int[5][38];
	private static int[][] EastWestSuitNo = new int[5][38];
	private static int[][] EastNorthSuitNo = new int[5][38];
	
	private static int[][] SouthSouthSuitNo = new int[5][38];
	private static int[][] SouthWestSuitNo = new int[5][38];
	private static int[][] SouthNorthSuitNo = new int[5][38];
	private static int[][] SouthEastSuitNo = new int[5][38];

	private static int[][] WestWestSuitNo = new int[5][38];
	private static int[][] WestNorthSuitNo = new int[5][38];
	private static int[][] WestEastSuitNo = new int[5][38];
	private static int[][] WestSouthSuitNo = new int[5][38];
	
	//***********************
	// 	LOWEST POSSIBLE BID
	//***********************
	
	private static int[][] PossibleBidSuit = new int[5][38];
	private static int[][] PossibleBidValue = new int[7][38];
	
	//************************
	//PASS / DOUBLE /REDOUBLE
	//************************
	
	private static int[][] NorthInfoPass = new int[1][3];
	private static int[][] EastInfoPass = new int[1][3];
	private static int[][] SouthInfoPass = new int[1][3];
	private static int[][] WestInfoPass = new int[1][3];
	
	//************************
	
	private static int[][] NorthNorthPass = new int[3][38];
	private static int[][] NorthEastPass = new int[3][38];
	private static int[][] NorthSouthPass = new int[3][38];
	private static int[][] NorthWestPass = new int[3][38];
	
	private static int[][] EastEastPass = new int[3][38];
	private static int[][] EastSouthPass = new int[3][38];
	private static int[][] EastWestPass = new int[3][38];
	private static int[][] EastNorthPass = new int[3][38];
	
	private static int[][] SouthSouthPass = new int[3][38];
	private static int[][] SouthWestPass = new int[3][38];
	private static int[][] SouthNorthPass = new int[3][38];
	private static int[][] SouthEastPass = new int[3][38];

	private static int[][] WestWestPass = new int[3][38];
	private static int[][] WestNorthPass = new int[3][38];
	private static int[][] WestEastPass = new int[3][38];
	private static int[][] WestSouthPass = new int[3][38];
	
	//************************
	

	public static void bidsTable() {
		
		int dealer = 0;
		String bid = "";
		int counter=0;
		ArrayList<Character> bids = new ArrayList<Character>();
		
		PopulateTables();
		
		for (int j = 0; j < GameInfo.games.size(); j++) {

			dealer = GameInfo.getDealer(j);
			bids = GameInfo.getGameBids(j);

			for (int i = 0; i < bids.size(); i++) {
				int rowS,rowH,rowD,rowC, column;
				if (Character.getNumericValue(bids.get(i)) > 0
						&& Character.getNumericValue(bids.get(i)) < 8) {
					bid = bids.get(i) + "" + bids.get(i + 1);
					i++;
					column = CalculateColumn(bid);
					rowS = CalculateRow(GameInfo.getSuitValue(dealer, 'S', j),0);
					rowH = CalculateRow(GameInfo.getSuitValue(dealer, 'H', j),0);
					rowD = CalculateRow(GameInfo.getSuitValue(dealer, 'D', j),0);	
					rowC = CalculateRow(GameInfo.getSuitValue(dealer, 'C', j),0);
					addToTableAllBids(rowS,rowH,rowD,rowC, column);
					if (counter == 0) {
						addToTableFirstBids(rowS, rowH, rowD, rowC, column);
					}
					rowS = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'S'),1);
					rowH = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'H'),1);
					rowD = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'D'),1);	
					rowC = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'C'),1);
					addToTableAllSuitBids(rowS,rowH,rowD,rowC, column);
					if (counter == 0) {
						addToTableFirstSuitBids(rowS, rowH, rowD, rowC, column);
						counter++;
					}
					rowS = CalculateRow(GameInfo.countPlayerHandStrenght(j, dealer), 0);
					addToTableAllhighHandBids(rowS, column);
					
					dealer++;
					if (dealer == 4) {
						dealer = 0;
					}
					bid = "";
				} else {
					bid = "" + bids.get(i);
					column = CalculateColumn(bid);
					rowS = CalculateRow(GameInfo.getSuitValue(dealer, 'S', j),0);
					rowH = CalculateRow(GameInfo.getSuitValue(dealer, 'H', j),0);
					rowD = CalculateRow(GameInfo.getSuitValue(dealer, 'D', j),0);	
					rowC = CalculateRow(GameInfo.getSuitValue(dealer, 'C', j),0);
					addToTableAllBids(rowS,rowH,rowD,rowC, column);
					if (counter == 0) {
						addToTableFirstBids(rowS, rowH, rowD, rowC, column);
					}
					rowS = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'S'),1);
					rowH = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'H'),1);
					rowD = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'D'),1);	
					rowC = CalculateRow(GameInfo.countPlayerSuitStrenght(j, dealer, 'C'),1);
					addToTableAllSuitBids(rowS,rowH,rowD,rowC, column);
					if (counter == 0) {
						addToTableFirstSuitBids(rowS, rowH, rowD, rowC, column);
						counter++;
					}
					rowS = CalculateRow(GameInfo.countPlayerHandStrenght(j, dealer), 0);
					addToTableAllhighHandBids(rowS, column);
					
					dealer++;
					if (dealer == 4) {
						dealer = 0;
					}
					bid = "";
				}				
			}
			counter=0;
		}
		
		
		//from here:
		String cbid;
		String pbid;
		for (int k = 0; k < GameInfo.games.size(); k++) {
			ArrayList<Character> gameBids = new ArrayList<Character>();
			gameBids = GameInfo.getGameBids(k);
			resetPlayerInfo();
			int gameDealer = GameInfo.getDealer(k);
			int tempDealer = GameInfo.getDealer(k);
			cbid = "X";
			pbid = "X";
			for (int l = 0; l < gameBids.size(); l++) {
				int col = 0;
				int testBid = 0;
				
				if (Character.isDigit(gameBids.get(l))) {
					 col = findCol(gameBids.get(l), gameBids.get(l+1));
					findCol(gameBids.get(l),gameBids.get(l+1));
					testBid = 1;
					pbid = cbid;
					cbid = gameBids.get(l)+""+gameBids.get(l+1);
				}
				else{
					if (gameBids.get(l) != 'P') {
						cbid = gameBids.get(l)+"";		
					}
					pbid = cbid;
						
					col = findCol(gameBids.get(l),'X');
				}
				
				LowestPossibleBid(col, pbid);
//here
				if(tempDealer == 0){
//Bid					
					if (NorthInfoBid[0][0] == 1) {
						NorthNorthBid[0][col] =  NorthNorthBid[0][col] + 1;
					}
					if(NorthInfoBid[0][1] == 1){
						NorthNorthBid[1][col] =  NorthNorthBid[1][col] + 1;
					}
					if(NorthInfoBid[0][2] == 1){
						NorthNorthBid[2][col] =  NorthNorthBid[2][col] + 1;
					}
					
					if (EastInfoBid[0][0] == 1) {
						NorthEastBid[0][col] = NorthEastBid[0][col] + 1;
					}
					if(EastInfoBid[0][1] == 1){
						NorthEastBid[1][col] = NorthEastBid[1][col] + 1;
					}
					if(EastInfoBid[0][2] == 1){
						NorthEastBid[2][col] = NorthEastBid[2][col] + 1;
					}
					
					if (SouthInfoBid[0][0] == 1) {
						NorthSouthBid[0][col] = NorthSouthBid[0][col] + 1;
					}
					if(SouthInfoBid[0][1] == 1){
						NorthSouthBid[1][col] = NorthSouthBid[1][col] + 1;
					}
					if(SouthInfoBid[0][2] == 1){
						NorthSouthBid[2][col] = NorthSouthBid[2][col] + 1;
					}
					
					if (WestInfoBid[0][0] == 1) {
						NorthWestBid[0][col] = NorthWestBid[0][col] + 1;
					}
					if(WestInfoBid[0][1] == 1){
						NorthWestBid[1][col] = NorthWestBid[1][col] + 1;
					}
					if(WestInfoBid[0][2] == 1){
						NorthWestBid[2][col] = NorthWestBid[2][col] + 1;
					}
//Pass					
					for (int i = 0; i < 3; i++) {
						if (NorthInfoPass[0][i] == 1) {
							NorthNorthPass[i][col] = NorthNorthPass[i][col] + 1;
						}
						if (EastInfoPass[0][i] == 1) {
							NorthEastPass[i][col] = NorthEastPass[i][col] + 1;
						}
						if(SouthInfoPass[0][i] == 1){
							NorthSouthPass[i][col] = NorthSouthPass[i][col] + 1;
						}
						if(WestInfoPass[0][i] == 1){
							NorthWestPass[i][col] = NorthWestPass[i][col] + 1;
						}
					}
					
//Suit
					for (int i = 0; i < 5; i++) {
						if (NorthInfoSuit[0][i] == 1 ) {
							NorthNorthSuitYes[i][col] = NorthNorthSuitYes[i][col] + 1;
						}
						else if(NorthInfoSuit[0][i] == 0){
							NorthNorthSuitNo[i][col] = NorthNorthSuitNo[i][col] + 1;
						}
						
						if (EastInfoSuit[0][i] == 1 ) {
							NorthEastSuitYes[i][col] = NorthEastSuitYes[i][col] + 1;
						}
						else if(EastInfoSuit[0][i] == 0){
							NorthEastSuitNo[i][col] = NorthEastSuitNo[i][col] + 1;
						}
						
						if (SouthInfoSuit[0][i] == 1 ) {
							NorthSouthSuitYes[i][col] = NorthSouthSuitYes[i][col] + 1;
						}
						else if(SouthInfoSuit[0][i] == 0){
							NorthSouthSuitNo[i][col] = NorthSouthSuitNo[i][col] + 1;
						}
						if (WestInfoSuit[0][i] == 1 ) {
							NorthWestSuitYes[i][col] = NorthWestSuitYes[i][col] + 1;
						}
						else if(WestInfoSuit[0][i] == 0){
							NorthWestSuitNo[i][col] = NorthWestSuitNo[i][col] + 1;
						}
					}
					
					
					if (testBid  == 1) {
						if (gameBids.get(l+1) == 'C') {
							NorthInfoSuit[0][0] = 1;
						}
						else if(gameBids.get(l+1) == 'D'){
							NorthInfoSuit[0][1] = 1;
						}
						else if(gameBids.get(l+1) == 'H'){
							NorthInfoSuit[0][2] = 1;
						}
						else if(gameBids.get(l+1) == 'S'){
							NorthInfoSuit[0][3] = 1;
						}
						else if(gameBids.get(l+1) == 'T'){
							NorthInfoSuit[0][4] = 1;
						}
					}
					else{
						if(gameBids.get(l) == 'B'){
							NorthInfoPass[0][0] = 1;
							NorthInfoPass[0][2] = 0;
						}
						else if(gameBids.get(l) == 'R'){
							NorthInfoPass[0][1] = 1;
							NorthInfoPass[0][2] = 0;
						}
					}

					NorthInfoBid[0][0] = 0;
					if (gameBids.get(l) == 'P') {
						NorthInfoBid[0][1] = 1 ;
					}
					else{
						NorthInfoBid[0][2] = 1;
					}
//here						
			}
				else if(tempDealer == 1){
//BID				
					if (EastInfoBid[0][0] == 1) {
						EastEastBid[0][col] = EastEastBid[0][col] + 1;
					}
					if(EastInfoBid[0][1] == 1){
						EastEastBid[1][col] = EastEastBid[1][col] + 1;
					}
					if(EastInfoBid[0][2] == 1){
						EastEastBid[2][col] = EastEastBid[2][col] + 1;
					}
					
					if (SouthInfoBid[0][0] == 1) {
						EastSouthBid[0][col] = EastSouthBid[0][col] + 1;
					}
					if(SouthInfoBid[0][1] == 1){
						EastSouthBid[1][col] = EastSouthBid[1][col] + 1;
					}
					if(SouthInfoBid[0][2] == 1){
						EastSouthBid[2][col] = EastSouthBid[2][col] + 1;
					}
					
					if (WestInfoBid[0][0] == 1) {
						EastWestBid[0][col] = EastWestBid[0][col] + 1;
					}
					if(WestInfoBid[0][1] == 1){
						EastWestBid[1][col] = EastWestBid[1][col] + 1;
					}
					if(WestInfoBid[0][2] == 1){
						EastWestBid[2][col] = EastWestBid[2][col] + 1;
					}
					
					if (NorthInfoBid[0][0] == 1) {
						EastNorthBid[0][col] =  EastNorthBid[0][col] + 1;
					}
					if(NorthInfoBid[0][1] == 1){
						EastNorthBid[1][col] =  EastNorthBid[1][col] + 1;
					}
					if(NorthInfoBid[0][2] == 1){
						EastNorthBid[2][col] =  EastNorthBid[2][col] + 1;
					}
//PASS
					for (int i = 0; i < 3; i++) {
						if (EastInfoPass[0][i] == 1) {
							EastEastPass[i][col] = EastEastPass[i][col] + 1;
						}
						if(SouthInfoPass[0][i] == 1){
							EastSouthPass[i][col] = EastSouthPass[i][col] + 1;
						}
						if(WestInfoPass[0][i] == 1){
							EastWestPass[i][col] = EastWestPass[i][col] + 1;
						}
						if (NorthInfoPass[0][i] == 1) {
							EastNorthPass[i][col] = EastNorthPass[i][col] + 1;
						}
					}
//Suit
					for (int i = 0; i < 5; i++) {
						
						if (EastInfoSuit[0][i] == 1 ) {
							EastEastSuitYes[i][col] = EastEastSuitYes[i][col] + 1;
						}
						else if(EastInfoSuit[0][i] == 0){
							EastEastSuitNo[i][col] = EastEastSuitNo[i][col] + 1;
						}
						
						if (SouthInfoSuit[0][i] == 1 ) {
							EastSouthSuitYes[i][col] = EastSouthSuitYes[i][col] + 1;
						}
						else if(SouthInfoSuit[0][i] == 0){
							EastSouthSuitNo[i][col] = EastSouthSuitNo[i][col] + 1;
						}
						if (WestInfoSuit[0][i] == 1 ) {
							EastWestSuitYes[i][col] = EastWestSuitYes[i][col] + 1;
						}
						else if(WestInfoSuit[0][i] == 0){
							EastWestSuitNo[i][col] = EastWestSuitNo[i][col] + 1;
						}
						if (NorthInfoSuit[0][i] == 1 ) {
							EastNorthSuitYes[i][col] = EastNorthSuitYes[i][col] + 1;
						}
						else if(NorthInfoSuit[0][i] == 0){
							EastNorthSuitNo[i][col] = EastNorthSuitNo[i][col] + 1;
						}
					}

					if (testBid  == 1) {
						if (gameBids.get(l+1) == 'C') {
							EastInfoSuit[0][0] = 1;
						}
						else if(gameBids.get(l+1) == 'D'){
							EastInfoSuit[0][1] = 1;
						}
						else if(gameBids.get(l+1) == 'H'){
							EastInfoSuit[0][2] = 1;
						}
						else if(gameBids.get(l+1) == 'S'){
							EastInfoSuit[0][3] = 1;
						}
						else if(gameBids.get(l+1) == 'T'){
							EastInfoSuit[0][4] = 1;
						}
					}
					else{
						if(gameBids.get(l) == 'B'){
							EastInfoPass[0][0] = 1;
							EastInfoPass[0][2] = 0;
						}
						else if(gameBids.get(l) == 'R'){
							EastInfoPass[0][1] = 1;
							EastInfoPass[0][2] = 0;
						}
					}
					
					EastInfoBid[0][0] = 0;
					if (gameBids.get(l) == 'P') {
						EastInfoBid[0][1] = 1 ;
					}
					else{
						EastInfoBid[0][2] = 1;
					}
//HERE					
				}
				else if(tempDealer == 2){
//BID
					if (SouthInfoBid[0][0] == 1) {
						SouthSouthBid[0][col] = SouthSouthBid[0][col] + 1;
					}
					if(SouthInfoBid[0][1] == 1){
						SouthSouthBid[1][col] = SouthSouthBid[1][col] + 1;
					}
					if(SouthInfoBid[0][2] == 1){
						SouthSouthBid[2][col] = SouthSouthBid[2][col] + 1;
					}
					
					if (WestInfoBid[0][0] == 1) {
						SouthWestBid[0][col] = SouthWestBid[0][col] + 1;
					}
					if(WestInfoBid[0][1] == 1){
						SouthWestBid[1][col] = SouthWestBid[1][col] + 1;
					}
					if(WestInfoBid[0][2] == 1){
						SouthWestBid[2][col] = SouthWestBid[2][col] + 1;
					}
					
					if (NorthInfoBid[0][0] == 1) {
						SouthNorthBid[0][col] =  SouthNorthBid[0][col] + 1;
					}
					if(NorthInfoBid[0][1] == 1){
						SouthNorthBid[1][col] =  SouthNorthBid[1][col] + 1;
					}
					if(NorthInfoBid[0][2] == 1){
						SouthNorthBid[2][col] =  SouthNorthBid[2][col] + 1;
					}
					
					if (EastInfoBid[0][0] == 1) {
						SouthEastBid[0][col] = SouthEastBid[0][col] + 1;
					}
					if(EastInfoBid[0][1] == 1){
						SouthEastBid[1][col] = SouthEastBid[1][col] + 1;
					}
					if(EastInfoBid[0][2] == 1){
						SouthEastBid[2][col] = SouthEastBid[2][col] + 1;
					}
//PASS					
					for (int i = 0; i < 3; i++) {
						if(SouthInfoPass[0][i] == 1){
							SouthSouthPass[i][col] = SouthSouthPass[i][col] + 1;
						}
						if(WestInfoPass[0][i] == 1){
							SouthWestPass[i][col] = SouthWestPass[i][col] + 1;
						}
						if (NorthInfoPass[0][i] == 1) {
							SouthNorthPass[i][col] = SouthNorthPass[i][col] + 1;
						}
						if (EastInfoPass[0][i] == 1) {
							SouthEastPass[i][col] = SouthEastPass[i][col] + 1;
						}
					}
//Suit
					for (int i = 0; i < 5; i++) {						
						if (SouthInfoSuit[0][i] == 1 ) {
							SouthSouthSuitYes[i][col] = SouthSouthSuitYes[i][col] + 1;
						}
						else if(SouthInfoSuit[0][i] == 0){
							SouthSouthSuitNo[i][col] = SouthSouthSuitNo[i][col] + 1;
						}
						if (WestInfoSuit[0][i] == 1 ) {
							SouthWestSuitYes[i][col] = SouthWestSuitYes[i][col] + 1;
						}
						else if(WestInfoSuit[0][i] == 0){
							SouthWestSuitNo[i][col] = SouthWestSuitNo[i][col] + 1;
						}
						if (NorthInfoSuit[0][i] == 1 ) {
							SouthNorthSuitYes[i][col] = SouthNorthSuitYes[i][col] + 1;
						}
						else if(NorthInfoSuit[0][i] == 0){
							SouthNorthSuitNo[i][col] = SouthNorthSuitNo[i][col] + 1;
						}
						if (EastInfoSuit[0][i] == 1 ) {
							SouthEastSuitYes[i][col] = SouthEastSuitYes[i][col] + 1;
						}
						else if(EastInfoSuit[0][i] == 0){
							SouthEastSuitNo[i][col] = SouthEastSuitNo[i][col] + 1;
						}
					}
					
					if (testBid  == 1) {
						if (gameBids.get(l+1) == 'C') {
							SouthInfoSuit[0][0] = 1;
						}
						else if(gameBids.get(l+1) == 'D'){
							SouthInfoSuit[0][1] = 1;
						}
						else if(gameBids.get(l+1) == 'H'){
							SouthInfoSuit[0][2] = 1;
						}
						else if(gameBids.get(l+1) == 'S'){
							SouthInfoSuit[0][3] = 1;
						}
						else if(gameBids.get(l+1) == 'T'){
							SouthInfoSuit[0][4] = 1;
						}
					}
					else{
						if(gameBids.get(l) == 'B'){
							SouthInfoPass[0][0] = 1;
							SouthInfoPass[0][2] = 0;
						}
						else if(gameBids.get(l) == 'R'){
							SouthInfoPass[0][1] = 1;
							SouthInfoPass[0][2] = 0;
						}
					}

					SouthInfoBid[0][0] = 0;
					if (gameBids.get(l) == 'P') {
						SouthInfoBid[0][1] = 1 ;
					}
					else{
						SouthInfoBid[0][2] = 1;
					}
//HERE
				}
				else if(tempDealer == 3){
//BID					
					if (WestInfoBid[0][0] == 1) {
						WestWestBid[0][col] = WestWestBid[0][col] + 1;
					}
					if(WestInfoBid[0][1] == 1){
						WestWestBid[1][col] = WestWestBid[1][col] + 1;
					}
					if(WestInfoBid[0][2] == 1){
						WestWestBid[2][col] = WestWestBid[2][col] + 1;
					}
					
					if (NorthInfoBid[0][0] == 1) {
						WestNorthBid[0][col] =  WestNorthBid[0][col] + 1;
					}
					if(NorthInfoBid[0][1] == 1){
						WestNorthBid[1][col] =  WestNorthBid[1][col] + 1;
					}
					if(NorthInfoBid[0][2] == 1){
						WestNorthBid[2][col] =  WestNorthBid[2][col] + 1;
					}
					
					if (EastInfoBid[0][0] == 1) {
						WestEastBid[0][col] = WestEastBid[0][col] + 1;
					}
					if(EastInfoBid[0][1] == 1){
						WestEastBid[1][col] = WestEastBid[1][col] + 1;
					}
					if(EastInfoBid[0][2] == 1){
						WestEastBid[2][col] = WestEastBid[2][col] + 1;
					}
					
					if (SouthInfoBid[0][0] == 1) {
						WestSouthBid[0][col] = WestSouthBid[0][col] + 1;
					}
					if(SouthInfoBid[0][1] == 1){
						WestSouthBid[1][col] = WestSouthBid[1][col] + 1;
					}
					if(SouthInfoBid[0][2] == 1){
						WestSouthBid[2][col] = WestSouthBid[2][col] + 1;
					}
//PASS					
					for (int i = 0; i < 3; i++) {
						if(WestInfoPass[0][i] == 1){
							WestWestPass[i][col] = WestWestPass[i][col] + 1;
						}
						if (NorthInfoPass[0][i] == 1) {
							WestNorthPass[i][col] = WestNorthPass[i][col] + 1;
						}
						if (EastInfoPass[0][i] == 1) {
							WestEastPass[i][col] = WestEastPass[i][col] + 1;
						}
						if(SouthInfoPass[0][i] == 1){
							WestSouthPass[i][col] = WestSouthPass[i][col] + 1;
						}
					}
//Suit
					for (int i = 0; i < 5; i++) {						
						if (WestInfoSuit[0][i] == 1 ) {
							WestWestSuitYes[i][col] = WestWestSuitYes[i][col] + 1;
						}
						else if(WestInfoSuit[0][i] == 0){
							WestWestSuitNo[i][col] = WestWestSuitNo[i][col] + 1;
						}
						if (NorthInfoSuit[0][i] == 1 ) {
							WestNorthSuitYes[i][col] = WestNorthSuitYes[i][col] + 1;
						}
						else if(NorthInfoSuit[0][i] == 0){
							WestNorthSuitNo[i][col] = WestNorthSuitNo[i][col] + 1;
						}
						if (EastInfoSuit[0][i] == 1 ) {
							WestEastSuitYes[i][col] = WestEastSuitYes[i][col] + 1;
						}
						else if(EastInfoSuit[0][i] == 0){
							WestEastSuitNo[i][col] = WestEastSuitNo[i][col] + 1;
						}
						if (SouthInfoSuit[0][i] == 1 ) {
							WestSouthSuitYes[i][col] = WestSouthSuitYes[i][col] + 1;
						}
						else if(SouthInfoSuit[0][i] == 0){
							WestSouthSuitNo[i][col] = WestSouthSuitNo[i][col] + 1;
						}
					}
					if (testBid  == 1) {
						if (gameBids.get(l+1) == 'C') {
							WestInfoSuit[0][0] = 1;
						}
						else if(gameBids.get(l+1) == 'D'){
							WestInfoSuit[0][1] = 1;
						}
						else if(gameBids.get(l+1) == 'H'){
							WestInfoSuit[0][2] = 1;
						}
						else if(gameBids.get(l+1) == 'S'){
							WestInfoSuit[0][3] = 1;
						}
						else if(gameBids.get(l+1) == 'T'){
							WestInfoSuit[0][4] = 1;
						}
					}
					else{
						if(gameBids.get(l) == 'B'){
							WestInfoPass[0][0] = 1;
							WestInfoPass[0][2] = 0;
						}
						else if(gameBids.get(l) == 'R'){
							WestInfoPass[0][1] = 1;
							WestInfoPass[0][2] = 0;
						}
					}

					WestInfoBid[0][0] = 0;
					if (gameBids.get(l) == 'P') {
						WestInfoBid[0][1] = 1 ;
					}
					else{
						WestInfoBid[0][2] = 1;
					}
//HERE
				}

				
				if (Character.isDigit(gameBids.get(l))) {
					l++;
				}
				tempDealer++;
				if (tempDealer > 3) {
					tempDealer = 0;
				}
			}
		}
		
		//end
		
		System.out.println("Finished building tables...");
		System.out.println();
		System.out.println("Printing tables for all bids (Amount of cards in each suit)...");
		System.out.println();
		System.out.println(String.format("%"+(getMaxInTable(AllBidsSpades)+1)*18+"s" , "----* Spades *----"));
		printTable(AllBidsSpades,0);
		System.out.println(String.format("%"+(getMaxInTable(AllBidsHearts)+1)*18+"s" , "----* HEARTS *----"));
		printTable(AllBidsHearts,0);
		System.out.println(String.format("%"+(getMaxInTable(AllBidsDiamonds)+1)*18+"s" , "----* DIAMONDS *----"));
		printTable(AllBidsDiamonds,0);
		System.out.println(String.format("%"+(getMaxInTable(AllBidsClubs)+1)*18+"s" , "----* CLUBS *----"));
		printTable(AllBidsClubs,0);
		System.out.println("Finished printing tables for all bids...");
		
		System.out.println("Printing tables for first bids (Amount of cards in each suit)...");
		System.out.println();
		System.out.println(String.format("%"+(getMaxInTable(FirstBidSpades)+1)*18+"s" , "----* Spades *----"));
		printTable(FirstBidSpades,0);
		System.out.println(String.format("%"+(getMaxInTable(FirstBidHearts)+1)*18+"s" , "----* HEARTS *----"));
		printTable(FirstBidHearts,0);
		System.out.println(String.format("%"+(getMaxInTable(FirstBidDiamonds)+1)*18+"s" , "----* DIAMONDS *----"));
		printTable(FirstBidDiamonds,0);
		System.out.println(String.format("%"+(getMaxInTable(FirstBidClubs)+1)*18+"s" , "----* CLUBS *----"));
		printTable(FirstBidClubs,0);
		System.out.println("Finished printing tables for first bids...");
		
		System.out.println("Printing tables for all bids (Amount of highcards in each suit)...");
		System.out.println();
		System.out.println(String.format("%"+(getMaxInTable(AllHighSuitBidsSpades)+1)*18+"s" , "----* Spades *----"));
		printTable(AllHighSuitBidsSpades,1);
		System.out.println(String.format("%"+(getMaxInTable(AllHighSuitBidsHearts)+1)*18+"s" , "----* HEARTS *----"));
		printTable(AllHighSuitBidsHearts,1);
		System.out.println(String.format("%"+(getMaxInTable(AllHighSuitBidsDiamonds)+1)*18+"s" , "----* DIAMONDS *----"));
		printTable(AllHighSuitBidsDiamonds,1);
		System.out.println(String.format("%"+(getMaxInTable(AllHighSuitBidsClubds)+1)*18+"s" , "----* CLUBS *----"));
		printTable(AllHighSuitBidsClubds,1);
		System.out.println("Finished printing tables for  suit value...");
		
		System.out.println("Printing tables for first bids (Amount of HighCards in each suit)...");
		System.out.println();
		System.out.println(String.format("%"+(getMaxInTable(FirstHighSuitBidsSpades)+1)*18+"s" , "----* Spades *----"));
		printTable(FirstHighSuitBidsSpades,1);
		System.out.println(String.format("%"+(getMaxInTable(FirstHighSuitBidsHearts)+1)*18+"s" , "----* HEARTS *----"));
		printTable(FirstHighSuitBidsHearts,1);
		System.out.println(String.format("%"+(getMaxInTable(FirstHighSuitBidsDiamonds)+1)*18+"s" , "----* DIAMONDS *----"));
		printTable(FirstHighSuitBidsDiamonds,1);
		System.out.println(String.format("%"+(getMaxInTable(FirstHighSuitBidsClubds)+1)*18+"s" , "----* CLUBS *----"));
		printTable(FirstHighSuitBidsClubds,1);
		System.out.println("Finished printing tables for first bids suit value...");
		
		System.out.println("Printing tables for all bids (Amount of HighCards in hand)...");
		System.out.println();
		System.out.println(String.format("%"+(getMaxInTable(AllHighHandBids)+1)*18+"s" , "----* ALL *----"));
		printTable(AllHighHandBids,0);
		System.out.println("Finished printing tables for all high card hand bids...");
		
		//HERE
		System.out.println("Printing tables for (NONE/PASS/OTHER)...");
		printTablesRound(NorthNorthBid,12);	
		printTablesRound(NorthEastBid,0);	
		printTablesRound(NorthSouthBid,1);
		printTablesRound(NorthWestBid,2);
		
		printTablesRound(EastEastBid,13);
		printTablesRound(EastSouthBid,3);	
		printTablesRound(EastWestBid,4);
		printTablesRound(EastNorthBid,5);
		
		printTablesRound(SouthSouthBid,14);
		printTablesRound(SouthWestBid,6);	
		printTablesRound(SouthNorthBid,7);
		printTablesRound(SouthEastBid,8);
		
		printTablesRound(WestWestBid,15);
		printTablesRound(WestNorthBid,9);	
		printTablesRound(WestEastBid,10);
		printTablesRound(WestSouthBid,11);
		System.out.println();
		System.out.println("Finished printing tables for (NONE/PASS/OTHER)...");
		System.out.println("Printing tables for (YES - CLUBS/DIAMONDS/HEARTS/SPADES/NT)...");
		printTablesSuit(NorthNorthSuitYes,12);
		printTablesSuit(NorthEastSuitYes,0);	
		printTablesSuit(NorthSouthSuitYes,1);
		printTablesSuit(NorthWestSuitYes,2);
		
		printTablesSuit(EastEastSuitYes,13);
		printTablesSuit(EastSouthSuitYes,3);	
		printTablesSuit(EastWestSuitYes,4);
		printTablesSuit(EastNorthSuitYes,5);
		
		printTablesSuit(SouthSouthSuitYes,14);
		printTablesSuit(SouthWestSuitYes,6);	
		printTablesSuit(SouthNorthSuitYes,7);
		printTablesSuit(SouthEastSuitYes,8);
		
		printTablesSuit(WestWestSuitYes,15);
		printTablesSuit(WestNorthSuitYes,9);	
		printTablesSuit(WestEastSuitYes,10);
		printTablesSuit(WestSouthSuitYes,11);
		System.out.println();
		System.out.println("Finished printing tables for (YES - CLUBS/DIAMONDS/HEARTS/SPADES/NT)...");
		System.out.println("Printing tables for (NO - CLUBS/DIAMONDS/HEARTS/SPADES/NT)...");
		printTablesSuit(NorthNorthSuitNo,12);
		printTablesSuit(NorthEastSuitNo,0);	
		printTablesSuit(NorthSouthSuitNo,1);
		printTablesSuit(NorthWestSuitNo,2);
		
		printTablesSuit(EastEastSuitNo,3);	
		printTablesSuit(EastSouthSuitNo,3);	
		printTablesSuit(EastWestSuitNo,4);
		printTablesSuit(EastNorthSuitNo,5);
		
		printTablesSuit(SouthSouthSuitNo,14);
		printTablesSuit(SouthWestSuitNo,6);	
		printTablesSuit(SouthNorthSuitNo,7);
		printTablesSuit(SouthEastSuitNo,8);
		
		printTablesSuit(WestWestSuitNo,15);
		printTablesSuit(WestNorthSuitNo,9);	
		printTablesSuit(WestEastSuitNo,10);
		printTablesSuit(WestSouthSuitNo,11);
		System.out.println();
		System.out.println("Finished printing tables for (NO - CLUBS/DIAMONDS/HEARTS/SPADES/NT)...");		
		System.out.println("Printing tables for (DOUBLE/REDOUBLE/NEITHER)...");
		printTablesPass(NorthNorthPass,12);	
		printTablesPass(NorthEastPass,0);	
		printTablesPass(NorthSouthPass,1);
		printTablesPass(NorthWestPass,2);
		
		printTablesPass(EastEastPass,13);
		printTablesPass(EastSouthPass,3);	
		printTablesPass(EastWestPass,4);
		printTablesPass(EastNorthPass,5);
		
		printTablesPass(SouthSouthPass,14);
		printTablesPass(SouthWestPass,6);	
		printTablesPass(SouthNorthPass,7);
		printTablesPass(SouthEastPass,8);
		
		printTablesPass(WestWestPass,15);
		printTablesPass(WestNorthPass,9);	
		printTablesPass(WestEastPass,10);
		printTablesPass(WestSouthPass,11);
		System.out.println();
		System.out.println("Finished printing tables for (DOUBLE/REDOUBLE/NEITHER)...");
		
		System.out.println("Printing tables for (NEXT LOWEST POSSIBLE BID)...");
		printNextPossBid();
		System.out.println("Finished printing tables for (NEXT LOWEST POSSIBLE BID)...");		
		storeArrays();
	
	}
	
	//next lowest possible bid
	
	private static void printTablesPass(int[][] array, int k) {
		System.out.println();
		if(k == 12){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH NORTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 0){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH EAST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 1){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH SOUTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 2){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH WEST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 13){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST EAST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 3){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST SOUTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 4){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST WEST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 5){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST NORTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 14){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH SOUTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 6){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH WEST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 7){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH NORTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 8){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH EAST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 15){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST WEST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 9){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST NORTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 10){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST EAST (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		else if(k == 11){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST SOUTH (DOUBLE/REDOUBLE/NEITHER)*----"));
		}
		int max = getMaxInTable2(array);
		System.out.print("   ");
		PrintLabelTop2(max);
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.print("  DOUBLE");
			}
			else if(i == 1){
				System.out.print("REDOUBLE");
			}
			else if(i == 2){
				System.out.print(" NEITHER");
			} 

			for (int j = 0; j < 38; j++) {

				System.out.print(rightPadding(array[i][j], max));
			}
			System.out.println();
		}
		System.out.println();
		
	}

	private static void printNextPossBid() {
		System.out.println("Printing table for card value");
		int max = 1000;
		max = 2 + (int)Math.floor(Math.log10(max));
		PrintLabelTop2(max);
		for (int i = 0; i < 7; i++) {
			int x = i +1;
			System.out.print("  "+x+"  ");
			
			for (int j = 0; j < 38; j++) {
				System.out.print(rightPadding(PossibleBidValue[i][j], max));
			}
			System.out.println();
		}
		System.out.println("Finished printing table for card value");
		System.out.println("Printing table for card suit");
		System.out.println();
		System.out.print("   ");
		PrintLabelTop2(max);
		for (int i = 0; i < 5; i++) {
			if(i == 0){
				System.out.print("   CLUBS");
			}
			else if(i == 1){
				System.out.print("DIAMONDS");
			}
			else if(i == 2){
				System.out.print("  HEARTS");
			}
			else if(i == 3){
				System.out.print("  SPADES");
			}
			else if(i == 4){
				System.out.print("      NT");
			}
			for (int j = 0; j < 38; j++) {
				System.out.print(rightPadding(PossibleBidSuit[i][j], max));
			}
			System.out.println();
		}
		System.out.println("Finished printing table for card suit");
		
	}


	//CLUBS/DIAMONDS/HEARTS/SPADES/NT//
	
	private static void printTablesSuit(int[][] array, int k) {

		System.out.println();
		if(k == 12){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH NORTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 0){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH EAST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 1){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH SOUTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 2){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH WEST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 13){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST EAST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 3){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST SOUTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 4){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST WEST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 5){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST NORTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 14){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH SOUTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 6){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH WEST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 7){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH NORTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 8){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH EAST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 15){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST WEST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 9){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST NORTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 10){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST EAST (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		else if(k == 11){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST SOUTH (CLUBS/DIAMONDS/HEARTS/SPADES/NT)*----"));
		}
		int max = getMaxInTable2(array);
		System.out.print("   ");
		PrintLabelTop2(max);
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				System.out.print("   CLUBS");
			}
			else if(i == 1){
				System.out.print("DIAMONDS");
			}
			else if(i == 2){
				System.out.print("  HEARTS");
			}
			else if(i == 3){
				System.out.print("  SPADES");
			}
			else if(i == 4){
				System.out.print("      NT");
			} 

			for (int j = 0; j < 38; j++) {

				System.out.print(rightPadding(array[i][j], max));
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//NONE OTHER PASS//
	
	private static void printTablesRound(int[][] array, int k) {

		System.out.println();
		if(k == 12){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH NORTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 0){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH EAST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 1){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH SOUTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 2){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*NORTH WEST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 13){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST EAST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 3){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST SOUTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 4){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST WEST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 5){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*EAST NORTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 14){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH SOUTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 6){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH WEST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 7){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH NORTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 8){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*SOUTH EAST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 15){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST WEST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 9){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST NORTH (NONE/PASS/OTHER)*----"));
		}
		else if(k == 10){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST EAST (NONE/PASS/OTHER)*----"));
		}
		else if(k == 11){
			System.out.println(String.format("%"+(getMaxInTable2(array)+1)*18+"s" , "----*WEST SOUTH (NONE/PASS/OTHER)*----"));
		}
		int max = getMaxInTable2(array);
		PrintLabelTop2(max);
		for (int i = 0; i < 3; i++) {
			if (i == 0) {
				System.out.print(" NONE");
			}
			else if(i == 1){
				System.out.print(" PASS");
			}
			else if(i == 2){
				System.out.print("OTHER");
			} 

			for (int j = 0; j < 38; j++) {

				System.out.print(rightPadding(array[i][j], max));
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void LowestPossibleBid(int col, String pbid) {
		//System.out.println(pbid+" "+col);
		int rowSuit = 0;
		int rowValue = 0;
		if (pbid.charAt(0) == 'X') {
			rowSuit = 0;
			rowValue = 0;
		}
		else if(pbid.length() > 1){
			if (pbid.charAt(1) == 'C') {
				rowSuit = 1;
			}
			else if(pbid.charAt(1) == 'D'){
				rowSuit = 2;
			}
			else if(pbid.charAt(1) == 'H'){
				rowSuit = 3;
			}
			else if(pbid.charAt(1) == 'S'){
				rowSuit = 4;
			}
			else if(pbid.charAt(1) == 'T'){
				if(pbid.charAt(0) != '7'){
					rowSuit = 0;
					int x = Character.getNumericValue(pbid.charAt(0)) + 1;
					col = findCol(Integer.toString(x).charAt(0) , 'T');

				}
				else {
					rowSuit = 4;
				}
			}
			rowValue = Character.getNumericValue(pbid.charAt(0)) - 1;
		}

		PossibleBidSuit[rowSuit][col] = PossibleBidSuit[rowSuit][col] + 1;
		PossibleBidValue[rowValue][col] = PossibleBidValue[rowValue][col] + 1;
	}

	/**********************************

	   This is the start of a method

	 **********************************/
	
	private static int findRowSuit(int[][] array) {
	
		for (int i = 0; i < 4; i++) {
			if (array[0][i] == 1) {
				return i;
			}
		}
		return 0;
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	private static int findCol(Character amount, Character suit) {
		int col = 0;
		int temp = Character.getNumericValue(amount);
		if(suit != 'X'){
			col = (temp - 1) * 5;
			if (suit == 'D') {
				col++;
			}
			else if(suit == 'H'){
				col +=2;
			}
			else if(suit == 'S'){
				col +=3;
			}
			else if(suit == 'T'){
				col +=4;
			}
		}
		else{
			if (amount == 'P') {
				col = 35;
			} else if (amount == 'B') {
				col = 36;
			} else if (amount == 'R') {
				col = 37;
			}
		}
		
		return col;
		
	}

	/**********************************

	   This is the start of a method

	 **********************************/
	
	private static int findRowBid(int[][] array) {
		
		for (int i = 0; i < 3; i++) {
			if (array[0][i] == 1) {
				return i;
			}
		}
		return 0;
		
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	private static void resetPlayerInfo() {

			NorthInfoBid[0][0] = 1;
			NorthInfoBid[0][1] = 0;
			NorthInfoBid[0][2] = 0;
			
			EastInfoBid[0][0] = 1;
			EastInfoBid[0][1] = 0;
			EastInfoBid[0][2] = 0;
			
			SouthInfoBid[0][0] = 1;
			SouthInfoBid[0][1] = 0;
			SouthInfoBid[0][2] = 0;
			
			WestInfoBid[0][0] = 1;
			WestInfoBid[0][1] = 0;
			WestInfoBid[0][2] = 0;
			
			//**
			
			NorthInfoPass[0][0] = 0;
			NorthInfoPass[0][1] = 0;
			NorthInfoPass[0][2] = 1;
			
			EastInfoPass[0][0] = 0;
			EastInfoPass[0][1] = 0;
			EastInfoPass[0][2] = 1;
			
			SouthInfoPass[0][0] = 0;
			SouthInfoPass[0][1] = 0;
			SouthInfoPass[0][2] = 1;
			
			WestInfoPass[0][0] = 0;
			WestInfoPass[0][1] = 0;
			WestInfoPass[0][2] = 1;
			
			for (int i = 0; i < 5; i++) {
					NorthInfoSuit[0][i] = 0;
					EastInfoSuit[0][i] = 0;
					SouthInfoSuit[0][i] = 0;
					WestInfoSuit[0][i] = 0;
				}
		
	}

	/**********************************

	   This is the start of a method

	 **********************************/

	private static void addToTableAllhighHandBids(int row, int column){
		
		AllHighHandBids[row][column]=AllHighHandBids[row][column]+1;
		
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	private static void addToTableFirstSuitBids(int rowS, int rowH, int rowD, int rowC, int column){
		
		FirstHighSuitBidsSpades[rowS][column] = FirstHighSuitBidsSpades[rowS][column] + 1 ;
		FirstHighSuitBidsClubds[rowC][column] = FirstHighSuitBidsClubds[rowC][column] + 1 ;
		FirstHighSuitBidsDiamonds[rowD][column] = FirstHighSuitBidsDiamonds[rowD][column] + 1 ;
		FirstHighSuitBidsHearts[rowH][column] = FirstHighSuitBidsHearts[rowH][column] + 1 ;
		
	}


	/**********************************

	   This is the start of a method

	 **********************************/

	private static void addToTableAllSuitBids(int rowS, int rowH, int rowD, int rowC, int column){
		
		AllHighSuitBidsSpades[rowS][column] = AllHighSuitBidsSpades[rowS][column] + 1 ;
		AllHighSuitBidsClubds[rowC][column] = AllHighSuitBidsClubds[rowC][column] + 1 ;
		AllHighSuitBidsDiamonds[rowD][column] = AllHighSuitBidsDiamonds[rowD][column] + 1 ;
		AllHighSuitBidsHearts[rowH][column] = AllHighSuitBidsHearts[rowH][column] + 1 ;
		
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	private static void addToTableFirstBids(int rowS, int rowH, int rowD, int rowC, int column) {

		FirstBidSpades[rowS][column] = FirstBidSpades[rowS][column] + 1;
		FirstBidClubs[rowC][column] = FirstBidClubs[rowC][column] + 1;
		FirstBidHearts[rowH][column] = FirstBidHearts[rowH][column] + 1;
		FirstBidDiamonds[rowD][column] = FirstBidDiamonds[rowD][column] + 1;

	}

	/**********************************

	   This is the start of a method

	 **********************************/

	private static void addToTableAllBids(int rowS, int rowH, int rowD, int rowC, int column) {

		AllBidsSpades[rowS][column] = AllBidsSpades[rowS][column] + 1;
		AllBidsClubs[rowC][column] = AllBidsClubs[rowC][column] + 1;
		AllBidsHearts[rowH][column] = AllBidsHearts[rowH][column] + 1;
		AllBidsDiamonds[rowD][column] = AllBidsDiamonds[rowD][column] + 1;

	}

	/**********************************

	   This is the start of a method

	 **********************************/

	private static int CalculateRow(int k,int t) {
		int j = 0;
		if (t == 0) {
			
			if (k > 0 && k < 2) {
				j = 0;
			} else if (k > 1 && k < 4) {
				j = 1;
			} else if (k > 3 && k < 7) {
				j = 2;
			} else if (k > 7) {
				j = 3;
			}
		}
		else if(t == 1){
			
			if (k == 0) {
				j = 0;
			} else if (k == 1) {
				j = 1;
			} else if (k > 1 && k < 4) {
				j = 2;
			} else if (k == 4) {
				j = 3;
			}
		}

		return j;

	}

	/**********************************

	   This is the start of a method

	 **********************************/

	public static int CalculateColumn(String s) {

		int i = 0;
		if (s.length() > 1) {
			i = 5 * (Character.getNumericValue(s.charAt(0)) - 1);
			if (s.charAt(1) == 'H') {
				i +=2;
			} else if (s.charAt(1) == 'D') {
				i += 1;
			} else if (s.charAt(1) == 'S') {
				i +=3;
			}else if (s.charAt(1) == 'T') {
				i += 4;
			}
		} else {
			if (s.charAt(0) == 'P') {
				i = 35;
			} else if (s.charAt(0) == 'B') {
				i = 36;
			} else if (s.charAt(0) == 'R') {
				i = 37;
			}
		}
		return i;

	}

	/**********************************

	   This is the start of a method

	 **********************************/

	public static void printTable(int[][] suit ,int x) {
		int max = getMaxInTable(suit);
		PrintLabelTop(max);
		for (int i = 0; i < 4; i++) {
			PrintLabelSide(x,i);
			for (int j = 0; j < 38; j++) {
				System.out.print(rightPadding(suit[i][j], max));
			}
			System.out.println();
		}

		System.out.println();
	}

	/**********************************

	   This is the start of a method

	 **********************************/

	private static int getMaxInTable(int[][] c) {
		int max=0;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 38; j++) {
				if (max < c[i][j]) {
					max = c[i][j];
				}
			}
		}
		max = 2 + (int)Math.floor(Math.log10(max));
		if (max < 4) {
			max=4;
		}
		return max;
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	private static int getMaxInTable2(int[][] c) {
		int max=0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 38; j++) {
				if (max < c[i][j]) {
					max = c[i][j];
				}
			}
		}
		max = 2 + (int)Math.floor(Math.log10(max));
		if (max < 4) {
			max=4;
		}
		return max;
	}

	/**********************************

	   This is the start of a method

	 **********************************/

	public static String rightPadding(int str, int num) {
		return String.format("%1$" + num + "s", str);
	}

	/**********************************

	   This is the start of a method

	 **********************************/

	public static void PrintLabelTop(int max) {

		String[] bids = {"1C","1D","1H","1S","1N","2C","2D","2H","2S","2N",
				"3C","3D","3H","3S","3N","4C","4D","4H","4S","4N",
				"5C","5D","5H","5S","5N","6C","6D","6H","6S","6N",
				"7C","7D","7H","7S","7N","P","D","R"};
		int count=0;
		System.out.print("     ");
		for (int i = 0; i < 38; i++) {
			System.out.print(String.format("%1$" + max + "s", bids[count++]));
		}
		System.out.println();
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	public static void PrintLabelTop2(int max) {

		String[] bids = {"1C","1D","1H","1S","1N","2C","2D","2H","2S","2N",
				"3C","3D","3H","3S","3N","4C","4D","4H","4S","4N",
				"5C","5D","5H","5S","5N","6C","6D","6H","6S","6N",
				"7C","7D","7H","7S","7N","P","D","R"};
		int count=0;
		System.out.print("     ");
		for (int i = 0; i < 38; i++) {
			System.out.print(String.format("%1$" + max + "s", bids[count++]));
		}
		System.out.println();
	}

	/**********************************

	   This is the start of a method

	 **********************************/

	public static void PrintLabelSide(int x, int i){
		
		if (x == 0) {
		
			if (i==0) {
				System.out.print("0 - 1");
			}
			else if (i==1) {
				System.out.print("2 - 3");
			}
			else if (i == 2) {
				System.out.print("4 - 6");
			}
			else {
				System.out.print("  7+ ");
			}
		
		}else if (x == 1) {
			
			if (i==0) {
				System.out.print("  0  ");
			}
			else if (i==1) {
				System.out.print("  1  ");
			}
			else if (i == 2) {
				System.out.print("2 - 3");
			}
			else {
				System.out.print("  4  ");
			}
		}
	}
	
	/**********************************

	   This is the start of a method

	 **********************************/

	public static void PopulateTables(){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 38; j++) {
				
				AllBidsClubs[i][j] = 0;
				AllBidsDiamonds[i][j] = 0;
				AllBidsHearts[i][j] = 0;
				AllBidsSpades[i][j] = 0;
				
				FirstBidClubs[i][j] = 0;
				FirstBidDiamonds[i][j] = 0;
				FirstBidHearts[i][j] = 0;
				FirstBidSpades[i][j] = 0;
				
				AllHighSuitBidsSpades[i][j] = 0;
				AllHighSuitBidsClubds[i][j] = 0;
				AllHighSuitBidsDiamonds[i][j] = 0;
				AllHighSuitBidsHearts[i][j] = 0;
				
				FirstHighSuitBidsSpades[i][j] = 0;
				FirstHighSuitBidsClubds[i][j] = 0;
				FirstHighSuitBidsDiamonds[i][j] = 0;
				FirstHighSuitBidsHearts[i][j] = 0;
				
				AllHighHandBids[i][j] = 0;
				
				if (i < 3) {
					NorthNorthBid[i][j] = 0;
					NorthEastBid[i][j] = 0;
					NorthSouthBid[i][j] = 0;
					NorthWestBid[i][j] = 0;
				
					EastEastBid[i][j] = 0;
					EastSouthBid[i][j] = 0;
					EastWestBid[i][j] = 0;
					EastNorthBid[i][j] = 0;
				
					SouthSouthBid[i][j] = 0;
					SouthWestBid[i][j] = 0;
					SouthNorthBid[i][j] = 0;
					SouthEastBid[i][j] = 0;

					WestWestBid[i][j] = 0;
					WestNorthBid[i][j] = 0;
					WestEastBid[i][j] = 0;
					WestSouthBid[i][j] = 0;
					
					NorthNorthPass[i][j] = 0;
					NorthEastPass[i][j] = 0;
					NorthSouthPass[i][j] = 0;
					NorthWestPass[i][j] = 0;
				
					EastEastPass[i][j] = 0;
					EastSouthPass[i][j] = 0;
					EastWestPass[i][j] = 0;
					EastNorthPass[i][j] = 0;
				
					SouthSouthPass[i][j] = 0;
					SouthWestPass[i][j] = 0;
					SouthNorthPass[i][j] = 0;
					SouthEastPass[i][j] = 0;

					WestWestPass[i][j] = 0;
					WestNorthPass[i][j] = 0;
					WestEastPass[i][j] = 0;
					WestSouthPass[i][j] = 0;
				}
			}	
		}
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 38; j++) {
				
				NorthNorthSuitYes[i][j] = 0;
				NorthEastSuitYes[i][j] = 0;
				NorthSouthSuitYes[i][j] = 0;
				NorthWestSuitYes[i][j] = 0;
			
				EastEastSuitYes[i][j] = 0;
				EastSouthSuitYes[i][j] = 0;
				EastWestSuitYes[i][j] = 0;
				EastNorthSuitYes[i][j] = 0;
			
				SouthSouthSuitYes[i][j] = 0;
				SouthWestSuitYes[i][j] = 0;
				SouthNorthSuitYes[i][j] = 0;
				SouthEastSuitYes[i][j] = 0;

				WestWestSuitYes[i][j] = 0;
				WestNorthSuitYes[i][j] = 0;
				WestEastSuitYes[i][j] = 0;
				WestSouthSuitYes[i][j] = 0;
				
//************** 
				
				NorthNorthSuitNo[i][j] = 0;
				NorthEastSuitNo[i][j] = 0;
				NorthSouthSuitNo[i][j] = 0;
				NorthWestSuitNo[i][j] = 0;
			
				EastEastSuitNo[i][j] = 0;
				EastSouthSuitNo[i][j] = 0;
				EastWestSuitNo[i][j] = 0;
				EastNorthSuitNo[i][j] = 0;
			
				SouthSouthSuitNo[i][j] = 0;
				SouthWestSuitNo[i][j] = 0;
				SouthNorthSuitNo[i][j] = 0;
				SouthEastSuitNo[i][j] = 0;

				WestWestSuitNo[i][j] = 0;
				WestNorthSuitNo[i][j] = 0;
				WestEastSuitNo[i][j] = 0;
				WestSouthSuitNo[i][j] = 0;
				
				PossibleBidSuit[i][j] = 0;
			}
		}
		
		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 38; j++) {
				PossibleBidValue[i][j] = 0;
			}
		}
	}
	
	public static void storeArrays() {
		
		AllBids.add(AllBidsSpades);
		AllBids.add(AllBidsHearts);
		AllBids.add(AllBidsDiamonds);
		AllBids.add(AllBidsClubs);
		
		Firstbids.add(FirstBidSpades);
		Firstbids.add(FirstBidHearts);
		Firstbids.add(FirstBidDiamonds);
		Firstbids.add(FirstBidClubs);
		
		AllHighSuitBids.add(AllHighSuitBidsSpades);
		AllHighSuitBids.add(AllHighSuitBidsHearts);
		AllHighSuitBids.add(AllHighSuitBidsDiamonds);
		AllHighSuitBids.add(AllHighSuitBidsClubds);
		
		FirstHighSuitBids.add(FirstHighSuitBidsSpades);
		FirstHighSuitBids.add(FirstHighSuitBidsHearts);
		FirstHighSuitBids.add(FirstHighSuitBidsDiamonds);
		FirstHighSuitBids.add(FirstHighSuitBidsClubds);
		
		HighHandBids.add(AllHighHandBids);
	
//BIDS	
		AllroundBids.add(NorthNorthBid);
		AllroundBids.add(NorthEastBid);
		AllroundBids.add(NorthSouthBid);
		AllroundBids.add(NorthWestBid);
		
		AllroundBids.add(EastEastBid);
		AllroundBids.add(EastSouthBid);
		AllroundBids.add(EastWestBid);
		AllroundBids.add(EastNorthBid);
		
		AllroundBids.add(SouthSouthBid);
		AllroundBids.add(SouthWestBid);
		AllroundBids.add(SouthNorthBid);
		AllroundBids.add(SouthEastBid);
		
		AllroundBids.add(WestWestBid);
		AllroundBids.add(WestNorthBid);
		AllroundBids.add(WestEastBid);
		AllroundBids.add(WestSouthBid);
		
//SUIT	
		AllroundSuit.add(NorthNorthSuitYes);
		AllroundSuit.add(NorthEastSuitYes);
		AllroundSuit.add(NorthSouthSuitYes);
		AllroundSuit.add(NorthWestSuitYes);
		
		AllroundSuit.add(EastEastSuitYes);
		AllroundSuit.add(EastSouthSuitYes);
		AllroundSuit.add(EastWestSuitYes);
		AllroundSuit.add(EastNorthSuitYes);
		
		AllroundSuit.add(SouthSouthSuitYes);
		AllroundSuit.add(SouthWestSuitYes);
		AllroundSuit.add(SouthNorthSuitYes);
		AllroundSuit.add(SouthEastSuitYes);
		
		AllroundSuit.add(WestWestSuitYes);
		AllroundSuit.add(WestNorthSuitYes);
		AllroundSuit.add(WestEastSuitYes);
		AllroundSuit.add(WestSouthSuitYes);
//NO
		AllroundSuit.add(NorthNorthSuitNo);
		AllroundSuit.add(NorthEastSuitNo);
		AllroundSuit.add(NorthSouthSuitNo);
		AllroundSuit.add(NorthWestSuitNo);
		
		AllroundSuit.add(EastEastSuitNo);
		AllroundSuit.add(EastSouthSuitNo);
		AllroundSuit.add(EastWestSuitNo);
		AllroundSuit.add(EastNorthSuitNo);
		
		AllroundSuit.add(SouthSouthSuitNo);
		AllroundSuit.add(SouthWestSuitNo);
		AllroundSuit.add(SouthNorthSuitNo);
		AllroundSuit.add(SouthEastSuitNo);
		
		AllroundSuit.add(WestWestSuitNo);
		AllroundSuit.add(WestNorthSuitNo);
		AllroundSuit.add(WestEastSuitNo);
		AllroundSuit.add(WestSouthSuitNo);
		
//PASS	
		AllroundPass.add(NorthNorthPass);
		AllroundPass.add(NorthEastPass);
		AllroundPass.add(NorthSouthPass);
		AllroundPass.add(NorthWestPass);
		
		AllroundPass.add(EastEastPass);
		AllroundPass.add(EastSouthPass);
		AllroundPass.add(EastWestPass);
		AllroundPass.add(EastNorthPass);
		
		AllroundPass.add(SouthSouthPass);
		AllroundPass.add(SouthWestPass);
		AllroundPass.add(SouthNorthPass);
		AllroundPass.add(SouthEastPass);
		
		AllroundPass.add(WestWestPass);
		AllroundPass.add(WestNorthPass);
		AllroundPass.add(WestEastPass);
		AllroundPass.add(WestSouthPass);

//Possible
		AllPosibleBids.add(PossibleBidValue);
		AllPosibleBids.add(PossibleBidSuit);

//ALL		
		tables.add(AllBids);
		tables.add(Firstbids);
		tables.add(AllHighSuitBids);
		tables.add(FirstHighSuitBids);
		tables.add(HighHandBids);
		tables.add(AllroundBids);
		tables.add(AllroundSuit);
		tables.add(AllroundPass);
		tables.add(AllPosibleBids);
	}
	
	public static ArrayList<ArrayList<int[][]>> getTables() {
		
		return tables;
	}
	
}
