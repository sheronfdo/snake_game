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
        game_panel game = new game_panel(); //create object for game panel
        score_board score = game.score; // create object score_board type but initialized score object of score_board type in created game_panel class
        
        this.setResizable(false); // set resizability
        this.setTitle("Cobra"); // set title for programme
        this.setLayout(null);//create layout as null
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//set close operator
        this.setBounds(1500, 0, 616, 739);//set frame visible location and size
        this.add(game);// add game panel to frame
        this.add(score);// add score board to frame
        this.setVisible(true);// set visibility 
        //this.pack();
        //this.setLocationRelativeTo(null);
        
    }
    
}
