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

import com.comphenix.protocol.wrappers.BukkitConverters;
import org.bukkit.World;
import org.bukkit.entity.Entity;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.EnumWrappers.NativeGameMode;

import java.util.Set;

public class WrapperPlayServerLogin extends AbstractPacket {
	public static final PacketType TYPE = PacketType.Play.Server.LOGIN;

	public WrapperPlayServerLogin() {
		super(new PacketContainer(TYPE), TYPE);
		handle.getModifier().writeDefaults();
	}

	public WrapperPlayServerLogin(PacketContainer packet) {
		super(packet, TYPE);
	}

	/**
	 * Retrieve Entity ID.
	 * <p>
	 * Notes: entity's ID
	 * 
	 * @return The current Entity ID
	 */
	public int getEntityID() {
		return handle.getIntegers().read(0);
	}

	/**
	 * Set Entity ID.
	 * 
	 * @param value - new value.
	 */
	public void setEntityID(int value) {
		handle.getIntegers().write(0, value);
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param world - the current world of the entity.
	 * @return The spawned entity.
	 */
	public Entity getEntity(World world) {
		return handle.getEntityModifier(world).read(0);
	}

	/**
	 * Retrieve the entity of the painting that will be spawned.
	 * 
	 * @param event - the packet event.
	 * @return The spawned entity.
	 */
	public Entity getEntity(PacketEvent event) {
		return getEntity(event.getPlayer().getWorld());
	}

	/**
	 * Retrieve Hardcore.
	 *
	 * @return The current Hardcore
	 */
	public boolean isHardcore() {
		return this.handle.getBooleans().read(0);
	}

	/**
	 * Set Hardcore.
	 *
	 * @param value - new value.
	 */
	public void setHardcore(boolean value) {
		this.handle.getBooleans().write(0, value);
	}

	/**
	 * Retrieve Gamemode.
	 * <p>
	 * Notes: 0: survival, 1: creative, 2: adventure, 3: spectator.
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
	 * Notes: 0: survival, 1: creative, 2: adventure, 3: spectator. The hardcore flag is not included.
	 * The previous gamemode. Defaults to -1 if there is no previous gamemode.
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
	 * Retrieve Worlds.
	 *
	 * @return The current Worlds
	 */
	public Set<World> getWorlds() {
		return this.handle.getSets(BukkitConverters.getWorldConverter()).read(0);
	}

	/**
	 * Set Worlds.
	 *
	 * @param value - new value.
	 */
	public void setWorlds(Set<World> value) {
		this.handle.getSets(BukkitConverters.getWorldConverter()).write(0, value);
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
	 * Retrieve Max Players.
	 * <p>
	 * Notes: used by the client to draw the player list
	 * 
	 * @return The current Max Players
	 */
	public int getMaxPlayers() {
		return handle.getIntegers().read(2);
	}

	/**
	 * Set Max Players.
	 * 
	 * @param value - new value.
	 */
	public void setMaxPlayers(int value) {
		handle.getIntegers().write(2, value);
	}

	/**
	 * Retrieve View distance.
	 * <p>
	 * Notes: render distance (2-32).
	 *
	 * @return The current View distance
	 */
	public int getViewDistance() {
		return handle.getIntegers().read(3);
	}

	/**
	 * Set View distance.
	 *
	 * @param value - new value.
	 */
	public void setViewDistance(int value) {
		handle.getIntegers().write(3, value);
	}

	/**
	 * Retrieve Reduced Debug Info.
	 * 
	 * @return The current Reduced Debug Info
	 */
	public boolean getReducedDebugInfo() {
		return handle.getBooleans().read(1);
	}

	/**
	 * Set Reduced Debug Info.
	 * 
	 * @param value - new value.
	 */
	public void setReducedDebugInfo(boolean value) {
		handle.getBooleans().write(1, value);
	}

	/**
	 * Retrieve Enable respawn screen.
	 *
	 * @return The current Enable respawn screen
	 */
	public boolean getEnableRespawnScreen() {
		return this.handle.getBooleans().read(2);
	}

	/**
	 * Sets the value of field 'showDeathScreen'
	 *
	 * @param value - new value.
	 */
	public void setEnableRespawnScreen(boolean value) {
		this.handle.getBooleans().write(2, value);
	}

	/**
	 * Retrieve Debug.
	 *
	 * @return The current Debug
	 */
	public boolean getDebug() {
		return this.handle.getBooleans().read(3);
	}

	/**
	 * Set Debug.
	 *
	 * @param value - new value.
	 */
	public void setDebug(boolean value) {
		this.handle.getBooleans().write(3, value);
	}

	/**
	 * Retrieve Flat.
	 *
	 * @return The current Flat
	 */
	public boolean getFlat() {
		return this.handle.getBooleans().read(4);
	}

	/**
	 * Set Flat.
	 *
	 * @param value - new value.
	 */
	public void setFlat(boolean value) {
		this.handle.getBooleans().write(4, value);
	}
}
