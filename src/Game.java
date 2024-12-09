import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	int rent;
	int cash;
	int CurrentTurn;
	Wheel StartWheel;
	Wheel GameWheel;
	Scanner BetInput;
	ArrayList<Bond> Bonds;
	
	Game(Scanner scr){
		rent = 10;
		Bonds = new ArrayList<Bond>();
		this.CurrentTurn = 1;
		this.cash = 200;
		this.StartWheel = GameStarts.StandardAmerican();
		this.GameWheel = StartWheel;
		BetInput = scr;
	}


	
	//TODO:  Add an "invest" option.
	
	public void PrintOptions() {
		System.out.println("You currently have $" + cash + ".");
		RentDueIn();
		System.out.println("What would you like to do?");
		System.out.println("Bet - Place a bet and spin the wheel.");
		System.out.println("View - View the numbers on your wheel.");
		System.out.println("Bonds - View or purchase bonds.");
	}
	
	public void Bet() {
		this.CurrentTurn = this.CurrentTurn + 1;
		String input;
		int bet;
		int num;
		TileColor Color;
		System.out.println("How much would you like to bet?");
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
		System.out.println("3 - Even/Odd Bet.");
		input = BetInput.nextLine();
		input = input.trim();
		
		//THIS IS THE COLOR BET CODE 
		
		if (input.equals("1")){
			System.out.println("What color would you like to bet on? (RED or BLACK)");
			input = BetInput.nextLine();
			input = input.trim();
			if (input.equalsIgnoreCase("red")){
				Color = TileColor.RED;
			}
			else if (input.equalsIgnoreCase("black")){
				Color = TileColor.BLACK;
			}
			else {
				Color = null;
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
			
			if (num == Result.getNumber() && Result.getNumber() != 0) {
				System.out.println("You win!");
				bet = bet*35;
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
		else if (input.equals("3")){
			System.out.println("1 - Even.");
			System.out.println("2 - Odd.");
			input = BetInput.nextLine();
			input = input.trim();
			if (input.equalsIgnoreCase("1")){
				//even
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
				
				if ((Result.getNumber() != 0) && (Result.getNumber() % 2 == 0)) {
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
			else if (input.equalsIgnoreCase("2")){
				//odd
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
				
				if ((Result.getNumber() != 0) && (Result.getNumber() % 2 == 1)) {
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
			else {
				
			}
			
			
			
			
		}
		
		
		
		else {
			System.out.println("Unrecognized bet type.  - This is cheating.");
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
	
	public void AddBond(int Value) {
		this.cash = this.cash - Value;
		this.Bonds.add(new Bond (Value, CurrentTurn));
	}
	public void CheckBonds() {
		int val;
		for (int i = 0; i < this.Bonds.size(); i++) {
			if (this.Bonds.get(i).GetMaturity() <= this.CurrentTurn) {
				val = this.Bonds.get(i).Mature();
				System.out.println("A bond has matured.  $" + val + " has been added your your bank.");
				this.Bonds.remove(i);
				this.cash = this.cash + val;
			}
		}
	}
	public void PrintBonds() {
		int i = 1;
		for (Bond b : this.Bonds) {
			System.out.println(i + " - " + b.toString(this.CurrentTurn));
			i++;
		}
	}
	
	
	public void CheckRent() {
		if (CurrentTurn % 10 == 0) { //if it is turn 10, 20, etc trigger rent.
			System.out.println("Oh shit!  Rent is due.  You owe $" + this.rent + ".");
			System.out.println("$" + this.rent + " has been deducted from your bank.");
			this.cash = this.cash - this.rent;
			this.rent = (this.rent * 15)/10;  //multiply rent by 1.5.
		}
	}
	public void RentDueIn() {
		System.out.println("Rent is due in " + (10-(this.CurrentTurn % 10)) + " turns.");
	}
	
}
