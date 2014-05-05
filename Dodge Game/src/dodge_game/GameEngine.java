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
    int counter = 0;
    int minInterval = 40;
    int maxInterval = 80;
    int nextOccurance = 0;
    Image backgroundImage;
    Timer time;
    
    boolean gameLost = false;
    
    public GameEngine(){
        //create new player
        player1 = new Player();
        
        fallingObjects = new FallingObjects();
        
        //add key listener
        addKeyListener(new AL());
        
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
        
        checkCollision();
        
        if(counter>=nextOccurance){
            fallingObjects.AddFallingObjects();
            counter = 0;
            nextOccurance = minInterval + (int)(Math.random() * ((maxInterval - minInterval) + 1));
        }
        else{
            counter++;
        }
        
       for (int i=0; i < fallingObjects.GetFallingObjects().size();i++)
        {
             RainDrop rainDrop = (RainDrop) fallingObjects.GetFallingObjects().get(i);
            if(rainDrop.getVisible()==true)
                rainDrop.move(-1);
            else
               fallingObjects.GetFallingObjects().remove(i);
        }
        
        
        
        player1.move();
        
        repaint();
    }
    
    @Override
    public void paint(Graphics g){
        if (gameLost) {
            System.exit(0);
        }
        
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.drawImage(backgroundImage, 0, 0,null);
        g2d.drawImage(player1.getImage(), player1.getX(), player1.getY(), null);
        
        //ArrayList fallingObjects = traffic.getLeftTraffic();
        for (int i=0; i < fallingObjects.GetFallingObjects().size();i++)
        {
            RainDrop rainDrop = (RainDrop) fallingObjects.GetFallingObjects().get(i);
            g2d.drawImage(rainDrop.getImage(), rainDrop.getX(), rainDrop.getY(),null);
        }
    }
    
     public void checkCollision(){
//        Rectangle r1 = 
//        Rectangle r2 = 
        Rectangle rPlayer = player1.getBounds();
        
         ArrayList localFallingObjects = fallingObjects.GetFallingObjects();
        for (int i=0; i < localFallingObjects.size();i++)
        {
            RainDrop rainDrop = (RainDrop) localFallingObjects.get(i);
            Rectangle rRainDrop = rainDrop.getBounds();
            
            if(rPlayer.intersects(rRainDrop)){
                gameLost = true;
                break;
            }
        }
    }
    
    private class AL extends KeyAdapter{

        @Override
        public void keyReleased(KeyEvent e){
            player1.keyReleased(e);
        }
        

        @Override
        public void keyPressed(KeyEvent e){
            player1.keyPressed(e);
        }
    }
    
    
}
