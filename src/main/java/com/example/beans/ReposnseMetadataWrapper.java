package com.example.beans;



public class ReposnseMetadataWrapper {

	private long offset;
	private long timestamp;
	private int serializedKeySize;
	private int serializedValueSize;
	private int topicPartition;
	//private volatile Long checksum;
	public long getOffset() {
		return offset;
	}
	public void setOffset(long offset) {
		this.offset = offset;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	public int getSerializedKeySize() {
		return serializedKeySize;
	}
	public void setSerializedKeySize(int serializedKeySize) {
		this.serializedKeySize = serializedKeySize;
	}
	public int getSerializedValueSize() {
		return serializedValueSize;
	}
	public void setSerializedValueSize(int serializedValueSize) {
		this.serializedValueSize = serializedValueSize;
	}
	public int getTopicPartition() {
		return topicPartition;
	}
	public void setTopicPartition(int topicPartition) {
		this.topicPartition = topicPartition;
	}
	/*public Long getChecksum() {
		return checksum;
	}
	public void setChecksum(Long checksum) {
		this.checksum = checksum;
	}*/

	
}
