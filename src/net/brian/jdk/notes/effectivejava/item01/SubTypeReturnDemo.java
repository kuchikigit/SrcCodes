package net.brian.jdk.notes.effectivejava.item01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SubTypeReturnDemo {
	public static List<String> returnArrayList(int capacity) {
		return new ArrayList<String>(capacity);
	}

	public static List<String> returnLinkedList() {
		return new LinkedList<String>();
	}

	// It looks like List list = new ArrayList(); It's typically polymorphism.
	A a = B.aReturnPrivateConstructor();
	// Is this polymorphism?
	C c = B.cReturnPrivateConstructor();
}

class C {
	protected void test() {
		System.out.println("C as super class - test()...");
	}
}

class B extends C implements A {

	private B() {
	}

	// We do have test method in super class which B has extended from C by
	// default
	// But we still need a test() to implement the method in A with the same
	// name
	// Or the compiler will show you an error like below:
	// The inherited method C.test() cannot hide the public abstract method in A
	// What's more, if we add @Override before, this is obviously a method that
	// override the test() in the super class, but why the compiler doesn't show
	// an error this time?
	@Override
	public void test() {

	}

	public static A aReturnPrivateConstructor() {
		return new B();
	}

	public static C cReturnPrivateConstructor() {
		return new C();
	}

}