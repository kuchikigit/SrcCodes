package net.brian.jdk.notes.tij.enumeration;

import net.brian.jdk.notes.tij.enumeration.Food.Appetizer;
import net.brian.jdk.notes.tij.enumeration.Food.Coffee;
import net.brian.jdk.notes.tij.enumeration.Food.Dessert;
import net.brian.jdk.notes.tij.enumeration.Food.MainCourse;

public class FoodTest {
	public static void main(String[] args) {
		Food food = Appetizer.SALAD;
		food = MainCourse.LASAGNE;
		food = Dessert.GELATO;
		food = Coffee.CAPPUCCINO;
	}
}
