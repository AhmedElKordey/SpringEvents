package com.se2.demo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@SpringBootApplication
@EnableAsync
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}



@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@javax.persistence.Entity
class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id ;
	String name;
	String email;
	String authoToken;
	
	public Customer(String name , String email) {
		this.name = name ; 
		this.email = email;
	}
	
	public boolean isAutho() {
		return StringUtils.isNotBlank(this.authoToken);
	}
}


interface CustomerRepository extends JpaRepository<Customer, Long>{}


@Service
class CustomerService {
	@Autowired
	CustomerRepository customerRepository ;
	
	@Autowired
	ApplicationEventPublisher applicationEventPublisher ;
	
	@Transactional
	public Customer createCustomer ( String name , String email) {
		Customer customer = customerRepository.save(new Customer(name, email));
		applicationEventPublisher.publishEvent(new CustomerEvent(this, customer.getId()));
		return customer ;
	}
}


@Service
class TokenGenrator{
	@Autowired
	CustomerRepository customerRepository ;
		
	public void GenerateToken(Customer customer) {
		String token = String.valueOf(customer.hashCode());
		customer.setAuthoToken(token);
		customerRepository.save(customer);
	}
}


@Getter
class CustomerEvent extends ApplicationEvent{
	Long id;
	public CustomerEvent(Object source , Long id) {
		super(source);
		this.id = id ;
	}
}


@Component
class CustomerActivation {
	@Autowired
	CustomerRepository customerRepository ;
	
	@Autowired
	TokenGenrator tokenGenrator;
	
	@TransactionalEventListener
	@Async
	public  void activateCustomer(CustomerEvent event) {
		Customer customer = customerRepository.findOne(event.getId());
		tokenGenrator.GenerateToken(customer);
	}
}