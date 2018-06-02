package com.mpraski.jmonitor;

import java.util.ArrayList;
import java.util.List;

import com.mpraski.jmonitor.pattern.EventPattern;
import com.mpraski.jmonitor.pattern.EventPatternDefinitions;

public class TestDefinitions implements EventPatternDefinitions {

	@Override
	public List<EventPattern> getEventPatterns() {
		EventPattern p9 = EventPattern.onFieldRead().of("lel").from("lol").doBefore("com.wut.dut.monitor_1");

		final List<EventPattern> patterns = new ArrayList<>();
		patterns.add(p9);

		return patterns;
	}

}
