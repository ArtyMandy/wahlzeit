/*Author: ArtyMandy, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigaretteType
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

import java.util.HashSet;
import java.util.Set;
import org.wahlzeit.utils.*;

import org.wahlzeit.services.DataObject;

public class CigaretteType extends DataObject{

	protected CigaretteType superType = null;
	protected Set<CigaretteType> subTypes = new HashSet<CigaretteType>();
	
	private String typeName;
	private String brand;
	private String manufacturer;
	
	public CigaretteType(String typeName, String brand, String manufacturer) {
		Assertion.assertIsNotNull(typeName);
		Assertion.assertIsNotNull(brand);
		Assertion.assertIsNotNull(manufacturer);
		this.typeName = typeName;
		this.brand = brand;
		this.manufacturer = manufacturer;
	}
	/**
	 * @MethodType get
	 */
	public String getTypeName() {
		return this.typeName;
	}
	
	/**
	 * @MethodType get
	 */
	public String getBrand() {
		return this.brand;
	}
	
	/**
	 * @MethodType get
	 */
	public String getManufacturer() {
		return this.manufacturer;
	}
	
	/**
	 * @MethodType factory (create)
	 */
	public Cigarette createInstance() {
		return new Cigarette(this);
	}
	
	/**
	 * @MethodType get
	 */
	public CigaretteType getSuperType() {
		return superType;
	}
	
	/**
	 * @Methodtype set
	 */
	public void setSuperType(CigaretteType cigtype){
		this.superType = cigtype;
	}
	
	
	/**
	 * @Methodtype command
	 */
	public void addSubType(CigaretteType cigtype) {
		Assertion.assertIsNotNull(cigtype);
		cigtype.setSuperType(this);
		subTypes.add(cigtype);
	}
	
	/**
	 * @MethodType boolean query
	 */
	public boolean hasInstance(Cigarette cig) {
		Assertion.assertIsNotNull(cig);
		if(cig.getType() == this) {
			return true;
		}
		for(CigaretteType type : subTypes) {
			if(type.hasInstance(cig)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @MethodType boolean query
	 * 
	 * @return
	 */
	public boolean isSubType(CigaretteType cigType) {
		Assertion.assertIsNotNull(cigType);
		if(cigType.getSuperType() != null){
			return true;
		}
		return false;
	}

}
