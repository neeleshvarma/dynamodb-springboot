package com.javasampleapproach.dynamodb;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.javasampleapproach.dynamodb.controller.WebController;
import com.javasampleapproach.dynamodb.model.Customer;
import com.javasampleapproach.dynamodb.repo.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataDynamoDbApplicationTests {

	
	
	private static final String id = "JSA-3";
	
	private Customer customer;
	private List<Customer> customers;
	
	@Mock
	private CustomerRepository customerRepositoryMock;
	@InjectMocks
	private WebController webControllerMock;
	
	@Before
	public void setup() throws Exception {
		
		this.customer = Mockito.mock(Customer.class);
		this.customers = Arrays.asList(customer);
		Mockito.doReturn(id)
		.when(this.customer)
		.getId();
		
		
		MockitoAnnotations.initMocks(this);
	
	}
	

	
	
	@Test
	public void contextLoads() {
	}

}
