/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigarettePhoto
 *
 *Version information: adap-cw05  
 *
 * Date: 8. Nov. 2017
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


import org.wahlzeit.utils.Assertion;
import com.googlecode.objectify.annotation.Subclass;


@Subclass
public class CigarettePhoto extends Photo {
	
	private Cigarette cigarette;
	
	/**
	 * @MethodType constructor
	 */
	public CigarettePhoto() {
		super();
	}
	
	/**
	 * @MethodType constructor
	 */
	public CigarettePhoto(PhotoId myId) {
		super(myId);
	}
	
	/**
	 * @MethodType constructor
	 */
	public CigarettePhoto(PhotoId myId, Cigarette cigarette) {
		super(myId);
		Assertion.assertIsNotNull(cigarette);
		this.cigarette = cigarette;
	}
	/**
	 * @MethodType get
	 */
	public Cigarette getCigarette() {
		return this.cigarette;
	}
	/**
	 * @MethodType set
	 */
	public void setCigarette(Cigarette cigarette) {
		this.cigarette = cigarette;
	}
}
