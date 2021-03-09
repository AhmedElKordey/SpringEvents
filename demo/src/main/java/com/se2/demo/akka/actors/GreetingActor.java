package com.se2.demo.akka.actors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.se2.demo.akka.services.GreetingService;

import akka.actor.UntypedActor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class GreetingActor extends UntypedActor {
	@Autowired
	GreetingService greetingService;
	
	@Override
    public void onReceive(Object message) throws Throwable {
        if (message instanceof GreetMessage) {
            String name = ((GreetMessage) message).getName();
            getSender().tell(greetingService.greet(name), getSelf());
        } else {
            unhandled(message);
        }
    }

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
    public static class GreetMessage {
        private String name;
    }
}
