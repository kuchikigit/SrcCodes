package net.brian.jdk.notes.tij.string;

import org.junit.Test;

import static java.lang.System.out;
@LogAspect
public class StringDemo {
	private String variableParam(String... args) {
		String nullStr = null;
		String emptyStr = "";
		for(int i = 0; i < args.length; i++) {
			nullStr = nullStr + args[i];
			emptyStr = emptyStr + args[i];
		}
		//TODO To be implemented by net.brian.utils.LogAspect start.
		out.println("StringDemo -- variableParam -- emptyStr:: " + emptyStr);
		out.println("StringDemo -- variableParam -- nullStr:: " + nullStr);
		out.println("StringDemo -- variableParam -- args.length:: " + args.length);
		//TODO To be implemented by net.brian.utils.LogAspect end.
		return emptyStr;
	}
	
	@Test
	public void execute() {
		variableParam("Hello", " ", "World!");
	}
}
