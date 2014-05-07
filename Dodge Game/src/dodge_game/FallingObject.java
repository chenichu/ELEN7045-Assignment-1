/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Image;
import java.awt.Rectangle;

/**
 *
 * file:            FallingObject.java (Abstract class that all falling object should adhere)
 * @version         0.1
 * @author          I-Chuan (Patrick) Chen
 * student No      0708886F
 * course code     ELEN 7045
 * 
 */
abstract class FallingObject {
    int num;
    
    abstract public int getX();
    abstract public int getY();
    abstract public Image getImage();
    abstract public boolean getVisible();
    abstract public void move(int num);
    abstract public Rectangle getBounds();
}
