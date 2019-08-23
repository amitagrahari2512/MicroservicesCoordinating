package com.example.EurekaFastPassConsoleRabbitMqCustomSource.publisher;

import java.math.BigDecimal;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.InboundChannelAdapter;
import org.springframework.integration.annotation.Poller;
import org.springframework.integration.core.MessageSource;
import org.springframework.messaging.support.MessageBuilder;

import com.example.EurekaFastPassConsoleRabbitMqCustomSource.pojo.FastPassCustomer;

@EnableBinding(TollSource.class)
public class TollPublisher {

	@Bean
	@InboundChannelAdapter(channel = "fastpassTollChannel" , poller = @Poller(fixedDelay = "2000"))
	public MessageSource<FastPassCustomer> sendTollCharge() {
		return () -> MessageBuilder.withPayload(new FastPassCustomer("101", "Amit A", "123456", new BigDecimal("1.23"))).build();
	}
}
