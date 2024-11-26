import java.util.Random;

public class SnakeAndLadder {
	private static final int START_POSITION = 0;
	private static final int NO_PLAY = 0;
	private static final int LADDER = 1;
	private static final int SNAKE = 2;
	private static final int WINNING_POSITION = 100;

	public static void main(String[] args) {
		System.out.println("Welcome to Snake And Ladder Game\n");
		int playerPosition1 = START_POSITION;
		int playerPosition2 = START_POSITION;
		int diceRollsPlayer1=0;
		int diceRollsPlayer2=0;
		System.out.println("Player1 starts at position: " + playerPosition1);
		Random random = new Random();
		boolean player1Turn=true;
		while (playerPosition1 < WINNING_POSITION && playerPosition2 < WINNING_POSITION) {
		 if(player1Turn) {
			 System.out.println("Player1 turn");
			 diceRollsPlayer1++;
			 playerPosition1 = turn(playerPosition1,random,"Player 1");
			 if(playerPosition1==WINNING_POSITION)
				 break;
		 }else {
			 System.out.println("Player2 turn");
			 diceRollsPlayer2++;
			 playerPosition1 = turn(playerPosition1,random,"Player 2");
			 if(playerPosition2==WINNING_POSITION)
				 break;
		 }
		 player1Turn=!player1Turn;
			
		}
		if(playerPosition1==WINNING_POSITION) {
			System.out.println("Player1 win game");
		}else {
			System.out.println("Player2 win game");

		}
        System.out.println("\nCongratulations! Player reached the winning position: " + WINNING_POSITION);
        System.out.println("Total Dice Count Player1 :"+diceRollsPlayer1);
        System.out.println("Total Dice Count Player2 :"+diceRollsPlayer2);

	}
	
	private static int turn(int position,Random random,String playerName) {
		int dieRoll = random.nextInt(6) + 1;
		System.out.println(playerName +" Player rolls the die and gets: " + dieRoll );

		int option = random.nextInt(3);
		switch (option) {
		case NO_PLAY:
			System.out.println(playerName +" Player Stays In Same Position "+position);
			break;
		case LADDER:
			System.out.println(playerName +" Player Moves Ahead by " + dieRoll+" position "+position);
			if(position + dieRoll<=WINNING_POSITION) {
			position += dieRoll;
			}else {
				System.out.println(playerName +" Player cannot exceed position 100 "+position);
			}
			System.out.println(playerName +" Gets another turn");
			position=turn(position, random, playerName);
			break;
		case SNAKE:
			System.out.println(playerName +" Player Fall Down by " + dieRoll+" position "+position);
			position -= dieRoll;
			if (position < 0)
				position = 0;
			break;
		}
		System.out.println(playerName +" Player Current Position " + position);
		return position;
	}
}
