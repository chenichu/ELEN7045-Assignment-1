/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import javax.swing.JFrame;

/**
 *
 * file:            DodgeGame.java (game runs under this class)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
 */

public class DodgeGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JFrame frame = new JFrame("Dodge Game");
        frame.add(new GameEngine());
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setVisible(true);
    }
    
}
