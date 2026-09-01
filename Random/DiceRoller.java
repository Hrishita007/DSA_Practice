import java.util.Random;

public class DiceRoller {
    public static void main(String[] args) {
        Random r = new Random();

        int dice = r.nextInt(6) + 1;

        System.out.println("🎲 You rolled: " + dice);

        if (dice == 6)
            System.out.println("🔥 Lucky! You got a 6!");
        else
            System.out.println("Try again!");
    }
}