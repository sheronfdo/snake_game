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
    static int eatenapples;
    JLabel scores;
    score_board(){
        scores = new JLabel("scores");
        //scores.setBounds(25, 25, 100, 50);
        scores.setFont(new Font("Ink Free",Font.BOLD, 60));
        //scores.setBackground(Color.red);
        scores.setOpaque(true);
        this.setBounds(0, game_panel.screen_height, game_panel.screen_width, 100);
        this.add(scores);
        //this.setBackground(Color.green);
    }
    public void setscore(int i){
        eatenapples = i;
        scores.setText("SCORES : "+Integer.toString(eatenapples*5));
    }
}