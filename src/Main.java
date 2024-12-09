import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner ScrInput = new Scanner(System.in);
		boolean Continue = true;
		String input;
		
		while (Continue) {
			Game GameState = new Game(ScrInput);
			boolean lost = false;
			while (!lost) {
				
				GameState.CheckBonds();
				GameState.CheckRent();
				
				GameState.PrintOptions();
				input = ScrInput.nextLine().trim().toLowerCase();
				//TODO: This is where the logic for what to do will happen.
				if (input.equals("bet")) {
					GameState.Bet();
				}
				else if (input.equals("view")) {
					GameState.view();
				}
				else if (input.equals("bonds")) {
					System.out.println("1 - View bonds.");
					System.out.println("2 - Purchase bonds.");
					input = ScrInput.nextLine().trim();
					if (input.equals("1")) {
						GameState.PrintBonds();
					}
					else if (input.equals("2")) {
						System.out.println("Bonds mature after 5 turns.  What size bond would you like to purchase?");
						System.out.println("1 - $10 bond.");
						System.out.println("2 - $100 bond.");
						input = ScrInput.nextLine();
						if (input.equals("1")) {
							GameState.AddBond(10);
						}
						else if (input.equals("2")) {
							GameState.AddBond(100);
						}
					}
				}
				lost = GameState.LostGame();
			}
			
		}
		
		

	}
	
	
	

}
