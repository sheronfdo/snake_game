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
        game_panel game = new game_panel();
        score_board score = game.score;
        
        this.setResizable(false);
        this.setTitle("Cobra");
        this.setLayout(null);//create layout as null
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close operator
        this.setBounds(0, 0, 616, 739);//set frame visible location and size
        this.add(game);// add game panel to frame
        this.add(score);// add score board to frame
        this.setVisible(true);// set visibility 
        //this.pack();
        this.setLocationRelativeTo(null);
        
    }
    
}
