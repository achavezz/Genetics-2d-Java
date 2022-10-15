package com.genetics.game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Player extends GameObject{

    Handler handler;

    public Player(int x, int y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
        getPlayerImage();
    }
    
    public void getPlayerImage() {
    	
    	try {
    		p1 = ImageIO.read(getClass().getResourceAsStream("/pic/C1.png"));
    		p2 = ImageIO.read(getClass().getResourceAsStream("/pic/C2.png"));
    		
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

        x = Game.clamp(x, 0, Game.WIDTH-50);
        y = Game.clamp(y, 0, Game.HEIGHT-70);
        
        spriteCounter++;
        if(spriteCounter > 15) {
        	if(spriteNum == 1) spriteNum = 2;
        	else if(spriteNum ==2 ) spriteNum = 1;
        	spriteCounter = 0;
        }
        
        collision();
    }

    private void collision(){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempObject = handler.objects.get(i);

            if(tempObject.getId() == ID.BasicEnemy){
                if(getBounds().intersects(tempObject.getBounds())){
                    //collision code
                    HUD.HEALTH -= 2;

                }
            }
        }
    }

    public void render(Graphics g) {
        BufferedImage image = null;
        if(spriteNum == 1) image = p1;
        if(spriteNum == 2) image = p2;
        g.drawImage(image, x, y, 32, 32, null);
    }
}
