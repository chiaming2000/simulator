/**
 * 
 * Copyright (C) 2014 Seagate Technology.
 * 
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 *
 */
package com.seagate.kinetic.simulator.internal;

import java.util.Timer;

/**
 * 
 * 
 * @author chiaming
 */
class HeartbeatTimer {

	private Timer timer = null;

	public HeartbeatTimer() {

		timer = new Timer("Simulator-Heart-Beat", false);
	}


	/**
	 * called when thread service is shutdown (all simulator instances called
	 * close).
	 */
	public void notifyClose() {
		this.timer.cancel();
	}

}
