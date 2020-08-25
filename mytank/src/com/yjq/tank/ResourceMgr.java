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

	public static BufferedImage goodTankL,goodTankU,goodTankR,goodTankD;
	public static BufferedImage badTankL,badTankU,badTankR,badTankD;
	public static BufferedImage bulletL,bulletU,bulletR,bulletD;
	public static BufferedImage[] explodes=new BufferedImage[16];
	static {
		try {
//			tankL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
			goodTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
			goodTankL=ImageUtil.rotateImage(goodTankU, -90);
			goodTankR=ImageUtil.rotateImage(goodTankU, 90);
			goodTankD=ImageUtil.rotateImage(goodTankU, 180);
			
			badTankU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
			badTankL=ImageUtil.rotateImage(badTankU, -90);
			badTankR=ImageUtil.rotateImage(badTankU, 90);
			badTankD=ImageUtil.rotateImage(badTankU, 180);
//			tankR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
//			tankD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
			
//			bulletL=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
			bulletU=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
			bulletL=ImageUtil.rotateImage(bulletU, -90);
			bulletR=ImageUtil.rotateImage(bulletU, 90);
			bulletD=ImageUtil.rotateImage(bulletU, 180);
//			bulletR=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
//			bulletD=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
			
			for(int i=0;i<16;i++) {
				explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
