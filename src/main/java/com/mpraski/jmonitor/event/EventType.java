package com.mpraski.jmonitor.event;

public enum EventType {
	FIELD_READ, FIELD_WRITE, FIELD_READ_STATIC, FIELD_WRITE_STATIC, METHOD_CALL, RETURN, THROW, INSTANCE, INSTANCE_ARRAY, MONITOR_ENTER, MONITOR_EXIT, ANY, AND, OR, NOT
}