package com.mpraski.jmonitor.adapters;

import java.util.Objects;

import com.mpraski.jmonitor.event.EventType;
import com.mpraski.jmonitor.pattern.EventOrder;

public final class EventData {
	public EventData(EventType type, String tag, String signature, String monitor, EventOrder order) {
		this.type = type;
		this.tag = tag;
		this.signature = signature;
		this.monitor = monitor;
		this.order = order;
	}

	public EventData(EventType type, String tag, String signature, String monitor, EventOrder order, String name,
			String desc, String owner) {
		this.type = type;
		this.tag = tag;
		this.signature = signature;
		this.monitor = monitor;
		this.order = order;
		this.name = name;
		this.desc = desc;
		this.owner = owner;
	}

	private final EventType type;
	private final EventOrder order;
	private final String tag;
	private final String signature;
	private final String monitor;
	private String name;
	private String desc;
	private String owner;

	public EventType getType() {
		return type;
	}

	public String getTag() {
		return tag;
	}

	public String getSignature() {
		return signature;
	}

	public String getMonitor() {
		return monitor;
	}

	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public String getOwner() {
		return owner;
	}

	@Override
	public String toString() {
		return "Type: '" + this.type + "', Tag: '" + Objects.toString(tag, "null") + "', Signature: '"
				+ Objects.toString(signature, "null") + "', Monitor: '" + Objects.toString(monitor, "null")
				+ "', Name: '" + Objects.toString(name, "null") + "', Desc: '" + Objects.toString(desc, "null")
				+ "', Owner: '" + Objects.toString(owner, "null") + "'";
	}

	public EventOrder getOrder() {
		return order;
	}
}
