package com.yjq.tank;

import java.awt.Graphics;
import java.awt.Rectangle;

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
	private Group group = Group.BAD;
	
	public Rectangle rectangle=new Rectangle();
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public static int WIDTH=ResourceMgr.bulletD.getWidth();
	public static int HEIGHT=ResourceMgr.bulletD.getHeight();
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

	public Bullet(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group=group;
		this.tf = tf;
		rectangle.x=this.x;
		rectangle.y=this.y;
		rectangle.height=HEIGHT;
		rectangle.width=WIDTH;
	}
	
	public void paint(Graphics g) {
		if(!living) {
			tf.bullets.remove(this);
		}
		
		switch(dir) {
		case LEFT:
			g.drawImage(ResourceMgr.bulletL, x, y, null);
			break;
		case UP:
			g.drawImage(ResourceMgr.bulletU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(ResourceMgr.bulletR, x, y, null);
			break;
		case DOWN:
			g.drawImage(ResourceMgr.bulletD, x, y, null);
			break;
		}
		
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
		//update rectangle
		rectangle.x=this.x;
		rectangle.y=this.y;
		if(x<0 || y<0 || x>TankFrame.GAME_WIDTH || y>TankFrame.GAME_HEIGHT) {
			living = false;
		}
	}

		
		    /**
		    * @Title: collideWith
		    * @author 杨君权
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param 
		    * @param 
		    * @return 
		    * @throws
		    */
		    
		public void collideWith(Tank tank) {
			if(this.group==tank.getGroup()) {
				return;
			}
			if(rectangle.intersects(tank.rectangle)) {
				this.die();
				tank.die();
				int eX=tank.getX()+Tank.WIDTH/2-Bullet.WIDTH/2;
				int eY=tank.getY()+Tank.HEIGHT/2-Bullet.HEIGHT/2;
				tf.explodes.add(new Explode(eX, eY, tf));
			}
		}

			
			    /**
			    * @Title: die
			    * @author 杨君权
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param 
			    * @param 
			    * @return 
			    * @throws
			    */
			    
			private void die() {
				this.living=false;
			}
}
