/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * file:            RainDrop.java (raindrop and its responsibility)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
 */
public class RainDrop extends FallingObject{
    //rain drop states
    int x, y, dy;
    
    Image rainDropImage;
    boolean visible;
    
    //contstructor
    public RainDrop(int startX, int startY, String imageLocation){
        x = startX;
        y = startY;
        visible = true;
        
        ImageIcon l = new ImageIcon(getClass().getResource(imageLocation));
        rainDropImage = l.getImage();
    }
    
    /**
     * 
     * @return x co-ordinates of raindrop
     */
    @Override
    public int getX(){
        return x;
    }
    
    /**
     * 
     * @return y co-ordinates of raindrop
     */
    @Override
    public int getY(){
        return y;
    }
    
    /**
     * 
     * @return raindrop visibility
     */
    @Override
    public boolean getVisible(){
        return visible;
    }
    
    /**
     * 
     * @return image of raindrop
     */
    @Override
    public Image getImage(){
        return rainDropImage;
    }
    
    //rain drop movement behaviour
    @Override
    public void move(int dy){
        if(y>500){
            visible = false;
        }
        y = y - dy;
    }
    
    @Override
    public Rectangle getBounds(){
        return new Rectangle(x,y,15,15);
    }
    
}
