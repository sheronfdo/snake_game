/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import static snake_game.game_panel.unit_size;

/**
 *
 * @author Jamit
 */
public class score_board extends JPanel{
    //constructor of class 
    score_board(){
        this.setBounds(0, game_panel.screen_height, game_panel.screen_width, 100);
        this.setBackground(Color.green);
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // get super access for this graphics
        draw(g); // call and pass graphic object to method draw
    }

    public void draw(Graphics g) {
    
    }
}