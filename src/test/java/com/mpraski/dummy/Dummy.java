package com.mpraski.dummy;

import java.math.BigInteger;

import com.mpraski.jmonitor.InsteadAction;

public class Dummy {
	private String lel = "oh my my";
	private int lilp = 1;
	private int gosh = 2;
	private double mumbo = 123.545d;
	private long jumbo = 1234;

	private static String wop = "wop";

	public static void main(String[] args) {
		Dummy d = new Dummy();
		d.lol();
		d.lil();
		d.setLol();
		System.out.println("Showing int: " + d.writeInt());
		d.setLol2();
		System.out.println("Value of lel: " + d.lel);
		try {
			d.writeMumbo(false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("writeJumbo " + d.writeJumbo());
		d.readWop();
		System.out.println("writeObject " + d.writeObject());
		System.out.println("writeObject2 " + d.writeObject2());
		d.doCall();
		/*
		 * InsteadAction ia = new InsteadAction() {
		 * 
		 * @Override public Object doAction(Object[] arguments) { return
		 * d.someMethod((double) arguments[0], (boolean) arguments[1], (String)
		 * arguments[2], (int) arguments[3]); }
		 * 
		 * };
		 */
	}

	public void sayHello() {
		System.out.println("hello");
	}

	public String lol() {
		return lel;
	}

	public Integer lil() {
		String[] strings = new String[10];
		Integer wutt = new Integer(23);
		return lilp;
	}

	public void setLol() {
		this.lel = "lulu";
	}

	public void setLol2() {
		this.lel = "something";
	}

	public void setLis(int f) {
		this.lilp = Integer.parseInt("3");
	}

	public String readWop() {
		return wop;
	}

	public <T> T doShit(T args) {
		return args;
	}

	public void writeWop(String s) {
		wop = s;
	}

	public int writeInt() {
		return 52;
	}

	public double writeMumbo(boolean lol) throws Exception {
		if (lol)
			throw new Exception();

		synchronized (this) {
			mumbo = 234;
		}

		InsteadAction ia = new InsteadAction() {

			@Override
			public Object doAction(Object[] arguments) {
				return new BigInteger((String) arguments[0]);
			}

		};

		return mumbo;
	}

	public long writeJumbo() {
		return jumbo;
	}

	public Integer writeObject() {
		return new Integer(23);
	}

	public Integer writeObject2() {
		return new Integer(23);
	}

	public Object someMethod(double a, boolean b, String c, int d) {
		System.out.println("someMethod(" + a + ", " + b + ", " + c + ")");
		return null;
	}

	public void nothingToSay() {
		System.out.println("nope");
	}

	public String someMethod2(String a, int b, long c) {
		System.out.println("someMethod2(" + a + ", " + b + ", " + c + ")");
		return a;
	}

	public void doCall() {
		someMethod(12.543543, true, "asdsa", 40);
		nothingToSay();
		System.out.println(someMethod2("beta", 2, 20));
	}
}
