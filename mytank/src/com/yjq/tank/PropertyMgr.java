package com.yjq.tank;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @projectName： mytank
 * 
 * @ClassName: PropertyMgr
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 杨君权
 * @date 2020年9月14日
 */

public class PropertyMgr {
	private static Properties pro = new Properties();

	private static volatile PropertyMgr INSTANCE = null;

	static {
		try {
			pro.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private PropertyMgr() {
	}

	public static PropertyMgr getInstance() {
		if (INSTANCE == null) {
			synchronized (PropertyMgr.class) {
				if (INSTANCE == null) {
					INSTANCE = new PropertyMgr();
				}
			}
		}
		return INSTANCE;
	}

	public String getStringByKey(String key) {
		return (String) pro.getProperty(key);
	}

	public Integer getIntegerByKey(String key) {
		return Integer.parseInt((String) pro.getProperty(key));
	}

}
