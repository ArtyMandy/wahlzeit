/*Author: ArtyMandy, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: Cigarette
 *
 *Version information: adap-cw12  
 *
 * Date: 14. Jan. 2018
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
package org.wahlzeit.model;

public class Cigarette {

	protected CigaretteType cigaretteType = null;
	
	public Cigarette(CigaretteType cigtype) {
		
		cigaretteType = cigtype;
		
	}
	
	/**
	 * @MethodType get
	 */
	public CigaretteType getType() {
		return this.cigaretteType;
	}

}
