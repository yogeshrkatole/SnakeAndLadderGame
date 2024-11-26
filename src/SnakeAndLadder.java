import java.util.Random;

public class SnakeAndLadder {
	private static final int START_POSITION = 0;
	private static final int NO_PLAY = 0;
	private static final int LADDER = 1;
	private static final int SNAKE = 2;
	private static final int WINNING_POSITION = 100;

	public static void main(String[] args) {
		System.out.println("Welcome to Snake And Ladder Game\n");
		int playerPosition = START_POSITION;
		System.out.println("Player starts at position: " + playerPosition);
		Random random = new Random();
		while (playerPosition < WINNING_POSITION) {
			int dieRoll = random.nextInt(6) + 1;
			System.out.println("Player rolls the die and gets: " + dieRoll);

			int option = random.nextInt(3);
			switch (option) {
			case NO_PLAY:
				System.out.println("Player Stays In Same Position");
				break;
			case LADDER:
				System.out.println("Player Moves Ahead by " + dieRoll);
				if(playerPosition + dieRoll<=WINNING_POSITION) {
				playerPosition += dieRoll;
				}else {
					System.out.println("Players cannot exceed position 100 "+playerPosition);
				}
				break;
			case SNAKE:
				System.out.println("Player Fall Down by " + dieRoll);
				playerPosition -= dieRoll;
				if (playerPosition < 0)
					playerPosition = 0;
				break;
			}
			System.out.println("Player Current Position " + playerPosition);
		}
        System.out.println("\nCongratulations! Player reached the winning position: " + WINNING_POSITION);

	}
}
