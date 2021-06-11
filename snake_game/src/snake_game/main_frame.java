/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package snake_game;

import javax.swing.JFrame;

/**
 *
 * @author Jamit
 */
public class main_frame extends JFrame{
    //constructor of class 
    main_frame(){
        this.setLayout(null);//create layout as null
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close operator
        this.setBounds(1500, 0, 600, 700);//set frame visible location and size
        this.add(new game_panel());// add game panel to frame
        this.add(new score_board());// add score board to frame
        this.setVisible(true);// set visibility 
    }
    
}
