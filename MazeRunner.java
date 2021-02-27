import java.util.Scanner;

public class MazeRunner {

	public static void main(String[] args) {
		Maze myMap = new Maze();
		int moveCounter = 0;
		intro();
		while (!myMap.didIWin() && moveCounter<100 ) {
			movesMessage(moveCounter);
			myMap.printMap();
			if (userMoveSelection().equals("R")) {
				System.out.println("Checking R");
				System.out.println(myMap.canIMoveRight());
				if (myMap.canIMoveRight()) {
					myMap.moveRight();
				} else if (myMap.isThereAPit("R")) {
					System.out.println(myMap.isThereAPit("R"));
					System.out.println("Yes there is a Pit");
					if (navigatePit()) {
						myMap.jumpOverPit("R");
					}
				}
				else {System.out.println("Sorry you hit wall");
				}
			} else if (userMoveSelection().equals("D")) {
				System.out.println("Checking D");
				System.out.println(myMap.canIMoveDown());
				if (myMap.canIMoveDown()) {
					myMap.moveDown();
					
				}
				else if (myMap.isThereAPit("D")) {
					System.out.println(myMap.isThereAPit("D"));
					System.out.println("Yes there is a Pit");
					if (navigatePit()) {
						myMap.jumpOverPit("D");
					}
				}
				else {
					System.out.println("Sorry you hit wall");
				}
			} else if (userMoveSelection().equals("L")) {
				System.out.println("Checking L");
				System.out.println(myMap.canIMoveLeft());
				if (myMap.canIMoveLeft()) {
					myMap.moveLeft();}
					else if (myMap.isThereAPit("L")) {
						System.out.println(myMap.isThereAPit("L"));
						System.out.println("Yes there is a Pit");
						if (navigatePit()) {
							myMap.jumpOverPit("L");}
					} 
				else {
					System.out.println("Sorry you hit wall");
				}
			}
			else 
			{
				System.out.println("Checking U");
				System.out.println(myMap.canIMoveUp());
				if (myMap.canIMoveUp()) {
					myMap.moveUp();
				} 
				else if (myMap.isThereAPit("U")) {
					System.out.println(myMap.isThereAPit("U"));
					System.out.println("Yes there is a Pit");
					if (navigatePit()) {
						myMap.jumpOverPit("U");
					}
				}
				else 
				
				{
					System.out.println("Sorry you hit wall");
				}

			}
			moveCounter++;
		}
		if (moveCounter<100) {
		System.out.println("Congratulations, you made it out alive! and you did it in "+ moveCounter + "moves");}
		else {System.out.println("Sorry, but you didn't escape in time- you lose!");}
	}

	private static void intro() {

		System.out.println("Welcome to maze runner!");
		System.out.println("Here is your map");
	}

	public static String userMoveSelection() {

		String move = null;

		while (move == null && (!"L".equals(move)) && (!"L".equals(move)) && (!"U".equals(move))
				&& (!"D".equals(move))) {
			System.out.println("where would you like to move? (R, L, U, D)");
			Scanner sc1 = new Scanner(System.in);
			move = sc1.nextLine();
			if (move.equals("L") || move.equals("R") || move.equals("U") || move.equals("D")) {
				System.out.println("you entered " + move);
				break;
			}

			else {
				System.out.println("you entered " + move + " Please insert other input");
			}

		}
		return move;

	}

	public static void movesMessage(int moveCounter) {

		switch (moveCounter) {
		case 50:
			System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
			break;
		case 75:
			System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
		case 90:
			System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
		case 100:
			System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
			System.out.println("Sorry, but you didn't escape in time- you lose!");
		default:
			break;
		}

	}

	public static boolean navigatePit() {
		System.out.println("Watch out! There's a pit ahead, jump it?");
		String ans = null;
		Scanner sc2 = new Scanner(System.in);
		ans = sc2.nextLine();
		if (ans.startsWith("y")) {
			return true;
		} else {
			return false;
		}

	}
}
