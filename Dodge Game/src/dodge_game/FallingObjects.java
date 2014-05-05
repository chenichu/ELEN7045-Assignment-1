/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.util.ArrayList;

/**
 *
 * @author Patrick Chen
 */
public class FallingObjects {
    RainDrop rainDrop;
    static ArrayList fallingObjects;
    int minlFallingRange = 0;
    int maxFallingRange = 700; //must be less of image size
    int counter = 0;
    int minInterval = 40;
    int maxInterval = 80;
    int nextOccurance = 0;
    
    public FallingObjects(){
        fallingObjects = new ArrayList();
    }
    
    public void AddFallingObjects(){
        int x = (int)(Math.random() * ((maxFallingRange - minlFallingRange) + 1));
        
        rainDrop = new 
                RainDrop(x,0,"/Images/rain_drop.png");
        fallingObjects.add(rainDrop);        
    }
    public static ArrayList GetFallingObjects(){
        return fallingObjects;
    }
    
    public void SpawningFallingObject(){
        if(counter>=nextOccurance){
            AddFallingObjects();
            counter = 0;
            nextOccurance = minInterval + (int)(Math.random() * ((maxInterval - minInterval) + 1));
        }
        else{
            counter++;
        }
    }
    
    public void MoveandRemoveFallingObjects(){
        for (int i=0; i < fallingObjects.size();i++)
        {
             RainDrop rainDrop = (RainDrop) fallingObjects.get(i);
            if(rainDrop.getVisible()==true)
                rainDrop.move(-1);
            else
               fallingObjects.remove(i);
        }
    }
}
