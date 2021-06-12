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

/**
 *
 * @author Jamit
 */
public class game_panel extends JPanel implements ActionListener {
    //constructor of class 
    score_board score = new score_board();
    
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
        this.setBounds(0, 0, screen_width, screen_height);
        //this.setPreferredSize(new Dimension(screen_width, screen_height)); // preparing screen size
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
        if (running) { // if game is running mode
            /*for (int i = 0; i < screen_height / unit_size; i++) {
                g.drawLine(i * unit_size, 0, i * unit_size, screen_height);
                g.drawLine(0, i * unit_size, screen_width, i * unit_size);
            }*/
            g.setColor(Color.red);// set apple colour as red 
            g.fillOval(appleX, appleY, unit_size, unit_size); // draw apple in panel with random location

            for (int i = 0; i < body_parts; i++) {// draw body parts one by one in panel components
                if (i == 0) { // if first part(head of snake) colour is green and draw in panel
                    g.setColor(Color.green);
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                } else { // all other parts are can be rabdom colours 
                    //g.setColor(new Color(45, 180, 0));
                    g.setColor(new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255)));
                    g.fillRect(x[i], y[i], unit_size, unit_size);
                }
            }
        } else { // if game is running mode false
            game_over(g); // run game over method for stop game
        }
    }

    public void new_apple() {
        score.setscore(apples_eaten); // new apple method running is apple is eaten so have to update scoe board
        appleX = random.nextInt((int) (screen_width / unit_size)) * unit_size; // new apple x location random
        appleY = random.nextInt((int) (screen_height / unit_size)) * unit_size; // new apple y location random
    }

    public void move() { 
        for (int i = body_parts; i > 0; i--) { //change part location for each one by one part
            x[i] = x[i - 1]; // x location
            y[i] = y[i - 1]; // y location
        }

        switch (direction) { // change drection 
            case 'U': // if "u" snake had to go up side 
                y[0] = y[0] - unit_size;// so subtract unitsize from current location
                break;
            case 'D'://if "u" snake had to go down side 
                y[0] = y[0] + unit_size;// so add unitsize from current location
                break;
            case 'L': //if "u" snake had to go left side 
                x[0] = x[0] - unit_size; // so subtract unitsize from current location
                break;
            case 'R': //if "u" snake had to go right side 
                x[0] = x[0] + unit_size;// so add unitsize from current location
                break;
        }
    }

    public void check_apple() { //check apple and snake head location if both locations are same it means snake eat an apple 
        if ((x[0] == appleX) && (y[0] == appleY)) {
            body_parts++;
            apples_eaten++;
            new_apple();
        }
    }

    public void check_collision() { // check collision checkings for snake touchs its body parts or game borders 
        //check is head collides with body
        for (int i = body_parts; i > 0; i--) { // body parts tocuh checking
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
                case KeyEvent.VK_A:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_D:
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
