/**
 * This file is part of PacketWrapper.
 * Copyright (C) 2012-2015 Kristian S. Strangeland
 * Copyright (C) 2015 dmulloy2
 *
 * PacketWrapper is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * PacketWrapper is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with PacketWrapper.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.comphenix.packetwrapper;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.utility.MinecraftReflection;
import com.comphenix.protocol.wrappers.BlockPosition;
import com.comphenix.protocol.wrappers.MinecraftKey;

public class WrapperPlayClientSetJigsaw extends AbstractPacket {

    public static final PacketType TYPE = PacketType.Play.Client.SET_JIGSAW;
    
    public WrapperPlayClientSetJigsaw() {
        super(new PacketContainer(TYPE), TYPE);
        handle.getModifier().writeDefaults();
    }
    
    public WrapperPlayClientSetJigsaw(PacketContainer packet) {
        super(packet, TYPE);
    }
    
    /**
     * Retrieve Location.
     * <p>
     * Notes: block entity location
     * @return The current Location
     */
    public BlockPosition getLocation() {
        return handle.getBlockPositionModifier().read(0);
    }
    
    /**
     * Set Location.
     * @param value - new value.
     */
    public void setLocation(BlockPosition value) {
        handle.getBlockPositionModifier().write(0, value);
    }
    
    /**
     * Retrieve Name.
     * @return The current Name
     */
    public MinecraftKey getName() {
        return handle.getMinecraftKeys().read(0);
    }
    
    /**
     * Set Attachment type.
     * @param value - new value.
     */
    public void setName(MinecraftKey value) {
        handle.getMinecraftKeys().write(0, value);
    }
    
    /**
     * Retrieve Target.
     * @return The current Target
     */
    public MinecraftKey getTarget() {
        return handle.getMinecraftKeys().read(1);
    }
    
    /**
     * Set Target.
     * @param value - new value.
     */
    public void setTarget(MinecraftKey value) {
        handle.getMinecraftKeys().write(1, value);
    }

    /**
     * Retrieve Pool.
     * @return The current Pool
     */
    public MinecraftKey getPool() {
        return handle.getMinecraftKeys().read(2);
    }

    /**
     * Set Pool.
     * @param value - new value.
     */
    public void setPool(MinecraftKey value) {
        handle.getMinecraftKeys().write(2, value);
    }

    /**
     * Retrieve Final state.
     * <p>
     * Notes: "Turns into" on the GUI, final_state in NBT
     * @return The current Final state
     */
    public String getFinalState() {
        return handle.getStrings().read(0);
    }
    
    /**
     * Set Final state.
     * @param value - new value.
     */
    public void setFinalState(String value) {
        handle.getStrings().write(0, value);
    }

    /**
     * Retrieve Joint type.
     * <p>
     * Notes: rollable if the attached piece can be rotated, else aligned.
     * @return The current Joint type
     */
    public JointType getJointType() {
        return handle.getEnumModifier(JointType.class, MinecraftReflection.getMinecraftClass("TileEntityJigsaw$JointType")).readSafely(0);
    }

    /**
     * Set Joint type.
     * @param value - new value.
     */
    public void setMode(JointType value) {
        handle.getEnumModifier(JointType.class, MinecraftReflection.getMinecraftClass("TileEntityJigsaw$JointType")).writeSafely(0, value);
    }

    public enum JointType {
        ROLLABLE,
        ALIGNED;
    }

}
