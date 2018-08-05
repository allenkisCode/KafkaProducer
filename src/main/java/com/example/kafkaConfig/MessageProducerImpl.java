package com.example.kafkaConfig;

import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.example.GenericException.MessageException;

public class MessageProducerImpl implements IMessageProducerLifeCycle{
	
	private Properties properties;
	
	private KafkaProducer<String, String> producer;

	@Override
	public ProducerResponse send(String topic, String key, String value) throws MessageException {
		
		RecordMetadata recordMetadata = null;
		try {
			recordMetadata = producer.send(createProducerRecord(topic, key, value)).get();
		} catch (InterruptedException | ExecutionException e) {
				throw new MessageException(e);
		}
		return new ProducerResponse(recordMetadata);
	}

	private ProducerRecord<String, String> createProducerRecord(String topic, String key, String value) {
		if(key != null)
			return new ProducerRecord<>(topic, value);
		return new ProducerRecord<String, String>(topic, key, value);
	}

	@Override
	public ProducerResponse send(String topic, String value) throws MessageException {
		return send(topic, null , value);
		
	}

	@Override
	public ProducerResponseFuture sendAsync(String topic, String key, String value) {
		Future<RecordMetadata> response = null;
		response = producer.send(createProducerRecord(topic, key, value));
		try {
			return new ProducerResponseFuture(response.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public ProducerResponseFuture sendAsync(String topic, String value) {
		return sendAsync(topic, null, value);
		
	}

	@Override
	public void start() {
		producer = new KafkaProducer<>(properties);
		
	}

	@Override
	public void close() {
		
		producer.flush();
		producer.close();
		
	}

	@Override
	public void configure(Properties properties) {
		this.properties = properties;
		//if some other properties are needed configure here
		
	}

}
