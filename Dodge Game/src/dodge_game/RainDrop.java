/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;

/**
 *
 * @author Patrick Chen
 */
public class RainDrop {
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
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public boolean getVisible(){
        return visible;
    }
    
    public Image getImage(){
        return rainDropImage;
    }
    
    //rain drop movement behaviour
    public void move(int dy){
        if(y>500){
            visible = false;
        }
        y = y - dy;
    }
    
}
