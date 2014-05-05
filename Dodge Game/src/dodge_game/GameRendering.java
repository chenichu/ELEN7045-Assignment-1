/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

/**
 *
 * @author Patrick Chen
 */
public class GameRendering {
    public GameRendering(){
        
    }
    
    public void renderImages(Graphics g,Image backgroundImage, Player player, FallingObjects fallingObjects){
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(backgroundImage, 0, 0,null);
        g2d.drawImage(player.getImage(), player.getX(), player.getY(), null);
        
        for (int i=0; i < fallingObjects.GetFallingObjects().size();i++)
        {
            RainDrop rainDrop = (RainDrop) fallingObjects.GetFallingObjects().get(i);
            g2d.drawImage(rainDrop.getImage(), rainDrop.getX(), rainDrop.getY(),null);
        }
    }
}
