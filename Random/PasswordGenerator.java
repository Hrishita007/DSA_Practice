import java.util.Random;

public class PasswordGenerator {
    public static void main(String[] args) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%";
        Random r = new Random();

        String password = "";

        for (int i = 0; i < 8; i++) {
            password += chars.charAt(r.nextInt(chars.length()));
        }

        System.out.println("Your password: " + password);
    }
}