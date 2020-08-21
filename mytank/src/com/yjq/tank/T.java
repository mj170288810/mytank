package com.yjq.tank;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
    * @projectName： mytank
    * @ClassName: T
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月21日
    */

public class T {

	public static void main(String[] args) throws InterruptedException {
		TankFrame tf=new TankFrame();
		while (true) {
			Thread.sleep(50);
			tf.repaint();
		}
	}
}
