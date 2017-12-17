package org.wahlzeit.utils;

public class Assertion {
		
		public static void assertIsNotNull(Object object) {
			if(object == null) {
				throw new IllegalArgumentException("argument is null");
			}
		}
		
		public static void assertIsValidDistance(double distance) {
			if(distance < 0.0) {
				throw new IllegalStateException("argument have to be bigger or equal 0.0");
			}
		}
		
		public static void assertIsValidDouble(double value) {
			if(Double.NaN == value 
					|| Double.NEGATIVE_INFINITY == value 
					|| Double.POSITIVE_INFINITY == value) {
				throw new IllegalArgumentException("argument is not valid it is NaN, NegativeInfinit or PositiveInfinit");
			}
		}
}
