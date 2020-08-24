package com.yjq.tank;

import java.awt.Color;
import java.awt.Graphics;

/**
    * @projectName： mytank
    * @ClassName: Bullet
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月24日
    */

public class Bullet {
	
	private int x,y;
	private Dir dir;
	public static final int SPEED=6;
	private static final int WIDTH=5,HEIGHT=5;
	private boolean living=true;
	
	private TankFrame tf=null;
	
	
	public TankFrame getTf() {
		return tf;
	}

	public void setTf(TankFrame tf) {
		this.tf = tf;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	public boolean isLiving() {
		return living;
	}

	public void setLiving(boolean living) {
		this.living = living;
	}

	public Bullet(int x, int y, Dir dir,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
		}
		Color color = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(color);
		move();
		
	
	}

	
	    /**
	    * @Title: move
	    * @author 杨君权
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param 
	    * @param 
	    * @return 
	    * @throws
	    */
	    
	private void move() {
		switch(dir) {
		case LEFT:
			x-=SPEED;
			break;
		case UP:
			y-=SPEED;
			break;
		case RIGHT:
			x+=SPEED;
			break;
		case DOWN:
			y+=SPEED;
			break;
		default:break;
		}
		if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}
}
