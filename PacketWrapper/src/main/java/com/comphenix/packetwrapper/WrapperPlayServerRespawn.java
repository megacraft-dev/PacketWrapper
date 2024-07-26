/**
 * PacketWrapper - ProtocolLib wrappers for Minecraft packets
 * Copyright (C) dmulloy2 <http://dmulloy2.net>
 * Copyright (C) Kristian S. Strangeland
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import org.bukkit.World;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;

public class WrapperPlayServerRespawn extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Server.RESPAWN;

	public WrapperPlayServerRespawn() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerRespawn(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve World.
	 *
	 * @return The current World
	 */
	public World getWorld() {
		return handle.getWorldKeys().read(0);
	}

	/**
	 * Set World.
	 *
	 * @param value - new value.
	 */
	public void setWorld(World value) {
		handle.getWorldKeys().write(0, value);
	}

	/**
	 * Retrieve Seed.
	 *
	 * @return The current Seed
	 */
	public long getSeed() {
		return this.handle.getLongs().read(0);
	}

	/**
	 * Set Seed.
	 *
	 * @param value - new value.
	 */
	public void setSeed(long value) {
		this.handle.getLongs().write(0, value);
	}

	/**
	 * Retrieve Gamemode.
	 * <p>
	 * Notes: 0: survival, 1: creative, 2: adventure, 3: spectator. The hardcore flag is not
	 * included
	 *
	 * @return The current Gamemode
	 */
	public NativeGameMode getGamemode() {
		return handle.getGameModes().read(0);
	}

	/**
	 * Set Gamemode.
	 *
	 * @param value - new value.
	 */
	public void setGamemode(NativeGameMode value) {
		handle.getGameModes().write(0, value);
	}

	/**
	 * Retrieve Previous gamemode.
	 * <p>
	 * Notes: 0: survival, 1: creative, 2: adventure, 3: spectator. The hardcore flag is not
	 * included. The previous gamemode.
	 *
	 * @return The previous Gamemode
	 */
	public NativeGameMode getPreviousGamemode() {
		return handle.getGameModes().read(1);
	}

	/**
	 * Set Previous gamemode.
	 *
	 * @param value - new value.
	 */
	public void setPreviousGamemode(NativeGameMode value) {
		handle.getGameModes().write(1, value);
	}

	/**
	 * Retrieve Debug.
	 *
	 * @return The current Debug
	 */
	public boolean getDebug() {
		return this.handle.getBooleans().read(0);
	}

	/**
	 * Set Debug.
	 *
	 * @param value - new value.
	 */
	public void setDebug(boolean value) {
		this.handle.getBooleans().write(0, value);
	}

	/**
	 * Retrieve Flat.
	 *
	 * @return The current Flat
	 */
	public boolean getFlat() {
		return this.handle.getBooleans().read(1);
	}

	/**
	 * Set Flat.
	 *
	 * @param value - new value.
	 */
	public void setFlat(boolean value) {
		this.handle.getBooleans().write(1, value);
	}

	/**
	 * Retrieve Copy Metadata.
	 *
	 * @return The current Copy Metadata
	 */
	public boolean getCopyMetadata() {
		return this.handle.getBooleans().read(2);
	}

	/**
	 * Set Copy Metadata.
	 *
	 * @param value - new value.
	 */
	public void setCopyMetadata(boolean value) {
		this.handle.getBooleans().write(2, value);
	}

}
