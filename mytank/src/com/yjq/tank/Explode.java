package com.yjq.tank;

import java.awt.Graphics;

/**
    * @projectName： mytank
    * @ClassName: Explode
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月24日
    */

public class Explode {
	public static int WIDTH = ResourceMgr.explodes[0].getWidth();
	public static int HEIGHT = ResourceMgr.explodes[0].getHeight();
	
	private int x,y;
	private boolean living = false;
	
	TankFrame tf=null;
	
	private int step=0;

	public Explode(int x, int y, TankFrame tf) {
		super();
		this.x = x;
		this.y = y;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.explodes[step++], x, y, null);
		if(step>=ResourceMgr.explodes.length) {
			step=0;
		}
	}

}
