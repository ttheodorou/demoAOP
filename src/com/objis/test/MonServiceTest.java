package com.objis.test;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objis.service.MonService;

public class MonServiceTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testMonService() {
		
		// 1 : Chargement du conteneur Spring
		ApplicationContext context = new ClassPathXmlApplicationContext( new String[] {"springContext.xml"} );
		
		// 2 : récupération du Service
		MonService monService = (MonService) context.getBean("monService");
		
		// 3 :utilisation du service
		monService.hello("A partir de Spring !");
		
	}
}
