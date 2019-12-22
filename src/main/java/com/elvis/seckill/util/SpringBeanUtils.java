package com.elvis.seckill.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*
* 获取上下文对象
* */

public class SpringBeanUtils implements ApplicationContextAware
{
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext appContext) throws BeansException
	{
		applicationContext = appContext;
	}

	public static Object getBean(String name)
	{
		return applicationContext.getBean(name);
	}

}
