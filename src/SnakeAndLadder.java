import java.util.Random;

public class SnakeAndLadder {
    private static final int START_POSITION = 0;
public static void main(String[] args) {
	System.out.println("Welcome to Snake And Ladder Game\n");
	int playerPosition = START_POSITION;
	System.out.println("Player starts at position: " + playerPosition);
	 Random random=new Random();
	 int dieRoll=random.nextInt(6)+1;
	 System.out.println("Player rolls the die and gets: "+dieRoll);
}
}
