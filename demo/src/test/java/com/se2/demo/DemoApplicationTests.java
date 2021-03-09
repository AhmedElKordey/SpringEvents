package com.se2.demo;

import static akka.pattern.Patterns.ask;
import static com.se2.demo.akka.config.SpringExtension.SPRING_EXTENSION_PROVIDER;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import com.se2.demo.akka.actors.GreetingActor;
import com.se2.demo.akka.config.AkkaConfiguration;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DemoApplicationTests  {

//	@Autowired
//	CustomerService customerService;
//
//	@Autowired
//	CustomerRepository customerRepo;

//	@Test
//	public void customerCreatedSucf() {
//		Customer savedCustomer = customerService.createCustomer("Ahmed Talaat", "ahmed.talaat@gmail.com");
//		Customer retrivedCustomer = customerRepo.findOne(savedCustomer.getId());
//		assertEquals(savedCustomer, retrivedCustomer);
//		assertFalse(retrivedCustomer.isAutho());
//	}
//
//	@Test
//	public void customerAuthoSucf() {
//		Customer savedCustomer = customerService.createCustomer("Ahmed Talaat", "ahmed.talaat@gmail.com");
//		Customer retrivedCustomer = customerRepo.findOne(savedCustomer.getId());
//		assertTrue(retrivedCustomer.isAutho());
//	}
//
//	@Test
//	public void customerAuthoWithThreadSucf() {
//		Customer savedCustomer = customerService.createCustomer("Ahmed Talaat", "ahmed.talaat@gmail.com");
//		Customer retrivedCustomer = customerRepo.findOne(savedCustomer.getId());
//		await().atMost(5, SECONDS).until(() -> {
//			customerHasToken(savedCustomer.getId());
//		});
//	}
//	
//	private boolean customerHasToken(long id) {
//		Customer retrivedCustomer = customerRepo.findOne(id);
//		return retrivedCustomer.isAutho();
//	}
	
	
}
