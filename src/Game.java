import java.util.Scanner;

public class Game {
	int cash;
	Wheel StartWheel;
	Wheel GameWheel;
	Scanner BetInput;
	
	Game(Scanner scr){
		this.cash = 200;
		this.StartWheel = GameStarts.StandardAmerican();
		this.GameWheel = StartWheel;
		BetInput = scr;
	}


	
	//TODO:  Add an "invest" option.
	
	public void PrintOptions() {
		System.out.println("You currently have $" + cash + ".");
		System.out.println("What would you like to do?");
		System.out.println("Bet - Place a bet and spin the wheel.");
		System.out.println("View - View the numbers on your wheel.");
	}
	
	public void Bet() {
		String input;
		int bet;
		int num;
		TileColor Color;
		System.out.println("How much would you like to bet?");
		System.out.println("(Type \"cancel\" at any time to cancel bet.");
		input = BetInput.nextLine();
		input = input.trim();
		if (input.equalsIgnoreCase("cancel")) {
			return;
		}
		else {
			bet = Integer.parseInt(input);
		}
		
		//TODO:  ADD even/odd, LO/HI.
		//TODO: note, no number bets may be placed on 0.
		System.out.println("What kind of bet would you like to make?");
		System.out.println("1 - Color Bet.");
		System.out.println("2 - Number Bet.");
		input = BetInput.nextLine();
		input = input.trim();
		if (input.equalsIgnoreCase("cancel")) {
			return;
		}
		
		//THIS IS THE COLOR BET CODE 
		
		else if (input.equals("1")){
			System.out.println("What color would you like to bet on? (RED or BLACK)");
			input = BetInput.nextLine();
			input = input.trim();
			if (input.equalsIgnoreCase("cancel")) {
				return;
			}
			else if (input.equalsIgnoreCase("red")){
				Color = TileColor.RED;
			}
			else if (input.equalsIgnoreCase("black")){
				Color = TileColor.BLACK;
			}
			else {
				System.out.println("Invalid input.  Exiting.");
				return;
			}
			
			System.out.println("Your bet is locked in!  Press enter to spin the wheel.");
			BetInput.nextLine();
			System.out.print("Spinning");
			try {
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println(".");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Tile Result = this.GameWheel.Spin();
			System.out.println("The ball landed on: " + Result.toString() + ".");
			
			if (Color.equals(Result.getColor())) {
				System.out.println("You win!");
				bet = bet + bet;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("$" + bet + " has been added to your bank.");
				this.cash = this.cash + bet;
				AddTile();
			}
			else {
				Lose(bet);
			}
			
			
		}
		else if (input.equals("2")) {
			System.out.println("What Number would you like to bet on?");
			input = BetInput.nextLine();
			input = input.trim();
			num = Integer.parseInt(input);
			
			System.out.println("Your bet is locked in!  Press enter to spin the wheel.");
			BetInput.nextLine();
			System.out.print("Spinning");
			try {
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.print(".");
				Thread.sleep(1000);
				System.out.println(".");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Tile Result = this.GameWheel.Spin();
			System.out.println("The ball landed on: " + Result.toString() + ".");
			
			if (num == Result.getNumber()) {
				System.out.println("You win!");
				bet = bet*36;
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("$" + bet + " has been added to your bank.");
				this.cash = this.cash + bet;
				AddTile();
			}
			else {
				Lose(bet);
			}
		}
		
		
		
		else {
			System.out.println("Unrecognized bet type.");
			return;
		}
		
		
	}
	
	public void Lose(int bet) {
		System.out.print("You lose");
		try {
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.println(".");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("$" + bet + " has been deducted from your bank.");
		this.cash = this.cash - bet;
		System.out.println("Another 0 has been added to the wheel...");
		this.GameWheel.addTile(TileColor.GREEN, 0);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddTile() {
		//TODO: Maybe let them choose 3 from the base wheel or 2 from current wheel?
		System.out.print("You may add a new tile to the Roulette wheel");  //add 3 .s over 3s
		try {
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.print(".");
			Thread.sleep(1000);
			System.out.println(".");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("Your options are:");
		int[] options = new int[3];
		options[0] = this.StartWheel.SpinIndex();
		options[1] = this.StartWheel.SpinIndex();
		options[2] = this.StartWheel.SpinIndex();
		Tile[] TileOptions = new Tile[3];
		TileOptions[0] = this.StartWheel.GetIndex(options[0]);
		TileOptions[1] = this.StartWheel.GetIndex(options[1]);
		TileOptions[2] = this.StartWheel.GetIndex(options[2]);
		System.out.println("1 - " + TileOptions[0].toString() + ".");
		System.out.println("2 - " + TileOptions[1].toString() + ".");
		System.out.println("3 - " + TileOptions[2].toString() + ".");
		System.out.print("Enter your selection: ");
		int selection = BetInput.nextInt() -1;
		this.GameWheel.addTileDirect(TileOptions[selection]);
		System.out.println("A " + TileOptions[selection].toString() + " has been added to your wheel!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean LostGame() {
		if (cash <= 0) {
			return true;
		}
		return false;
	}
	
	public void view() {
		this.GameWheel.PrintIndexedTiles();
	}
	
	
}
