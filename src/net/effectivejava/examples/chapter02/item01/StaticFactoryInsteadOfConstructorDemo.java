package net.effectivejava.examples.chapter02.item01;

import java.io.File;

public class StaticFactoryInsteadOfConstructorDemo {
	public StaticFactoryInsteadOfConstructorDemo(String param1, int param2, String param3) {
		param2 = 2;
		File file1 = new File(param1);
		File file3 = new File(param3);
		System.out.println(param2 + " files loaded...");
	}
	
	public StaticFactoryInsteadOfConstructorDemo(String param1, String param2, int param3) {
		
	}
	
	public StaticFactoryInsteadOfConstructorDemo() {
		
	}

	public void demo1() {
		new StaticFactoryInsteadOfConstructorDemo();
	}

	private static void demo2() {
		new StaticFactoryInsteadOfConstructorDemo();
		System.out.println("StaticFactoryInsteadOfConstructorDemo -- demo2()");
	}

	public static void main(String[] args) {
		// StaticFactoryInsteadOfConstructorDemo demo = new StaticFactoryInsteadOfConstructorDemo();
		// demo.demo1();
		// demo.demo2(); // Not recommended.
		demo2();
		demo2();
		demo2();
	}
}
