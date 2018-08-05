package com.example.kafkaConfig;

import java.util.Properties;

public interface IMessageProducerLifeCycle extends IMessageProducer{

	public void start();
	
	public void close();
	
	public void configure(Properties properties);
}
