/**
 * Copyright (C) 2014 Seagate Technology.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */
package kinetic.client.advanced;

import kinetic.client.ClientConfiguration;
import kinetic.client.KineticException;

import com.seagate.kinetic.client.internal.DefaultKineticClient;

/**
 * Kinetic advanced client boot-strap interface. This is the starting point for
 * the advanced Kinetic applications.
 * <p>
 * This factory class provides a static factory method to construct new
 * instances of <code>AdvancedKineticClient</code>.
 * <p>
 * Kinetic applications construct a new instance of
 * <code>ClientConfiguration</code> and set appropriate configurations (such as
 * server host/port) to the configuration instance. Applications then invoke the
 * static createInstance method to obtain a new instance of
 * AdvancedKineticClient.
 * 
 * @see AdvancedKineticClient
 * @see ClientConfiguration
 * 
 * @author Chiaming Yang
 * 
 */
public class AdvancedKineticClientFactory {

	/**
	 * Construct a new instance of the <code>AdvancedKineticClient</code>.
	 * 
	 * @param config
	 *            client configuration to create the client instance.
	 * @return a new AdvancedKineticClient instance that is connected to the
	 *         server.
	 * 
	 * @throws KineticException
	 *             if any internal errors occur.
	 */
	public static AdvancedKineticClient createAdvancedClientInstance(
			ClientConfiguration config)
					throws KineticException {
		return new DefaultKineticClient(config);
	}
}
