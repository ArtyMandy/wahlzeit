/*Author: ArtyMandy, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigaretteObjectManager
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.wahlzeit.services.ObjectManager;

public class CigaretteObjectManager extends ObjectManager {

	private static CigaretteObjectManager cigaretteObjectManager = new CigaretteObjectManager();
	
	private List<CigaretteType> types = new ArrayList<CigaretteType>();
	private HashMap<Integer, Cigarette> cigarettes = new HashMap<Integer, Cigarette>();
	
	
	private CigaretteObjectManager() {
		
	}
	
	/**
	 * Singleton Access
	 */
	public static CigaretteObjectManager getInstance() {
		if(cigaretteObjectManager == null) {
			cigaretteObjectManager = new CigaretteObjectManager();
		}
		return cigaretteObjectManager;
	}
	
	/**
	 * @MethodType factory(create)
	 */
	public Cigarette createCigarette(String typeName) {
		CigaretteType cigtype = getCigaretteType(typeName);
		Cigarette instance = cigtype.createInstance();
		cigarettes.put(instance.hashCode(), instance);
		return instance;
		
	}
	
	/**
	 * @MethodType factory(create)
	 */
	public void createCigaretteType(String typeName, String brand, String manufacturer) {
		CigaretteType cigtype = new CigaretteType(typeName, brand, manufacturer);
		types.add(cigtype);
	}
	
	/**
	 * @MethodType query (get)
	 */
	public CigaretteType getCigaretteType(String typeName) {
		for(CigaretteType type : types) {
			if(type.getTypeName() == typeName) {
				return type;
			}
		}
		throw new IllegalArgumentException("Unknown CigaretteType, create the CigaretteType first");
	}
}
