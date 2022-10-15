package com.genetics.game;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import com.genetics.game.Game.STATE;

public class Menu extends MouseAdapter {
    private Game game;
    private Handler handler;
    private Random r = new Random();
    private HUD hud;

    public Menu(Game game, Handler handler, HUD hud){
        this.game = game;
        this.handler = handler;
        this.hud = hud;

    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();

        if(game.gameState == STATE.Menu) {
	        //play button
	        if(mouseOver(mx, my, 375, 150, 200, 64)){
	            game.gameState = Game.STATE.Game;
	            handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
	        }
	
	        //quit button
	        if(mouseOver(mx, my, 375, 300, 200, 64)){
	            System.exit(1);
	        }
        }
        
        if(game.gameState == STATE.End) {
	        //try again button
	        if(mouseOver(mx, my, 400, 350, 200, 64)){
	        	game.gameState = Game.STATE.Game;
	        	hud.setScore(0);
                hud.setLevel(1);
	        	handler.addObject(new Player(Game.WIDTH/2-32,Game.HEIGHT/2-32, ID.Player, handler));
	        	handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
	            handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, 1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
                handler.addObject(new BasicEnemy(r.nextInt(Game.WIDTH-50), 0, ID.BasicEnemy, handler, -1));
	        }
        }
    }

    public void mouseReleased(MouseEvent e) {

    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height){
        if(mx > x && mx < x + width){
            if(my > y && my < y+height){
                return true;
            }else return false;
        }else return false;
    }

    public void tick(){

    }

    public void render(Graphics g){
        if(game.gameState == Game.STATE.Menu){
            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Menu", 400, 70);

            g.setFont(fnt2);
            g.drawRect(375,150,200,64);
            g.drawString("Play", 440, 190);

            g.setColor(Color.white);
            g.drawRect(375,300,200,64);
            g.drawString("Quit", 440, 340);
        }else if(game.gameState == Game.STATE.End){
            handler.objects.clear();

            Font fnt = new Font("arial", 1, 50);
            Font fnt2 = new Font("arial", 1, 30);
            Font fnt3 = new Font("arial", 1, 20);

            g.setFont(fnt);
            g.setColor(Color.white);
            g.drawString("Game over", 375, 70);

            g.setFont(fnt2);
            g.drawString("You lose with a score of: " + hud.getScore(), 300, 200);

            g.setFont(fnt3);
            g.drawRect(400, 350, 200, 64);
            g.drawString("Try Again", 450, 390);
        }
    }
}
