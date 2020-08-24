package com.yjq.tank;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
    * @projectName： mytank
    * @ClassName: ResourceMgr
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author 杨君权
    * @date 2020年8月24日
    */

public class ResourceMgr {

	public static BufferedImage tankL,tankU,tankR,tankD;
	public static BufferedImage bulletL,bulletU,bulletR,bulletD;
	static {
		try {
			tankL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			tankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
			tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
			tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
			bulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
			bulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}