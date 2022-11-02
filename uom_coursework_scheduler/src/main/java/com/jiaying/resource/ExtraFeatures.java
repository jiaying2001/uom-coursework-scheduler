package com.jiaying.resource;

import lombok.Data;

@Data
public abstract class ExtraFeatures {
	private long order=0;
	private int TimeEstimate=2;
	
	public long getOrder() {
		return order;
	}
	public void setOrder(long order) {
		this.order = order;
	}
	public int getTimeEstimate() {
		return TimeEstimate;
	}
	public void setTimeEstimate(int timeEstimate) {
		TimeEstimate = timeEstimate;
	}
}
