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
    static final int unit_size = 50;
    static final int game_units = (screen_width*screen_height)/unit_size;
    static final int delay = 75;
    final int x[] =new int[game_units];
    final int y[] =new int[game_units];
    int body_parts = 6;
    int apples_eaten;
    int appleX;
    int appleY;
    char direction = 'u';
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
       
    }
    public void new_apple(){
    
    }
    public void move(){
    
    }
    public void check_apple(){
    
    }
    
    public void check_collision(){
    
    }
    public void game_over(){
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public class my_key_adapter extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
        }
    }
    
}
