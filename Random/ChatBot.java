import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatBot extends JFrame {

    private JTextArea chatArea;
    private JTextField inputField;
    private JButton sendButton;

    public ChatBot() {
        // Window
        setTitle("🤖 Java ChatBot");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Chat area
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFont(new Font("Arial", Font.PLAIN, 16));
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(chatArea);

        // Input field
        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));

        // Send button
        sendButton = new JButton("Send");
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Bottom panel
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        bottomPanel.add(inputField, BorderLayout.CENTER);
        bottomPanel.add(sendButton, BorderLayout.EAST);

        // Add components
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome message
        chatArea.append("🤖 Bot: Hello! I'm JavaBot.\n");
        chatArea.append("🤖 Bot: Type 'help' to see what I can do.\n\n");

        // Button click
        sendButton.addActionListener(e -> sendMessage());

        // Press Enter
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String userMessage = inputField.getText().trim();

        if (userMessage.isEmpty()) {
            return;
        }

        chatArea.append("👤 You: " + userMessage + "\n");

        String botResponse = getResponse(userMessage);

        chatArea.append("🤖 Bot: " + botResponse + "\n\n");

        inputField.setText("");
    }

    private String getResponse(String message) {

        String msg = message.toLowerCase();

        if (msg.contains("hello") || msg.contains("hi") || msg.contains("hey")) {
            return "Hey! 👋 Nice to meet you!";
        }

        if (msg.contains("how are you")) {
            return "I'm running perfectly! 🤖";
        }

        if (msg.contains("name")) {
            return "My name is JavaBot. ☕";
        }

        if (msg.contains("java")) {
            return "Java is awesome! ☕🔥";
        }

        if (msg.contains("joke")) {
            return "Why did the Java developer wear glasses? Because they couldn't C#! 😂";
        }

        if (msg.contains("time")) {
            return "Check your clock! 😜 I'm still learning how to tell time.";
        }

        if (msg.contains("help")) {
            return "Try saying: hello, how are you, what's your name, java, joke, or bye.";
        }

        if (msg.contains("bye") || msg.contains("exit")) {
            return "Goodbye! 👋 Have a great day!";
        }

        return "Hmm... 🤔 I don't understand that yet.";
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ChatBot bot = new ChatBot();
            bot.setVisible(true);
        });
    }
}