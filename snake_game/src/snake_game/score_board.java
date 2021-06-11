/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

/**
 *
 * @author Jamit
 */
public class score_board extends JPanel{
    //constructor of class 
    score_board(){
        this.setPreferredSize(new Dimension(600, 150));
        this.setBackground(Color.BLACK);
    }
}
