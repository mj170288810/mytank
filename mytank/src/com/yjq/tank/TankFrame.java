package com.yjq.tank;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
    * @projectName： mytank
    * @ClassName: TankFrame
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月21日
    */

public class TankFrame extends Frame{

	private int x=200,y=200;
	public TankFrame(){
		this.setSize(1000, 800);
		this.setResizable(false);
		this.setTitle("tank war");
		this.setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
			
			    /**
			    * @Title: windowClosing
			    * @author 杨君权
			    * @Description: TODO(这里用一句话描述这个方法的作用)
			    * @param 
			    * @param 
			    * @return 
			    * @throws
			    */
			    
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
		});
		
		this.addKeyListener(new MyKeyListener());
		
	}

	@Override
	public void paint(Graphics g) {
		System.out.print("paint");
		g.fillRect(x, y, 50, 50);
		x+=1;
//		y+=10;
	}
	
	class MyKeyListener extends KeyAdapter{
		
		boolean bL=false;
		boolean bR=false;
		boolean bU=false;
		boolean bD=false;
		
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.print("key pressed");
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
//			x+=50;
//			repaint();
		}

		

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.print("key released");
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
					default:break;
			}
		}
	}
	
}
