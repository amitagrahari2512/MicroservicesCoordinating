package com.learn.ZuulApiProxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.learn.ZuulApiProxy.filters.ProxyFilter;
import com.learn.ZuulApiProxy.filters.StartPreFilter;
import com.learn.ZuulApiProxy.filters.StopPostFilter;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApiProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiProxyApplication.class, args);
	}
	
	@Bean
	public ProxyFilter proxyFilter() {
		return new ProxyFilter();
	}
	
	@Bean
	public StartPreFilter startPreFilter() {
		return new StartPreFilter();
	}
	
	@Bean
	public StopPostFilter stopPostFilter() {
		return new StopPostFilter();
	}

}
