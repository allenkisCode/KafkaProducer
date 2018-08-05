package com.example.kafkaConfig;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.kafka.clients.producer.RecordMetadata;

public class ProducerResponseFuture implements Future<RecordMetadata> {

	private RecordMetadata data;
	
	@Override
	public boolean cancel(boolean mayInterruptIfRunning) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProducerResponseFuture(RecordMetadata data) {
		this.data = data;
	}

	@Override
	public boolean isCancelled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDone() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public RecordMetadata get() throws InterruptedException, ExecutionException {
		return data;
	}

	@Override
	public RecordMetadata get(long timeout, TimeUnit unit)
			throws InterruptedException, ExecutionException, TimeoutException {
		return data;
	}

	
}
