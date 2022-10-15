package com.genetics.game;

import java.util.Random;

public class Spawn {
    private Handler handler;
    private HUD hud;
    private Random r = new Random();

    private int scoreKeep = 0;
    public Spawn(Handler handler, HUD hud){
        this.handler = handler;
        this.hud = hud;
    }

    public void tick(){
        scoreKeep++;
        if(scoreKeep >= 50){
            scoreKeep = 0;
            hud.setLevel(hud.getLevel()+1);

            //if (hud.getLevel() % 2 == 0 ){
            	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
            //}
        }
    }
}
