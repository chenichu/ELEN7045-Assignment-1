/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dodge_game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Patrick Chen
 */
public class GameEngine extends JPanel implements ActionListener {
    Player player1;
    FallingObjects fallingObjects;
    CollisionDetection collisionDetection;
    GameRendering gameRendering;
    Image backgroundImage;
    Timer time;
    
    boolean gameLost = false;
    
    public GameEngine(){
        //create new player
        player1 = new Player();
        
        fallingObjects = new FallingObjects();
        
        collisionDetection = new CollisionDetection();
        
        gameRendering =  new GameRendering();
        
        //add key listener
        addKeyListener(new KeyListener(player1));
        
        //focus on panel
        setFocusable(true);
        
        //background image
        ImageIcon i = new ImageIcon(getClass().getResource("/Images/clouds_background.png"));
        backgroundImage = i.getImage();
        
        time = new Timer(5,this);
        time.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        
        gameLost = collisionDetection.checkCollision(player1,fallingObjects);
        
        fallingObjects.SpawningFallingObject();
        
        fallingObjects.MoveandRemoveFallingObjects();      
        
        player1.move();
        
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if (gameLost) {
            System.exit(0);
        }
              
        super.paint(g);
        gameRendering.renderImages(g, backgroundImage, player1, fallingObjects);
    } 
}
