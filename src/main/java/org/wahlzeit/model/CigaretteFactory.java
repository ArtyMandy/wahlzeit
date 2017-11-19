/*Author: Artur Mandybura, https://github.com/ArtyMandy/wahlzeit
 *
 *Class: CigaretteFactory
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

import java.util.logging.Logger;

import org.wahlzeit.services.LogBuilder;

import com.googlecode.objectify.annotation.Subclass;

@Subclass
public class CigaretteFactory extends PhotoFactory {
	
	private static final Logger log = Logger.getLogger(PhotoFactory.class.getName());
	
	private static CigaretteFactory instance = null;
	
	public CigaretteFactory() {
		
	}
	/**
	 * Public singleton access method.
	 */
	public static synchronized CigaretteFactory getInstance() {
		if (instance == null) {
			log.config(LogBuilder.createSystemMessage().addAction("setting generic CigaretteFactory").toString());
			setInstance(new CigaretteFactory());
		}
		return instance;
	}
	
	protected static synchronized void setInstance(CigaretteFactory photoFactory) {
		if (instance != null) {
			throw new IllegalStateException("attempt to initalize PhotoFactory twice");
		}

		instance = photoFactory;
	}
	/**
	 * MethodType: factory
	 */
	@Override
	public Photo createPhoto() {
		return new CigarettePhoto();
	}
	
	/**
	 * MethodType: factory
	 */
	@Override
	public Photo createPhoto(PhotoId id) {
		return new CigarettePhoto(id);
	}
	

}
