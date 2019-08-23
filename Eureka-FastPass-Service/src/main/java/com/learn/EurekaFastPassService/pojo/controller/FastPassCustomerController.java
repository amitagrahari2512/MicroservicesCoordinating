package com.learn.EurekaFastPassService.pojo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.learn.EurekaFastPassService.pojo.FastPassCustomer;

@RestController
public class FastPassCustomerController {
	List<FastPassCustomer> customerList = new ArrayList<>();
	
	public FastPassCustomerController() {
		FastPassCustomer fc1 = new FastPassCustomer("100", "Amit", "12345", new BigDecimal("100"));
		FastPassCustomer fc2 = new FastPassCustomer("101", "Anu", "1234567", new BigDecimal("101"));
		FastPassCustomer fc3 = new FastPassCustomer("102", "Abhi", "123456789", new BigDecimal("102"));
		
		customerList.add(fc1);
		customerList.add(fc2);
		customerList.add(fc3);
	}
	
	@GetMapping(path = "/fastPass" , params = {"fastPassId"})
	public FastPassCustomer getFastPassById(@RequestParam String fastPassId) {
		Predicate<FastPassCustomer> p = c -> c.getFastPassId().equals(fastPassId);
		FastPassCustomer customer = customerList.stream().filter(p).findFirst().get();
		
		return customer;
	}
	
	@GetMapping(path = "/fastPass" , params = {"fastPassPhone"})
	public FastPassCustomer getFastPassByPhone(@RequestParam String fastPassPhone) {
		Predicate<FastPassCustomer> p = c -> c.getFastPassPhone().equals(fastPassPhone);
		FastPassCustomer customer = customerList.stream().filter(p).findFirst().get();
		
		return customer;
	}
}
