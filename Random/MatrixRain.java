import java.util.Random;

public class MatrixRain {

    public static void main(String[] args) throws InterruptedException {

        Random random = new Random();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789@#$%&";

        int width = 80;
        int height = 25;

        while (true) {

            StringBuilder screen = new StringBuilder();

            for (int row = 0; row < height; row++) {

                for (int col = 0; col < width; col++) {

                    if (random.nextInt(10) < 2) {
                        char c = chars.charAt(
                            random.nextInt(chars.length())
                        );

                        screen.append(c);
                    } else {
                        screen.append(" ");
                    }
                }

                screen.append("\n");
            }

            // Clear terminal
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.print(screen);

            Thread.sleep(80);
        }
    }
}