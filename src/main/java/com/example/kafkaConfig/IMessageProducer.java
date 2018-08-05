package com.example.kafkaConfig;

import com.example.GenericException.MessageException;

public interface IMessageProducer {

	ProducerResponse send(String topic, String key, String value) throws MessageException;
	
	ProducerResponse send(String topic, String value) throws MessageException;
	
	ProducerResponseFuture sendAsync(String topic, String key, String value);
	
	ProducerResponseFuture sendAsync(String topic, String value);
}
