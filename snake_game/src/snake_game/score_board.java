/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static snake_game.game_panel.screen_height;
import static snake_game.game_panel.screen_width;

/**
 *
 * @author Jamit
 */
public class score_board extends JPanel{
    //constructor of class 
    static int eatenapples; // create variable for store count of eaten apples
    JLabel scores; // create label for score board
    score_board(){
        scores = new JLabel();
        //scores.setBounds(25, 25, 100, 50);
        scores.setFont(new Font("Ink Free",Font.BOLD, 60)); // set font as i like
        //scores.setBackground(Color.red);
        scores.setOpaque(true);// set opaqu for apply my ui design
        this.setBounds(0, game_panel.screen_height, game_panel.screen_width, 100); //set bounds for panel (location)
        this.add(scores); // add scores label to panel
        //this.setBackground(Color.green);
    }
    public void setscore(int i){
        eatenapples = i; // reassign eaten apple count to refresh score board
        scores.setText("SCORES : "+Integer.toString(eatenapples*5)); // display scores
    }
}