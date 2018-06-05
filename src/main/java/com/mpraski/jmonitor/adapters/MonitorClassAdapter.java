package com.mpraski.jmonitor.adapters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.commons.LocalVariablesSorter;

import com.mpraski.jmonitor.event.EventType;
import com.mpraski.jmonitor.pattern.EventPatternMatcher;

public class MonitorClassAdapter extends ClassVisitor implements Opcodes {

	private final List<EventPatternMatcher> matchers;
	private final Map<EventType, List<EventPatternMatcher>> mapped;
	private final Map<EventPatternMatcher, Boolean> matchesFrom;
	private final List<EventData> beforeMonitors, afterMonitors, insteadMonitors;

	private String owner;

	public MonitorClassAdapter(ClassVisitor classVisitor, List<EventPatternMatcher> matchers,
			Map<EventType, List<EventPatternMatcher>> mapped) {
		super(ASM5, classVisitor);

		this.matchers = matchers;
		this.mapped = mapped;
		this.matchesFrom = new HashMap<>(matchers.size());
		this.beforeMonitors = new ArrayList<>();
		this.afterMonitors = new ArrayList<>();
		this.insteadMonitors = new ArrayList<>();
	}

	@Override
	public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
		this.owner = name;
		cv.visit(version, access, name, signature, superName, interfaces);
	}

	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
		MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);

		if (mv != null) {
			LocalVariablesSorter lvs = new LocalVariablesSorter(access, desc, mv);
			mv = new MonitorMethodAdapter(owner, access, name, desc, mv, lvs, matchers, mapped, matchesFrom,
					beforeMonitors, afterMonitors, insteadMonitors);
		}

		return mv;
	}

}
