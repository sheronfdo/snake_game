/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
//import sun.java2d.loops.DrawLine;

/**
 *
 * @author Jamit
 */
public class game_panel extends JPanel implements ActionListener {
    //constructor of class 

    static final int screen_width = 600; // game screen width
    static final int screen_height = 600; // game screen height
    static final int unit_size = 30;  // game base unit size
    static final int game_units = (screen_width * screen_height) / unit_size;  // number of game units
    static final int delay = 200;  // delay for timer
    final int x[] = new int[game_units];  // array for store x movement data
    final int y[] = new int[game_units];  // array for store y movement data
    int body_parts = 6;  // number of body parts
    int apples_eaten; // number of eaten apples
    int appleX; // apple x axis location
    int appleY; // apple y axis location
    char direction = 'R'; // store direction
    boolean running = false; // store current status
    Timer timer; // timwe for run
    Random random; // generate random numbers

    // constructor
    public game_panel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screen_width, screen_height)); // preparing screen size
        this.setBackground(Color.BLACK); // backgroud colore of game
        this.setFocusable(true); // for get focus to listers
        this.addKeyListener(new my_key_adapter()); // listining action
        startGame(); // run/call start game
    }

    public void startGame() {
        new_apple(); // call method for creating new apple location
        running = true; // change status
        timer = new Timer(delay, this); // initialize timer
        timer.start(); // start timer
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // get super access for this graphics
        draw(g); // call and pass graphic object to method draw
    }

    public void draw(Graphics g) {
        if (running) {
            /*for (int i = 0; i < screen_height / unit_size; i++) {
                g.drawLine(i * unit_size, 0, i * unit_size, screen_height);
                g.drawLine(0, i * unit_size, screen_width, i * unit_size);
            }*/
            g.setColor(Color.red);
            g.fillOval(appleX, appleY, unit_size, unit_size);

            for (int i = 0; i < body_parts; i++) {
                if (i == 0) {
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                } else {
                    //g.setColor(new Color(45, 180, 0));
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                }
            }
        } else {
            game_over(g);
        }
    }

    public void new_apple() {
        appleX = random.nextInt((int) (screen_width / unit_size)) * unit_size;
        appleY = random.nextInt((int) (screen_height / unit_size)) * unit_size;
    }

    public void move() {
        for (int i = body_parts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        switch (direction) {
            case 'U':
                y[0] = y[0] - unit_size;
                break;
            case 'D':
                y[0] = y[0] + unit_size;
                break;
            case 'L':
                x[0] = x[0] - unit_size;
                break;
            case 'R':
                x[0] = x[0] + unit_size;
                break;
        }
    }

    public void check_apple() {
        if ((x[0] == appleX) && (y[0] == appleY)) {
            body_parts++;
            apples_eaten++;
            new_apple();
        }
    }

    public void check_collision() {
        //check is head collides with body
        for (int i = body_parts; i > 0; i--) {
            if ((x[0] == x[i]) && (y[0] == y[i])) {
                running = false;
            }
        }
        //check is head touch left border
        if (x[0] < 0) {
            running = false;
        }
        //check is head touch right border
        if (x[0] > screen_width) {
            running = false;
        }
        //check is head touch up border
        if (y[0] < 0) {
            running = false;
        }
        //check is head touch down border
        if (y[0] > screen_height) {
            running = false;
        }
        if (!running) {
            timer.stop();
        }
    }

    public void game_over(Graphics g) {
        //game over text
        g.setColor(Color.red);
        g.setFont(new Font("Ink Free",Font.BOLD, 75));
        FontMetrics metrics =  getFontMetrics(g.getFont());
        g.drawString("Game Over", (screen_width - metrics.stringWidth("Game Over"))/2, screen_height/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (running) {
            move();
            check_apple();
            check_collision();
        }
        repaint();
    }

    public class my_key_adapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
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
                case KeyEvent.VK_D:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_A:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_W:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_S:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;

            }
        }
    }

}
