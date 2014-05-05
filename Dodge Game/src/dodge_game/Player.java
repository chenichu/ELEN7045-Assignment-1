/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * file:            Player.java (player and its responsibility)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
 */

public class Player {
    //player states
    int x, dx,y;
    Image playerImage;
    
    //constructor
    public Player(){
        ImageIcon i = new ImageIcon(getClass().getResource("/Images/player1.png"));
        playerImage = i.getImage();
        
        x=0;
        y=360;
    }
    
    //this function controls the player movement behaviour
    public void move(){
        x = x + dx;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    } 
    
    public Image getImage(){
        return playerImage;
    }  
    
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT);
        dx = -1;
        
        if (key == KeyEvent.VK_RIGHT)
            dx =1;
        
        e.consume();
    }
    
    public void keyReleased(KeyEvent e){
        int key = e.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
            dx = 0;
        
        if (key == KeyEvent.VK_RIGHT)
            dx = 0;
        
        e.consume();
    }
    
    public Rectangle getBounds(){
        return new Rectangle(x,y,53,85);
    }
    
}
