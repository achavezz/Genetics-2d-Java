package com.genetics.game;

import java.awt.*;

public class OtherEnemy extends GameObject{

    private Handler handler;
    public OtherEnemy(int x, int y, ID id, Handler handler) {
        super(x, y, id);

        this.handler = handler;

        velX = 5;
        velY = 5;
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
    }

    public void render(Graphics g) {

        g.setColor(Color.blue);
        g.fillRect(x,y,32,32);
    }
}
