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
    main_frame(){
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(1500, 0, 600, 700);
        this.add(new game_panel());
        this.add(new score_board());
        this.setVisible(true);
    }
    
}
