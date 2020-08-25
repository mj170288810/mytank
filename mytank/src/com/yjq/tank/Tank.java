package com.yjq.tank;

import java.awt.Graphics;
import java.util.Random;

/**
    * @projectName： mytank
    * @ClassName: Tank
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月24日
    */

public class Tank {
	
	private int x,y;
	private Dir dir=Dir.DOWN;
	public static final int SPEED=3;
	private boolean moving = true;
	private boolean living = true;
	private Random random = new Random();
	private Group group = Group.BAD;
	
	public Group getGroup() {
		return group;
	}
	public void setGroup(Group group) {
		this.group = group;
	}
	public boolean isLiving() {
		return living;
	}
	public void setLiving(boolean living) {
		this.living = living;
	}

	public static int WIDTH=ResourceMgr.goodTankU.getWidth();
	public static int HEIGHT=ResourceMgr.goodTankU.getHeight();
	TankFrame tf = null;
	public boolean isMoving() {
		return moving;
	}
	public void setMoving(boolean moving) {
		this.moving = moving;
	}
	public Tank(int x, int y, Dir dir,Group group,TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.group=group;
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
	
	    /**
	    * @Title: paint
	    * @author 杨君权
	    * @Description: TODO(这里用一句话描述这个方法的作用)
	    * @param 
	    * @param 
	    * @return 
	    * @throws
	    */
	    
	public void paint(Graphics g) {
		if(!living) {
			tf.tanks.remove(this);
		}
//		Color color = g.getColor();
		switch(dir) {
		case LEFT:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankL:ResourceMgr.badTankL, x, y, null);
			break;
		case UP:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankU:ResourceMgr.badTankU, x, y, null);
			break;
		case RIGHT:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankR:ResourceMgr.badTankR, x, y, null);
			break;
		case DOWN:
			g.drawImage(this.group==Group.GOOD?ResourceMgr.goodTankD:ResourceMgr.badTankD, x, y, null);
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
			if(!moving) {
				return;
			}	
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
			
			this.boundsCheck();
			
			if(this.group==Group.BAD && random.nextInt(100)>98) {
				this.fire();
			}
			if(this.group==Group.BAD && random.nextInt(100)>95) {
				this.randomDir();
			}
		}
			
			    
			    
			    /**
			    * @Title: boundsCheck
			    * @author 杨君权
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param 
			    * @param 
			    * @return 
			    * @throws
			    */
			    
			private void boundsCheck() {
				if(x<=5) {
					x=5;
				}else if(x>=TankFrame.GAME_WIDTH-Tank.WIDTH-5) {
					x=TankFrame.GAME_WIDTH-Tank.WIDTH-5;
				}
				
				if(y<=30) {
					y=30;
				}else if(y>=TankFrame.GAME_HEIGHT-Tank.HEIGHT-5) {
					y=TankFrame.GAME_HEIGHT-Tank.HEIGHT-5;
				}
				
			}
				/**
			    * @Title: randomDir
			    * @author 杨君权
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param 
			    * @param 
			    * @return 
			    * @throws
			    */
			    
			private void randomDir() {
				this.dir=Dir.values()[random.nextInt(4)];
				
			}
				/**
			    * @Title: fire
			    * @author 杨君权
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param 
			    * @param 
			    * @return 
			    * @throws
			    */
			    
			public void fire() {
				int bX=0;
				int bY=0;
				bX=this.x+Tank.WIDTH/2-Bullet.WIDTH/2;
				bY=this.y+Tank.HEIGHT/2-Bullet.HEIGHT/2;
				
				tf.bullets.add(new Bullet(bX,bY,this.dir,this.group,this.tf));
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
				    
				public void die() {
					this.living=false;
				}
	
	

}
