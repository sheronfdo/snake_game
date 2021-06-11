/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;
import sun.java2d.loops.DrawLine;

/**
 *
 * @author Jamit
 */
public class game_panel extends JPanel implements ActionListener{
    //constructor of class 
    
    static final int screen_width = 600;
    static final int screen_height = 600;
    static final int unit_size = 25;
    static final int game_units = (screen_width*screen_height)/unit_size;
    static final int delay = 75;
    final int x[] =new int[game_units];
    final int y[] =new int[game_units];
    int body_parts = 6;
    int apples_eaten;
    int appleX;
    int appleY;
    char direction = 'R';
    boolean running = false;
    Timer timer;
    Random random;
    
    public game_panel() {
        random = new Random();
        this.setPreferredSize(new Dimension(screen_width, screen_height));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new my_key_adapter());
        startGame();
    }
    public void startGame(){
        new_apple();
        running = true;
        timer  = new Timer(delay, this);
        timer.start();
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        for (int i = 0; i < screen_height/unit_size; i++) {
            g.drawLine(i*unit_size, 0, i*unit_size, screen_height);
            g.drawLine(0, i*unit_size, screen_width, i*unit_size);
        }
        g.setColor(Color.red);
        g.fillOval(appleX, appleY, unit_size, unit_size);
        
        for (int i = 0; i < body_parts; i++) {
            if(i == 0){
                g.setColor(Color.green);
                g.fillRect(x[i], y[i], unit_size, unit_size);
            }else{
                g.setColor(new Color(45,180,0));
                g.fillRect(x[i], y[i], unit_size, unit_size);
            }
        }
    }
    public void new_apple(){
        appleX = random.nextInt((int)(screen_width/unit_size))*unit_size;
        appleY = random.nextInt((int)(screen_height/unit_size))*unit_size;
    }
    public void move(){
        for (int i = body_parts; i > 0; i--) {
            x[i] = x[i-1];
            y[i] = y[i-1];
        }
        
        switch (direction){
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
    public void check_apple(){
    
    }
    
    public void check_collision(){
        //check is head collides with body
        for (int i = body_parts; i > 0; i--) {
            if((x[0] == x[i]) && (y[0]==y[i])){
                running = false;
            }
        }
        //check is head touch left border
        if(x[0] < 0){
            running = false;
        }
        //check is head touch right border
        if(x[0] > screen_width){
            running = false;
        }
        //check is head touch up border
        if(y[0] < 0){
            running = false;
        }
        //check is head touch down border
        if(y[0] > screen_height){
            running = false;
        }
        if(!running){
            timer.stop();
        }
    }
    public void game_over(){
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(running){
            move();
            check_apple();
            check_collision();
        }
        repaint();
    }
    
    public class my_key_adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_LEFT:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_D:
                    if(direction != 'R'){
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_A:
                    if(direction != 'L'){
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_W:
                    if(direction != 'D'){
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_S:
                    if(direction != 'U'){
                        direction = 'D';
                    }
                    break;
                
                
            }
        }
    }
    
}
