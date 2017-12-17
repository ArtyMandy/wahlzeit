/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: Assertion
 *
 *Version information: adap-cw10  
 *
 * Date: 17. Dez. 2017
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */
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
