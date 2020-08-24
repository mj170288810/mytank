package com.yjq.tank;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
    * @projectName： mytank
    * @ClassName: TankFrame
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月21日
    */

public class TankFrame extends Frame{

	Tank mytank = new Tank(100,500,Dir.DOWN,Group.GOOD,this);
//	Bullet b=new Bullet(300,300,Dir.DOWN);
	List<Bullet> bullets=new ArrayList<>();
	List<Tank> tanks=new ArrayList<>();
	Explode e = new Explode(100, 100, this);
	public static final int GAME_WIDTH=1000,GAME_HEIGHT=800;
	public TankFrame(){
		this.setSize(GAME_WIDTH, GAME_HEIGHT);
		this.setResizable(false);
		this.setTitle("tank war");
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new MyKeyListener());
		
	}

	
	Image offScreenImage = null;

	@Override
	public void update(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
		}
		Graphics gOffScreen = offScreenImage.getGraphics();
		Color c = gOffScreen.getColor();
		gOffScreen.setColor(Color.BLACK);
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
		gOffScreen.setColor(c);
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	@Override
	public void paint(Graphics g) {
//		System.out.println("paint");
		Color color = g.getColor();
		g.setColor(Color.WHITE);
		g.drawString("子弹的数量："+bullets.size(), 10, 60);
		g.drawString("坦克的数量："+tanks.size(), 10, 100);
		g.setColor(color);
		mytank.paint(g);
		for(int i=0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		for(int i=0;i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		for(int i=0;i<bullets.size();i++) {
			for(int j=0;j<tanks.size();j++) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
		e.paint(g);
//		x+=1;
//		y+=10;
	}
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bL=false;
		boolean bR=false;
		boolean bU=false;
		boolean bD=false;
		
		@Override
		public void keyPressed(KeyEvent e) {
//			System.out.print("key pressed");
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_LEFT:
					bL=true;
					break;
				case KeyEvent.VK_RIGHT:
					bR=true;
					break;
				case KeyEvent.VK_UP:
					bU=true;
					break;
				case KeyEvent.VK_DOWN:
					bD=true;
					break;
					default:break;
			}
			setMainTankDir();
//			x+=50;
//			repaint();
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
//			System.out.print("key released");
			int keyCode = e.getKeyCode();
			switch (keyCode) {
				case KeyEvent.VK_LEFT:
					bL=false;
					break;
				case KeyEvent.VK_RIGHT:
					bR=false;
					break;
				case KeyEvent.VK_UP:
					bU=false;
					break;
				case KeyEvent.VK_DOWN:
					bD=false;
					break;
				case KeyEvent.VK_CONTROL:
					mytank.fire();
				default:break;
			}
			setMainTankDir();
		}

		

		
		    /**
		    * @Title: setMainTankDir
		    * @author 杨君权
		    * @Description: TODO(这里用一句话描述这个方法的作用)
		    * @param 
		    * @param 
		    * @return 
		    * @throws
		    */
		    
		private void setMainTankDir() {
			if(!bL && !bU && !bR && !bD) {
				mytank.setMoving(false);
			}else {
				mytank.setMoving(true);
				if(bL) {
					mytank.setDir(Dir.LEFT);
				}
				if(bU) {
					mytank.setDir(Dir.UP);
				}
				if(bR) {
					mytank.setDir(Dir.RIGHT);
				}
				if(bD) {
					mytank.setDir(Dir.DOWN);
				}
			}
			
			
			
		}



		
	}
	
}
