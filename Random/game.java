//game to understand the concept of random number generation
import java.util.Random;
public class game {
    public static void main(String[] args) {
        Random rand = new Random();
        int randomNum = rand.nextInt(100); // generates a random number between 0 and 99
        System.out.println("Random Number: " + randomNum);

        // Simple guessing game
        int guess = 50; // Example guess
        if (guess < randomNum) {
            System.out.println("Your guess is too low!");
        } else if (guess > randomNum) {
            System.out.println("Your guess is too high!");
        } else {
            System.out.println("Congratulations! You guessed the number!");
        }
    }
}