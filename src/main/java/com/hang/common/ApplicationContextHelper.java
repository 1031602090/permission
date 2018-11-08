package com.hang.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHelper implements ApplicationContextAware {
	private ApplicationContext applicationContext;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

		this.applicationContext = applicationContext;
	}

	public  <T> T popBean(Class clazz){
		if(applicationContext==null) return null;
		return (T) applicationContext.getBean(clazz);
	}

	public <T> T popBean(String beanName,Class clazz){
		if(applicationContext==null) return null;
		return (T) applicationContext.getBean(beanName,clazz);
	}
}