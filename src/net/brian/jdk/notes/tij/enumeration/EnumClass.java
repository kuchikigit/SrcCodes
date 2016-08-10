package net.brian.jdk.notes.tij.enumeration;

enum Shrubbery {
	GROUND, CRAWLING, HANGING
}

public class EnumClass {
	public static void main(String[] args) {
		for (Shrubbery s : Shrubbery.values()) {
			System.out.println("s + s.ordinal():: " + s + " ordinal: " + s.ordinal());
			System.out.println("s.compareTo(Shrubbery.CRAWLING):: " + s.compareTo(Shrubbery.CRAWLING) + " ");
			System.out.println("s.equals(Shrubbery.CRAWLING):: " + s.equals(Shrubbery.CRAWLING) + " ");
			System.out.println("s == Shrubbery.CRAWLING:: " + (s == Shrubbery.CRAWLING));
			System.out.println("s.getDeclaringClass():: " + s.getDeclaringClass());
			System.out.println("s.name():: " + s.name());
			System.out.println("----------------------");
		}
		// Produce an enum value from a string name:
		for (String s : "HANGING CRAWLING GROUND".split(" ")) {
			Shrubbery shrub = Enum.valueOf(Shrubbery.class, s);
			System.out.println("Enum.valueOf:: " + shrub);
		}
	}
}