/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author Patrick Chen
 */
public class KeyListener extends KeyAdapter{
    
    Player player;
    
    public KeyListener(Player player1){
        player = player1;
    }
    
     @Override
        public void keyReleased(KeyEvent e){
            player.keyReleased(e);
        }
        

        @Override
        public void keyPressed(KeyEvent e){
            player.keyPressed(e);
        }
}
