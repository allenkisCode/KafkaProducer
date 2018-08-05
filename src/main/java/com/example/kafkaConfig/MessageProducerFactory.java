package com.example.kafkaConfig;

import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.example.GenericException.MessageException;

@Component
public class MessageProducerFactory {

	private static final MessageProducerFactory INSTANCE = new MessageProducerFactory();
	//if its possible creating producer for each topic 
	
	private static Map<String,MessageProducerImpl> producers = new ConcurrentHashMap<>();
	
	private MessageProducerFactory(){
		
	}
	
	public void close(){
		producers.forEach((k,v) -> {
			v.close();
		});
		producers.clear();

	}
	
	public static MessageProducerFactory getMessageProducerFactory(){
		return INSTANCE;
	}
	public static MessageProducerImpl getProducer(String topic){
		return producers.get(topic);
	}
	
	public void init(String topic) throws MessageException{
		
		if(producers.get(topic) == null){
			URL url = ClassLoader.getSystemResource("application.properties");
			Properties props = new Properties();
			try{
				props.load(url.openStream());
			}catch(Exception e){
				throw new MessageException("could not load property file");
			}
			MessageProducerImpl producer = new MessageProducerImpl();
			producer.configure(props);
			producer.start();
			producers.put(topic, producer);
		}
	}
}
