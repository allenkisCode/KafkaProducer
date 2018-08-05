package com.example.kafkaConfig;

import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerResponse {

	private RecordMetadata data;

	public ProducerResponse(RecordMetadata data) {
		this.data = data;
	}
	
	public long offset(){
		return data.offset();
	}
	
	public String topic(){
		return data.topic();
	}
	
	public int partition(){
		return data.partition();
	}
	
}
