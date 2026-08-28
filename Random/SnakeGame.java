// Snake Game in Java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SnakeGame extends JPanel implements ActionListener, KeyListener {

    // Screen size
    static final int WIDTH = 600;
    static final int HEIGHT = 600;

    // Size of each block
    static final int BLOCK_SIZE = 25;

    // Maximum number of snake blocks
    static final int MAX_BLOCKS = (WIDTH * HEIGHT) / (BLOCK_SIZE * BLOCK_SIZE);

    // Snake coordinates
    int[] snakeX = new int[MAX_BLOCKS];
    int[] snakeY = new int[MAX_BLOCKS];

    // Snake length
    int snakeLength = 3;

    // Food position
    int foodX;
    int foodY;

    // Direction
    char direction = 'R';

    // Game status
    boolean running = true;

    // Score
    int score = 0;

    // Random number generator
    Random random = new Random();

    // Game timer
    Timer timer;

    public SnakeGame() {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        addKeyListener(this);
        setFocusable(true);

        startGame();
    }

    // Start the game
    public void startGame() {

        // Initial snake position
        snakeX[0] = 300;
        snakeY[0] = 300;

        snakeX[1] = 275;
        snakeY[1] = 300;

        snakeX[2] = 250;
        snakeY[2] = 300;

        createFood();

        timer = new Timer(100, this);
        timer.start();
    }

    // Create food at random position
    public void createFood() {

        foodX = random.nextInt(WIDTH / BLOCK_SIZE) * BLOCK_SIZE;
        foodY = random.nextInt(HEIGHT / BLOCK_SIZE) * BLOCK_SIZE;
    }

    // Draw game
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        if (running) {

            // Draw food
            g.setColor(Color.RED);
            g.fillOval(
                    foodX,
                    foodY,
                    BLOCK_SIZE,
                    BLOCK_SIZE
            );

            // Draw snake
            for (int i = 0; i < snakeLength; i++) {

                if (i == 0) {
                    g.setColor(Color.GREEN);
                } else {
                    g.setColor(Color.YELLOW);
                }

                g.fillRect(
                        snakeX[i],
                        snakeY[i],
                        BLOCK_SIZE,
                        BLOCK_SIZE
                );
            }

            // Score
            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 25));

            g.drawString(
                    "Score: " + score,
                    10,
                    30
            );

        } else {

            // Game Over
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));

            g.drawString(
                    "GAME OVER",
                    170,
                    280
            );

            g.setColor(Color.WHITE);
            g.setFont(new Font("Arial", Font.BOLD, 25));

            g.drawString(
                    "Score: " + score,
                    250,
                    330
            );

            g.drawString(
                    "Press ENTER to restart",
                    170,
                    380
            );
        }
    }

    // Game loop
    @Override
    public void actionPerformed(ActionEvent e) {

        if (running) {

            move();

            checkFood();

            checkCollision();

            repaint();
        }
    }

    // Move snake
    public void move() {

        // Move body
        for (int i = snakeLength - 1; i > 0; i--) {

            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }

        // Move head
        switch (direction) {

            case 'U':
                snakeY[0] -= BLOCK_SIZE;
                break;

            case 'D':
                snakeY[0] += BLOCK_SIZE;
                break;

            case 'L':
                snakeX[0] -= BLOCK_SIZE;
                break;

            case 'R':
                snakeX[0] += BLOCK_SIZE;
                break;
        }
    }

    // Check if snake eats food
    public void checkFood() {

        if (snakeX[0] == foodX &&
            snakeY[0] == foodY) {

            snakeLength++;
            score++;

            createFood();
        }
    }

    // Check collision
    public void checkCollision() {

        // Hit own body
        for (int i = snakeLength - 1; i > 0; i--) {

            if (snakeX[0] == snakeX[i] &&
                snakeY[0] == snakeY[i]) {

                running = false;
            }
        }

        // Hit left wall
        if (snakeX[0] < 0) {
            running = false;
        }

        // Hit right wall
        if (snakeX[0] >= WIDTH) {
            running = false;
        }

        // Hit top wall
        if (snakeY[0] < 0) {
            running = false;
        }

        // Hit bottom wall
        if (snakeY[0] >= HEIGHT) {
            running = false;
        }

        // Stop timer
        if (!running) {
            timer.stop();
        }
    }

    // Keyboard controls
    @Override
    public void keyPressed(KeyEvent e) {

        switch (e.getKeyCode()) {

            case KeyEvent.VK_UP:

                if (direction != 'D') {
                    direction = 'U';
                }

                break;

            case KeyEvent.VK_DOWN:

                if (direction != 'U') {
                    direction = 'D';
                }

                break;

            case KeyEvent.VK_LEFT:

                if (direction != 'R') {
                    direction = 'L';
                }

                break;

            case KeyEvent.VK_RIGHT:

                if (direction != 'L') {
                    direction = 'R';
                }

                break;

            // Restart game
            case KeyEvent.VK_ENTER:

                if (!running) {

                    snakeLength = 3;
                    score = 0;
                    direction = 'R';
                    running = true;

                    snakeX[0] = 300;
                    snakeY[0] = 300;

                    snakeX[1] = 275;
                    snakeY[1] = 300;

                    snakeX[2] = 250;
                    snakeY[2] = 300;

                    createFood();

                    timer.start();

                    repaint();
                }

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    // Main method
    public static void main(String[] args) {

        JFrame frame = new JFrame("Snake Game");

        SnakeGame game = new SnakeGame();

        frame.add(game);

        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLocationRelativeTo(null);

        frame.setResizable(false);

        frame.setVisible(true);

        game.requestFocusInWindow();
    }
}

