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
 * @author Patrick Chen
 */
public class CollisionDetection {
    
    public CollisionDetection(){
        
    }
    
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
