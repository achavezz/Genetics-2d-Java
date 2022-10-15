package com.genetics.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class BasicEnemy extends GameObject{

    private Handler handler;
    public BasicEnemy(int x, int y, ID id, Handler handler, int i) {
        super(x, y, id);

        this.handler = handler;
        getEnemyImage();
        velX = 5*i;
        velY = 5;
    }
    
    public void getEnemyImage() {
    	try {
    		p1 = ImageIO.read(getClass().getResourceAsStream("/pic/T1.png"));
    		p2 = ImageIO.read(getClass().getResourceAsStream("/pic/T2.png"));
    		
    	}catch(IOException e) {
    		e.printStackTrace();
    	}
    }

    public Rectangle getBounds(){
        return new Rectangle(x, y, 32, 32);
    }

    public void tick() {
        x += velX;
        y += velY;

        if(y >= Game.HEIGHT - 50){
           handler.removeObject(this);
        }

        if(x <= 0 || x >= Game.WIDTH - 50){
            velX *= -1;
        }
        
        spriteCounter++;
        if(spriteCounter > 15) {
        	if(spriteNum == 1) spriteNum = 2;
        	else if(spriteNum ==2 ) spriteNum = 1;
        	spriteCounter = 0;
        }
    }

    public void render(Graphics g) {
    	BufferedImage image = null;
    	if(spriteNum == 1) image = p1;
        if(spriteNum == 2) image = p2;
        g.drawImage(image, x, y, 32, 32, null);
    }
}
