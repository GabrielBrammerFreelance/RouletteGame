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
				
				GameState.PrintOptions();
				input = ScrInput.nextLine().trim().toLowerCase();
				//TODO: This is where the logic for what to do will happen.
				if (input.equals("bet")) {
					GameState.Bet();
				}
				else if (input.equals("view")) {
					GameState.view();
				}
				lost = GameState.LostGame();
			}
			
		}
		
		

	}

}
