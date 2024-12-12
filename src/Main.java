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
				
				if (GameState.LostGame()) {
					lost = GameState.LostGame();
					break;
				}
				
				GameState.PrintOptions();
				input = ScrInput.nextLine().trim().toLowerCase();
				//TODO: This is where the logic for what to do will happen.
				if (input.equals("Roulette")) {
					GameState.Bet();
				}
				else if (input.equals("view wheel")) {
					GameState.view();
				}
				else if (input.equals("bonds")) {
					Bonds(GameState, ScrInput);
				}
				else if (input.equals("blackjack")) {
					GameState.BlackJack();
				}
				lost = GameState.LostGame();
			}
			
			System.out.println("You've went BANKRUPT!");
			try {
				Thread.sleep(1000);
				System.out.println("Better luck next time!");
				Thread.sleep(1000);
				System.out.print("But remember");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println(".");
				Thread.sleep(1000);
				System.out.println("THE HOUSE ALWAYS WINS");
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Would you like to play again?");
			System.out.print("Y/N: ");
			if (ScrInput.next().trim().equalsIgnoreCase("y")){
				//do nothing
			}
			else {
				Continue = false;
				System.out.println("Goodbye!");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		

	}
	
	private static void Bonds(Game GameState, Scanner ScrInput) {
		String input;
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
	
	
	

}
