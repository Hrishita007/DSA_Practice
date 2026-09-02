public class HackerTerminal {

    public static void main(String[] args) throws InterruptedException {

        String[] messages = {
            "Initializing system...",
            "Connecting to main server...",
            "Bypassing firewall...",
            "Accessing database...",
            "Decrypting files...",
            "Downloading secret data...",
            "████████████████████ 100%",
            "ACCESS GRANTED 😎"
        };

        for (String message : messages) {
            System.out.println(message);
            Thread.sleep(800);
        }

        System.out.println("\n💀 Just kidding. Nothing was hacked.");
    }
}