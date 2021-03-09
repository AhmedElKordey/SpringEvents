package com.se2.demo;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextRefreshedEvent;

class SpringBuiltInEventsListener implements ApplicationListener<SpringApplicationEvent>{

	@Override
	public void onApplicationEvent(SpringApplicationEvent event) {
		// Level of application
		if(event.getClass().equals(ApplicationStartingEvent.class)) {
			//TODO
		}
		
		if (event.getClass().equals(ApplicationPreparedEvent.class) ) {
			//TODO
		}
		
		if (event.getClass().equals(ApplicationReadyEvent.class) ) {
			//TODO
		}
		
		if (event.getClass().equals(ApplicationFailedEvent.class) ) {
			//TODO
		}
		
		// Level of Environment
		if (event.getClass().equals(ApplicationEnvironmentPreparedEvent.class) ) {
			//TODO
		}
		
		// Level of Context 
		if (event.getClass().equals(ApplicationContextEvent.class) ) {
			//TODO
		}
		
		if (event.getClass().equals(ContextRefreshedEvent.class) ) {
			//TODO
		}

	}

}