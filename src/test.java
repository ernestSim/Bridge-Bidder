/*---------------------------*/
/*	         dealer			 */
/*			  0=N			 */
/*			  1=E			 */
/*			  2=S			 */
/*			  3=W			 */
/*---------------------------*/
public class test {
	public static void main(String[] args) {
		

		System.out.println("Getting input from file...");
		Read_file1.readFile();
		System.out.println("Finished reading input from file...");
		//GameInfo.getBidsFor(0, 2);
		System.out.println("Building tables...");
		BuildTables.bidsTable();
		System.out.println("Calculating bid...");
		System.out.println();
		CalculateBids2.CalculateBids();
		System.out.println("Finished calculating bid...");
		System.out.println("Printing game data...");
		//GameInfo.PrintGames();
		System.out.println("Finished printing game data...");
		System.out.println("The End");
		
//		for (int i = 0; i < 5; i++) {
//			for (int j = 0; j < 4; j++) {
//				System.out.print(GameInfo.countPlayerHandStrenght(i,j)+" ");
//			}
//		}
		
		
	}
}
