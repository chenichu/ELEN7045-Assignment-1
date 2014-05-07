/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Rectangle;
import java.util.ArrayList;

/**
 *
 * file:            CollisionDetection.java (check if objects collide)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
 */
public class CollisionDetection {
    
    public CollisionDetection(){
        
    }
    
    /**
     * 
     * @return true if objects collide else false
     */
    public Boolean checkCollision(Player player, FallingObjects fallingObjects){
        Rectangle rPlayer = player.getBounds();
        
         ArrayList localFallingObjects = fallingObjects.GetFallingObjects();
        for (int i=0; i < localFallingObjects.size();i++)
        {
            RainDrop rainDrop = (RainDrop) localFallingObjects.get(i);
            Rectangle rRainDrop = rainDrop.getBounds();
            
            if(rPlayer.intersects(rRainDrop)){
                return true;
            }
        }
        return false;
    }
}
