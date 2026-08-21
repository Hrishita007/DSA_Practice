import java.util.*;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();

        System.out.print("Enter rock, paper, or scissors: ");
        String user = sc.nextLine().toLowerCase();

        String[] choices = {"rock", "paper", "scissors"};
        String computer = choices[r.nextInt(3)];

        System.out.println("Computer: " + computer);

        if (user.equals(computer))
            System.out.println("Draw!");
        else if ((user.equals("rock") && computer.equals("scissors")) ||
                 (user.equals("paper") && computer.equals("rock")) ||
                 (user.equals("scissors") && computer.equals("paper")))
            System.out.println("You win!");
        else
            System.out.println("Computer wins!");
    }
}