/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.util.ArrayList;

/**
 *
 * file:            FallingObjects.java (a collection of falling object)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
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
    int fallingObjectType = 1;
    int minFallingObjectType = 0;
    int maxFallingObejctType = 2;
    
    public FallingObjects(){
        fallingObjects = new ArrayList();
    }
    
    public void AddFallingObjects(){
        int x = (int)(Math.random() * ((maxFallingRange - minlFallingRange) + 1));
        
        rainDrop = new 
                RainDrop(x,0,"/Images/rain_drop.png");
                    fallingObjects.add(rainDrop);
        
        int fallingObjectType = minFallingObjectType + (int)(Math.random() * 
                ((maxFallingObejctType - minFallingObjectType) + 1));
        
        //if multiple falling object exists
//        switch(fallingObjectType){
//            case 1:
//                 rainDrop = new 
//                        RainDrop(x,0,"/Images/rain_drop.png");
//                            fallingObjects.add(rainDrop);
//                break;
//            case 2:
//                  umbrella = new 
//                Umbrella(x,0,"/Images/umbrella.png");
//                    fallingObjects.add(umbrella);
//                break;
//        }
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
